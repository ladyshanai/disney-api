package com.disney.disneyapi.controller;

import com.disney.disneyapi.dto.response.CharactersDTOResponse;
import com.disney.disneyapi.service.DisneyApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class
DisneyApiCharacterController {
    private final DisneyApiService disneyApiService;

    public DisneyApiCharacterController(DisneyApiService disneyApiService) {
        this.disneyApiService = disneyApiService;
    }

    @GetMapping(value= "/characters")
    public ResponseEntity<List<CharactersDTOResponse>> findCharacters() throws Exception {
        List<CharactersDTOResponse> response = disneyApiService.findCharacters();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

