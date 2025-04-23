package com.disney.disneyapi.mapper;

import com.disney.disneyapi.dto.response.CharactersDTOResponse;
import com.disney.disneyapi.entity.CharacterEntity;

public class CharacterMapper {
    public static CharactersDTOResponse entityToResponse(CharacterEntity characterEntity) {
        CharactersDTOResponse charactersDTOResponse = new CharactersDTOResponse();
        charactersDTOResponse.setNombre(characterEntity.getName());
        charactersDTOResponse.setImageUrl(characterEntity.getImageUrl());
        return charactersDTOResponse;
    }

}
