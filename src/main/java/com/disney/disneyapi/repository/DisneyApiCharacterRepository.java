package com.disney.disneyapi.repository;

import com.disney.disneyapi.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DisneyApiCharacterRepository extends JpaRepository<CharacterEntity, UUID> {


    @Query("SELECT c FROM CharacterEntity c JOIN c.movies m " +
            "WHERE (:name IS NULL OR LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) " +
            "AND (:age IS NULL OR c.age = :age) " +
            "AND (:movieId IS NULL OR m.id = :movieId)")
    List<CharacterEntity> searchByFilters(@Param("name") String name, @Param("age") Integer age, @Param("movieId") UUID movieId);
}
