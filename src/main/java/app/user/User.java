package app.user;

import app.Comic.Comic;
import io.micrometer.core.instrument.Tags;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Comparable<User> {

    @Id
    @Column(name = "userid", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "pw", nullable = false)
    private String password;

    @Column(name = "roleid", nullable = false)
    private Integer roleId;

    @OneToMany(mappedBy = "user")
    @JoinTable(
            name = "UserFavoriteComics",
            joinColumns = @JoinColumn(name = "userid"),
            inverseJoinColumns = @JoinColumn(name = "comicid"))
    private List<Comic> favoriteComics;


    public User(Integer userId, String email, String username, String password, Integer roleId, List<Comic> favoriteComics) {
        this.userId = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.favoriteComics = favoriteComics;

    }

    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(String email, String username, String password, Integer roleId) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.roleId = roleId;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", favoriteComics=" + favoriteComics +

                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public List<Comic> getFavoriteComicsId() {
        return favoriteComics;
    }

    public void setFavoriteComics(List<Comic> favoriteComics) {
        this.favoriteComics = favoriteComics;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }


    @Override
    public int compareTo(User o) {
        if (this == o) return 0;
        if (getUserId() != 0) {
            return getUsername().compareTo(o.getUsername());
        } else {
            return -1;
        }
    }

}