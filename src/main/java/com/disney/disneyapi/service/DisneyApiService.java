package com.disney.disneyapi.service;

import com.disney.disneyapi.dto.response.CharactersDTOResponse;

import java.util.List;
import java.util.UUID;

public interface DisneyApiService {
    List<CharactersDTOResponse> findCharacters();

    List<CharactersDTOResponse> searchCharacters(String name, Integer age, UUID idMovie);
}
