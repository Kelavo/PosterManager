package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Movie;
import ru.netology.domain.PosterRepository;

@Data
@NoArgsConstructor
//@AllArgsConstructor

public class PosterManager {
    private int limit = 10;
    private PosterRepository repository;

    public PosterManager(PosterRepository repository) {
        this.repository = repository;
    }

    public void add(Movie item) {
        repository.save(item);
    }

    public void removeAll() {
        repository.removeAll();
    }

    public void removeById() {
        repository.removeById(2);
    }

    public void findById() {
        repository.findById(1);
    }

    public Movie[] findAll() {
        Movie[] tmp = repository.findAll();
        return tmp;
    }

    public Movie[] findLast() {
        int length;
        Movie[] items = repository.findAll();
        if (limit <= items.length) {
            length = limit;
        } else {
            length = items.length;
        }
        Movie[] tmp = new Movie[length];
        for (int i = 0; i < length; i++) {
            tmp[i] = items[items.length - i - 1];
        }
        Movie[] result = tmp;
        return result;
    }

}






