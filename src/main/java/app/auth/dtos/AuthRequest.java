package app.auth.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;



@Data
@NoArgsConstructor
public class AuthRequest {

    @Length(min = 3, max = 15)
    private String username;

    private String password;
}
