package vn.vnpay.persistenjpa.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import vn.vnpay.persistenjpa.config.EntityManagerFactoryConfig;
import vn.vnpay.persistenjpa.dto.UserDTO;
import vn.vnpay.persistenjpa.entity.User;
import vn.vnpay.persistenjpa.search.ObjectSearch;
import vn.vnpay.persistenjpa.dao.UserDAO;
import vn.vnpay.persistenjpa.search.UserSearch;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import java.util.List;


@Service
@Slf4j
public class UserDAOImpl implements UserDAO {

    private static final String CREATE_USER ="USER_CREATE";
    private static final String GET_BY_ID = "USER_GET_BY_ID";
    private static final String GET_BY_USER_NAME ="USER_GET_BY_USER_NAME";
    private static final String GET_BY_FILTER ="USER_GET_BY_FILTER";
    private static final String USER_CREATE ="USER_CREATE";
    private static final String USER_UPDATE ="USER_UPDATE";

    @Autowired
    private PasswordEncoder passwordEncoder;

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
            log.error("Call store procedure exception");
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
            return (User) storedProcedure.getResultList().get(0);
        } catch (Exception exp) {
            log.error("Call store procedure exception");
            return null;
        }
    }

    @Override
    public List<User> getByFilter(UserSearch objectSearch) {
        try {
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(GET_BY_FILTER, User.class);
            storedProcedure.registerStoredProcedureParameter("PI_KEYWORD", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_ROLE_ID", Long.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_STATUS", Integer.class, ParameterMode.IN);
            storedProcedure.setParameter("PI_KEYWORD", objectSearch.getKeyword());
            storedProcedure.setParameter("PI_ROLE_ID", objectSearch.getRoleId());
            storedProcedure.setParameter("PI_STATUS", objectSearch.getStatus());
            return  storedProcedure.getResultList();
        } catch (Exception exp) {
            log.error("Call store procedure exception");
            return null;
        }
    }

    @Override
    public User create(UserDTO userDTO) {

        try {
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(USER_CREATE, User.class);
            storedProcedure.registerStoredProcedureParameter("PI_USER_NAME", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_PASSWORD", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_FULL_NAME", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_EMAIL", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_ROLE_ID", Long.class, ParameterMode.IN);

            storedProcedure.setParameter("PI_USER_NAME", userDTO.getUsername());
            storedProcedure.setParameter("PI_PASSWORD", passwordEncoder.encode(userDTO.getPassword()));
            storedProcedure.setParameter("PI_FULL_NAME", userDTO.getFullName());
            storedProcedure.setParameter("PI_EMAIL", userDTO.getEmail());
            storedProcedure.setParameter("PI_ROLE_ID", userDTO.getRoleId());

            return (User)  storedProcedure.getResultList().get(0);

        } catch (Exception exp) {
            log.error("Call store procedure exception");
            return null;
        }
    }

    @Override
    public User update(UserDTO userDTO) {

        try {
            EntityManager entityManager = EntityManagerFactoryConfig.getInstance().createEntityManager();
            if (entityManager == null) {
                log.error("Can't create entityManager");
            }
            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery(USER_CREATE, User.class);
            storedProcedure.registerStoredProcedureParameter("PI_ID", Long.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_USER_NAME", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_PASSWORD", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_FULL_NAME", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_EMAIL", String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_ROLE_ID", Long.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter("PI_STATUS", Integer.class, ParameterMode.IN);

            storedProcedure.setParameter("PI_ID", userDTO.getId());
            storedProcedure.setParameter("PI_USER_NAME", userDTO.getUsername());
            if (userDTO.getPassword() == null || userDTO.getPassword() == ""){
                storedProcedure.setParameter("PI_PASSWORD",  null);
            }else{
                storedProcedure.setParameter("PI_PASSWORD", passwordEncoder.encode(userDTO.getPassword()));
            }
            storedProcedure.setParameter("PI_FULL_NAME", userDTO.getFullName());
            storedProcedure.setParameter("PI_EMAIL", userDTO.getEmail());
            storedProcedure.setParameter("PI_ROLE_ID", userDTO.getRoleId());
            storedProcedure.setParameter("PI_STATUS", userDTO.getStatus());

            return (User)  storedProcedure.getResultList().get(0);

        } catch (Exception exp) {
            log.error("Call store procedure exception");
            return null;
        }
    }
}
