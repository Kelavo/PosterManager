package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    PosterManager manager = new PosterManager();

    @Test
    void shouldShowEmptyPosterNoMovies() {

        String[] actual = manager.findAll();
        String[] expected = manager.getMovies();
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    void shouldShowAllPosters() {
        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");
        manager.add("6");
        manager.add("7");
        manager.add("8");
        manager.add("9");
        manager.add("10");
        manager.add("11");

        String[] actual = manager.findAll();
        String[] expexted = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
        Assertions.assertArrayEquals(actual, expexted);
    }

    @Test
    void shouldShowLastPosters() {
        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");

        String[] actual = manager.findLast();
        String[] expexted = {"5", "4", "3", "2", "1"};
        Assertions.assertArrayEquals(actual, expexted);
    }

    @Test
    void shouldShowLastPostersLimit() {
        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");
        manager.add("6");
        manager.add("7");
        manager.add("8");
        manager.add("9");
        manager.add("10");
        manager.add("11");

        String[] actual = manager.findLast();
        String[] expexted = {"11", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        Assertions.assertArrayEquals(actual, expexted);
    }

    @Test
    void ShouldCutLimitShowLastPosters() {
        PosterManager manager = new PosterManager(5);
        manager.add("1");
        manager.add("2");
        manager.add("3");
        manager.add("4");
        manager.add("5");
        manager.add("6");

        String[] actual = manager.findLast();
        String[] expexted = {"6", "5", "4", "3", "2"};
        Assertions.assertArrayEquals(actual, expexted);
    }

}

