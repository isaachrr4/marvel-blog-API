package app.auth.dtos;

import app.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AuthResponse {

    private Integer userAuthId;

    private String username;
    private Integer userAuthRole;

    public AuthResponse(User user) {
        this.userAuthId = user.getUserId();
        this.userAuthRole = user.getRoleId();
        this.username = user.getUsername();
    }

    public AuthResponse(Integer userAuthId, Integer userAuthRole, String username) {
        this.userAuthId = userAuthId;
        this.userAuthRole = userAuthRole;
        this.username = username;
    }

}
