package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@NoArgsConstructor
@AllArgsConstructor

public class PosterManager {

    private String[] movies = new String[0];
    private int limit;

    public PosterManager() {
        limit = 10;
    }

    public PosterManager(int limit) {
        this.limit = limit;
    }

    void add(String film) {
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = film;
        movies = tmp;
    }

    public String[] findAll() {
        return movies;
    }

    public String[] findLast() {
        String[] resultLength;
        if (limit < movies.length) {
            resultLength = new String[limit];
        } else {
            resultLength = new String[movies.length];
        }
        for (int i = 0; i < resultLength.length; i++) {
            resultLength[i] = movies[movies.length - i - 1];
        }
        return resultLength;
    }

}



