package app.auth;

import app.auth.dtos.AuthResponse;
import app.auth.dtos.AuthRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping()
    public AuthResponse authenticate(@RequestBody AuthRequest authReq, HttpServletResponse resp) {
        AuthResponse payload = authService.authenticateUserCred(authReq);
        resp.setHeader("AuthUser", authReq.getUsername());
        return payload;
    }
}
