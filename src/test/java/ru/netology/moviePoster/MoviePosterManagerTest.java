package ru.netology.moviePoster;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MoviePosterManagerTest {

    @Test
    public void shouldFindAllWithNull() { // вывод всех фильмов, когда они не добавлены в массив
        MoviePosterManager manager = new MoviePosterManager();

        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllWithOne() { // вывод всех фильмов, когда добавлен только один
        MoviePosterManager manager = new MoviePosterManager();

        manager.addMovie("Бладшот");

        String[] expected = {"Бладшот"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllWithTwo() { // вывод всех фильмов, когда добавлены только два
        MoviePosterManager manager = new MoviePosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");

        String[] expected = {"Бладшот", "Вперёд"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllWithThree() { // вывод всех фильмов, когда добавлены только три
        MoviePosterManager manager = new MoviePosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] expected = {"Бладшот", "Вперёд", "Отель Белград"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastDefault() { // вывод в обратном порядке количества фильмов по умолчанию
        MoviePosterManager manager = new MoviePosterManager();

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastInLimit() { // вывод в обратном порядке, количество фильмов равно лимиту
        MoviePosterManager manager = new MoviePosterManager(3);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastBelowLimit() { // вывод в обратном порядке, количество фильмов меньше лимита
        MoviePosterManager manager = new MoviePosterManager(6);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперёд", "Бладшот"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastAboveLimit() {
        MoviePosterManager manager = new MoviePosterManager(2);

        manager.addMovie("Бладшот");
        manager.addMovie("Вперёд");
        manager.addMovie("Отель Белград");

        String[] expected = {"Отель Белград", "Вперёд"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}