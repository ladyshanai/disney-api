package com.disney.disneyapi.service;

import com.disney.disneyapi.dto.response.CharactersDTOResponse;
import com.disney.disneyapi.entity.CharacterEntity;
import com.disney.disneyapi.excepcion.CharacterNotFoundException;
import com.disney.disneyapi.mapper.CharacterMapper;
import com.disney.disneyapi.repository.DisneyApiCharacterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class DisneyApiServiceImpl implements DisneyApiService{
    private static final Logger log = LoggerFactory.getLogger(DisneyApiServiceImpl.class);
    private final DisneyApiCharacterRepository disneyApiCharacterRepository;

    public DisneyApiServiceImpl(DisneyApiCharacterRepository disneyApiCharacterRepository) {
        this.disneyApiCharacterRepository = disneyApiCharacterRepository;
    }

    @Override
    public List<CharactersDTOResponse> findCharacters() {
        List<CharacterEntity> characterEntities = disneyApiCharacterRepository.findAll();
        if (characterEntities.isEmpty())
            throw new CharacterNotFoundException("Characters not found");
        return characterEntities.stream().map(CharacterMapper::entityToResponse).collect(Collectors.toList());
    }

    @Override
    public List<CharactersDTOResponse> searchCharacters(String name, Integer age, UUID idMovie) {
        List<CharacterEntity> characterEntities = disneyApiCharacterRepository.searchByFilters(name, age, idMovie);
        if (characterEntities.isEmpty())
            throw new CharacterNotFoundException("Character not found");
        return characterEntities.stream().map(CharacterMapper::entityToResponse).collect(Collectors.toList());
    }
}
