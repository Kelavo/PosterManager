package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Movie;
import ru.netology.domain.PosterRepository;

public class PosterManagerTest {

    PosterRepository repo = new PosterRepository();
    PosterManager manager = new PosterManager(repo);

    @Test

    void add() {
    }
}

