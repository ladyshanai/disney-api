package com.disney.disneyapi.repository;

import com.disney.disneyapi.entity.GenreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisneyApiGenreRepository extends JpaRepository<GenreEntity, Long> {

}
