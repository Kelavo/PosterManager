package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.domain.PosterRepository;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PosterManager {
    private PosterRepository repository;
    public PosterManager (PosterRepository repository) {this.repository = repository;}

    public void add(Movie item) {repository.save(item);}
    public void removeAll(){repository.removeAll();}
}



