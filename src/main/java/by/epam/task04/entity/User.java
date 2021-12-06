package by.epam.task04.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * The type User.
 */
public class User implements Serializable, BaseEntity {

    private static final long serialVersionUID = 4958483859493859385L;

    private String username;
    private String password;
    private Role role;

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param username the username
     * @param password the password
     * @param role     the role
     */
    public User(Integer id, String username, String password, Role role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    /**
     * Instantiates a new User.
     *
     * @param id      the id
     * @param balance the balance
     */
    public User(Integer id, BigDecimal balance) {
        this.id = id;
    }

    /**
     * Instantiates a new User.
     *
     * @param id       the id
     * @param username the username
     * @param password the password
     */
    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        User user = (User) obj;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 17;
        result = prime * result + id;
        result = prime * result + username.hashCode();
        result = prime * result + password.hashCode();
        result = prime * result + role.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User : " +
                "id=" + id +
                ", login='" + username +
                ", password=" + password +
                ", role=" + role;
    }
}
