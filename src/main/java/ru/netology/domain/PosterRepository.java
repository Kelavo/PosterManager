package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class PosterRepository  {
    private Movie[] items = new Movie[0];

    public void save(Movie item) {
        Movie[] tmp = new Movie[items.length + 1];
        for (int i = 0; i < items.length; i++) {
            tmp[i] = items[i];
        }
        tmp[tmp.length - 1] = item;
        items = tmp;
    }

    public Movie[] findAll() {return items;}

    public void removeById (int id) {
        Movie[] tmp = new Movie[items.length - 1];
        int index = 0;
        for (Movie item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index ++;
            }
        }
        items = tmp;
    }

    public Movie[] removeAll() {
        Movie[] tmp = new Movie[0];
        items = tmp;
        return tmp;
    }

    public Movie findById (int id) {
        for (Movie item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
