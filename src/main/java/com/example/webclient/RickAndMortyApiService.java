package com.example.webclient;

import com.example.webclient.models.RickAndMortyCharacter;
import com.example.webclient.models.RickAndMortyResponseElement;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RickAndMortyApiService {
    private WebClient webClient = WebClient.create("https://rickandmortyapi.com/api");


    public List<RickAndMortyCharacter> getAllCharacters() {
        RickAndMortyResponseElement rickAndMortyResponseElement =
                Objects.requireNonNull(webClient.get()
                                .uri("/character/")
                                .retrieve()
                                .toEntity(RickAndMortyResponseElement.class)
                                .block())
                        .getBody();

        return rickAndMortyResponseElement.getResults();
    }

    public List<RickAndMortyCharacter> getCharacterByStatus(String status) {
        RickAndMortyResponseElement rickAndMortyResponseElement =
                Objects.requireNonNull(webClient.get()
                                .uri("/character?status="+ status)
                                .retrieve()
                                .toEntity(RickAndMortyResponseElement.class)
                                .block())
                        .getBody();
        return rickAndMortyResponseElement.getResults();
    }
}
