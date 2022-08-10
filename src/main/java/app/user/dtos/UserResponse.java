package app.user.dtos;

import app.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class UserResponse {


    private Integer userId;
    private String email;
    private String username;

    private String password;
    private Integer role;

    private List<String> favoriteComicsId;


    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.email = user.getEmail();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.role = user.getRoleId();

    }
}
