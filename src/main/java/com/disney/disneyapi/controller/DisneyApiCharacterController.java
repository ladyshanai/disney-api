package com.disney.disneyapi.controller;

import com.disney.disneyapi.dto.response.CharactersDTOResponse;
import com.disney.disneyapi.service.DisneyApiService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/characters")
public class
DisneyApiCharacterController {
    private final DisneyApiService disneyApiService;

    public DisneyApiCharacterController(DisneyApiService disneyApiService) {
        this.disneyApiService = disneyApiService;
    }

    @GetMapping()
    public ResponseEntity<List<CharactersDTOResponse>> findCharacters() throws Exception {
        List<CharactersDTOResponse> response = disneyApiService.findCharacters();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value= "/filter")
    public ResponseEntity<List<CharactersDTOResponse>> searchByFilters(@RequestParam(required = false) String name,
                                                                           @RequestParam(required = false) Integer age,
                                                                           @RequestParam(required = false) UUID idMovie) throws Exception {
        List<CharactersDTOResponse> response = disneyApiService.searchCharacters(name, age, idMovie);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

