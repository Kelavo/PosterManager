package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.domain.Movie;
import ru.netology.domain.PosterRepository;

import static org.mockito.Mockito.doReturn;

public class PosterManagerTestNonEmpty {

    private PosterRepository repository = Mockito.mock(PosterRepository.class);
    private PosterManager manager = new PosterManager(repository);
    Movie first = new Movie(1, "1+1");
    Movie second = new Movie(2, "Вверх");
    Movie third = new Movie(3, "Джентельмены");

    @Test
    public void shouldAddPosters() {
        Movie[] returned = {first, second, third};
        doReturn(returned).when(repository).findAll();

        Movie[] expected = {first, second, third};
        Movie[] actual = manager.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

}
