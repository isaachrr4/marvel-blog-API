package app.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.auth.dtos.AuthResponse;
import app.auth.dtos.AuthRequest;
import app.util.exceptions.AuthenticationException;

import javax.transaction.Transactional;
import javax.validation.Valid;


@Service
@Transactional
public class AuthService {

    private final AuthRepository authRepo;

    @Autowired
    public AuthService(AuthRepository authRepo) {
        this.authRepo =authRepo;
    }

    public AuthResponse authenticateUserCred(@Valid AuthRequest authRequest) {
        return authRepo.findUserByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword())
                .map(AuthResponse::new)
                .orElseThrow(AuthenticationException::new);
    }
}
