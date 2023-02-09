package com.example.webclient;
import com.example.webclient.models.RickAndMortyCharacter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
public class RickAndMortyController {
    private final RickAndMortyApiService rickAndMortyApiService;

    public RickAndMortyController(RickAndMortyApiService rickAndMortyApiService) {
        this.rickAndMortyApiService = rickAndMortyApiService;
    }

    @GetMapping("characters")
    public List<RickAndMortyCharacter> getAllCharacters() {
        return rickAndMortyApiService.getAllCharacters();
    }
    @GetMapping("characters-by-status")
    public List<RickAndMortyCharacter> getCharacterByStatus(@RequestParam String status) {
        return rickAndMortyApiService.getCharacterByStatus(status);
    }
}
