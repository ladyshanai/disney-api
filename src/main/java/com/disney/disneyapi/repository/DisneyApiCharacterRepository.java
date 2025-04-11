package com.disney.disneyapi.repository;

import com.disney.disneyapi.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisneyApiCharacterRepository extends JpaRepository<CharacterEntity, Long> {
    List<CharacterEntity> findByNameContainingIgnoreCase(String name);
}
