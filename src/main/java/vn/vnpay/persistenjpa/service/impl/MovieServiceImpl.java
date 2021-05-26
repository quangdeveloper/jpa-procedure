package vn.vnpay.persistenjpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.vnpay.persistenjpa.config.EntityManagerFactoryConfig;
import vn.vnpay.persistenjpa.dto.MovieDTO;
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
    private final String MOVIE_CREATE = "MOVIE_CREATE";
    private final String MOVIE_UPDATE = "MOVIE_UPDATE";

    @Override
    public List<Movie> getAllMovie() {

        try {
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
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
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }

            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(MOVIE_GET_BY_FILTER, Movie.class);
            storedProcedure.registerStoredProcedureParameter("PI_KEYWORD", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_YEAR", Integer.class, ParameterMode.IN);

            storedProcedure.setParameter("PI_KEYWORD", objectSearch.getKeyword());
            storedProcedure.setParameter("PI_YEAR", objectSearch.getYear());

            return storedProcedure.getResultList();

        } catch (Exception exp) {
            return null;
        }
    }

    @Override
    public Movie createMovie(MovieDTO movieDTO) {

        try {
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }

            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(MOVIE_CREATE, Movie.class);
            storedProcedure.registerStoredProcedureParameter("PI_NAME", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_LANGUAGE", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_YEAR", Integer.class, ParameterMode.IN);

            storedProcedure.setParameter("PI_NAME", movieDTO.getName());
            storedProcedure.setParameter("PI_LANGUAGE", movieDTO.getLanguage());
            storedProcedure.setParameter("PI_YEAR", movieDTO.getReleaseYear());
            List<Movie> list = storedProcedure.getResultList();
            return list.get(0);

        } catch (Exception exp) {
            return null;
        }
    }@Override
    public Movie updateMovie(MovieDTO movieDTO) {

        try {
             EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }
            log.error("Can't create entityManager");
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(MOVIE_UPDATE, Movie.class);
            storedProcedure.registerStoredProcedureParameter("PI_ID", Long.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_NAME", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_LANGUAGE", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_YEAR", Integer.class, ParameterMode.IN);

            storedProcedure.setParameter("PI_ID", movieDTO.getId());
            storedProcedure.setParameter("PI_NAME", movieDTO.getName());
            storedProcedure.setParameter("PI_LANGUAGE", movieDTO.getLanguage());
            storedProcedure.setParameter("PI_YEAR", movieDTO.getReleaseYear());
            List<Movie> list = storedProcedure.getResultList();
            return list.get(0);

        } catch (Exception exp) {
            return null;
        }
    }
}
