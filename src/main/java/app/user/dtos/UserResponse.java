package app.user.dtos;

import app.Comic.Comic;
import app.user.User;
import io.micrometer.core.instrument.Tags;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

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
        this.favoriteComicsId = user.getFavoriteComicsId().stream().map(Comic::getComicid).collect(Collectors.toList());


    }
}
