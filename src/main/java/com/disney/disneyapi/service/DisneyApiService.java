package com.disney.disneyapi.service;

import com.disney.disneyapi.dto.response.CharactersDTOResponse;

import java.util.List;

public interface DisneyApiService {
    List<CharactersDTOResponse> findCharacters();
}
