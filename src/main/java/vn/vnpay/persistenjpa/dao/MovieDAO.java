package vn.vnpay.persistenjpa.dao;

import vn.vnpay.persistenjpa.dto.MovieDTO;
import vn.vnpay.persistenjpa.entity.Movie;
import vn.vnpay.persistenjpa.search.MovieSearch;
import vn.vnpay.persistenjpa.search.ObjectSearch;

import java.util.List;

public interface MovieDAO {

    List<Movie> getAllMovie();
    List<Movie> getByFilterMovie(MovieSearch objectSearch);
    Movie createMovie(MovieDTO movieDTO);
    Movie updateMovie(MovieDTO movieDTO);
}
