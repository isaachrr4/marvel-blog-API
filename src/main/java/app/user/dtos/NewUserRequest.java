package app.user.dtos;

import app.user.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Data
@NoArgsConstructor
public class NewUserRequest {

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 3)
    private String username;

    @Size(min = 3)
    private String password;


    public User extractResource() {
        return new User(email, username, password);
    }



}
