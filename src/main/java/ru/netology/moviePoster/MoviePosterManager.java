package ru.netology.moviePoster;

public class MoviePosterManager {
    private String[] movies = new String[0]; // пустой массив фильмов афиши
    private int limit; // лимит вывода добавленных фильмов

    public MoviePosterManager() { // конструктор лимита вывода фильмов по умолчанию
        this.limit = 5;
    }

    public MoviePosterManager(int limit) { // конструктор лимита вывода фильмов
        this.limit = limit;
    }

    public void addMovie(String movie) { // метод добавления фильмов в афишу
        String[] tmp = new String[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public String[] findAll() { // метод вывода всех фильмов в порядке добавления
        return movies;
    }

    public String[] findLast() { // метод вывода лимита фильмов в порядке, обратном добавлению
        int resultLength;
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }
        String[] tmp = new String[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }
}
