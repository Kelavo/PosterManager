package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.domain.PosterRepository;

public class PosterManagerTest {
    Movie first = new Movie(1, "1+1");
    Movie second = new Movie(2, "Вверх");
    Movie third = new Movie(3, "Джентельмены");

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

}

