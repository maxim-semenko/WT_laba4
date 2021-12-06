package by.epam.task04.service;

import by.epam.task04.entity.User;
import by.epam.task04.exception.RepositoryException;
import by.epam.task04.exception.ServiceException;
import by.epam.task04.dao.creator.RepositoryCreator;
import by.epam.task04.dao.impl.UserRepository;
import by.epam.task04.specification.common.FindById;
import by.epam.task04.specification.user.FindByUsername;
import by.epam.task04.specification.user.FindByUsernameAndPassword;

import java.util.Optional;

/**
 * The type User service.
 */
public class UserService {

    /**
     * Find by username and password optional.
     *
     * @param username the username
     * @param password the password
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<User> findByUsernameAndPassword(String username, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsernameAndPassword(username, password));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    /**
     * Find by id optional.
     *
     * @param id the id
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<User> findById(Integer id) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindById(id));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    /**
     * Find by username optional.
     *
     * @param username the username
     * @return the optional
     * @throws ServiceException the service exception
     */
    public Optional<User> findByUsername(String username) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            return userRepository.query(new FindByUsername(username));
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

    /**
     * Sign up user.
     *
     * @param id       the id
     * @param username the username
     * @param password the password
     * @throws ServiceException the service exception
     */
    public void signUpUser(Integer id, String username, String password) throws ServiceException {
        try (RepositoryCreator repositoryCreator = new RepositoryCreator()) {
            UserRepository userRepository = repositoryCreator.getUserRepository();
            User user = new User(id, username, password);
            userRepository.save(user);
        } catch (RepositoryException ex) {
            throw new ServiceException(ex.getMessage());
        }
    }

}
