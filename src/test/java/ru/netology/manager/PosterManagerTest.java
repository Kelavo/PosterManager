package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.domain.PosterRepository;

public class PosterManagerTest {
    Movie first = new Movie(1, "1+1");
    Movie second = new Movie(2, "Вверх");
    Movie third = new Movie(3, "Джентельмены");
    Movie fourth = new Movie(4, "Гладиатор");
    Movie fifth = new Movie(5, "1917");
    Movie sixth = new Movie(6, "Тайна Коко");
    Movie seventh = new Movie(7, "Девушка с татуировкой дракона");
    Movie eighth = new Movie(8, "1+2");
    Movie ninth = new Movie(9, "Хоббит");
    Movie tenth = new Movie(10, "Лига выдающихся джентльменов");
    Movie eleventh = new Movie(11, "Малефисента");

    PosterRepository repo = new PosterRepository();
    PosterManager manager = new PosterManager(repo);

    @Test
    void shouldAddPoster() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        Movie[] actual = repo.findAll();
        Movie[] expected = {first, second, third};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void shouldFindById() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        Movie actual = repo.findById(2);
        Movie expected = (second);
        Assertions.assertEquals(actual, expected);

    }

    @Test
    void shouldRemoveById() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeById(2);

        Movie[] actual = repo.findAll();
        Movie[] expected = {first, third};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void shouldRemoveAll() {
        repo.save(first);
        repo.save(second);
        repo.save(third);

        repo.removeAll();

        Movie[] actual = repo.findAll();
        Movie[] expected = {};
        Assertions.assertArrayEquals(actual, expected);

    }

    @Test
    void shouldFindLastPosters() {
        repo.save(first);
        repo.save(second);
        repo.save(third);
        repo.save(fourth);
        repo.save(fifth);
        repo.save(sixth);
        repo.save(seventh);
        repo.save(eighth);
        repo.save(ninth);
        repo.save(tenth);
        repo.save(eleventh);

        Movie[] actual = manager.findLast();
        Movie[] expected = {eleventh, tenth, ninth, eighth, seventh, sixth, fifth, fourth, third, second};
        Assertions.assertArrayEquals(actual, expected);
    }

}

