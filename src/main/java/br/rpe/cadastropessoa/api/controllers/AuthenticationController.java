package br.rpe.cadastropessoa.api.controllers;

import br.rpe.cadastropessoa.api.presentation.auth.AuthRequest;
import br.rpe.cadastropessoa.api.presentation.auth.AuthResponse;
import br.rpe.cadastropessoa.api.presentation.auth.NewUsuarioRequest;
import br.rpe.cadastropessoa.business.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> cadastrar(@RequestBody NewUsuarioRequest request) {
        authenticationService.cadastrar(request);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthResponse> register(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}