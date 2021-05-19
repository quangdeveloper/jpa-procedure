package vn.vnpay.persistenjpa.service;

import vn.vnpay.persistenjpa.entity.Movie;
import vn.vnpay.persistenjpa.search.ObjectSearch;

import java.util.List;

public interface MovieService {

    List<Movie> getAllMovie();
    List<Movie> getByFilterMovie(ObjectSearch objectSearch);
}
