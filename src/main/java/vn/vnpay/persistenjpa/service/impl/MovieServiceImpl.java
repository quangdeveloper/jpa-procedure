package vn.vnpay.persistenjpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;
import vn.vnpay.persistenjpa.config.EntityManagerConfig;
import vn.vnpay.persistenjpa.entity.Movie;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.service.MovieService;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;

@Slf4j
@Service
public class MovieServiceImpl implements MovieService {


    private final String MOVIE_GET_ALL = "MOVIE_GET_ALL";
    private final String MOVIE_GET_BY_FILTER = "MOVIE_GET_BY_FILTER";

    @Override
    public List<Movie> getAllMovie() {

        try {
            EntityManager entityManager = EntityManagerConfig.getEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }

            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(MOVIE_GET_ALL, Movie.class);
            return storedProcedure.getResultList();

        } catch (Exception exp) {
            return null;
        }

    }

    @Override
    public List<Movie> getByFilterMovie(ObjectSearch objectSearch) {
        try {
            EntityManager entityManager = EntityManagerConfig.getEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }

            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(MOVIE_GET_BY_FILTER, Movie.class);
            storedProcedure.registerStoredProcedureParameter("S_KEYWORD", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("N_YEAR", Integer.class, ParameterMode.IN);

            storedProcedure.setParameter("S_KEYWORD", objectSearch.getKeyword());
            storedProcedure.setParameter("N_YEAR", objectSearch.getYear());

            return storedProcedure.getResultList();

        } catch (Exception exp) {
            return null;
        }

    }
}
