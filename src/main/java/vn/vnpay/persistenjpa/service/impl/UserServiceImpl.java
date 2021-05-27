package vn.vnpay.persistenjpa.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import vn.vnpay.persistenjpa.config.EntityManagerFactoryConfig;
import vn.vnpay.persistenjpa.dto.MovieDTO;
import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.entity.Movie;
import vn.vnpay.persistenjpa.entity.User;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


@Service
@Slf4j
public class UserServiceImpl  implements UserService {

    private static final String CREATE_USER ="USER_CREATE";
    private static final String GET_BY_ID = "USER_GET_BY_ID";
    private static final String GET_BY_USER_NAME ="USER_GET_BY_USER_NAME";
    private  static final String GET_USER_NAME_AND_PASSWORD ="USER_GET_BY_USER_NAME_AND_PASS";

    @Override
    public User getById(Long id) {
        try {
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(GET_BY_ID, User.class);
            storedProcedure.registerStoredProcedureParameter("PI_ID", Long.class, ParameterMode.IN);
            storedProcedure.setParameter("PI_ID", id);
            return  (User) storedProcedure.getSingleResult();
        } catch (Exception exp) {
            return null;
        }
    }

    @Override
    public User getByUserName(String username) {
        try {
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(GET_BY_USER_NAME, User.class);
            storedProcedure.registerStoredProcedureParameter("PI_USER_NAME", String.class, ParameterMode.IN);
            storedProcedure.setParameter("PI_USER_NAME", username);
            return  (User) storedProcedure.getSingleResult();
        } catch (Exception exp) {
            return null;
        }
    }

    @Override
    public User getByUserNameAndPassword(String username, String password) {
        try {
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(GET_BY_USER_NAME, User.class);
            storedProcedure.registerStoredProcedureParameter("PI_USER_NAME", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_PASSWORD", String.class, ParameterMode.IN);
            storedProcedure.setParameter("PI_USER_NAME", username);
            storedProcedure.setParameter("PI_PASSWORD", password);
            return  (User) storedProcedure.getSingleResult();
        } catch (Exception exp) {
            return null;
        }
    }

    @Override
    public List<User> getByFilter(ObjectSearch objectSearch) {
        return null;
    }

    @Override
    public User create(UserDTO userDTO) {
        return null;
    }

    @Override
    public User update(UserDTO userDTO) {
        return null;
    }
}
