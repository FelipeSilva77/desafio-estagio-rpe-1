package br.rpe.cadastropessoa.business.service;

import br.rpe.cadastropessoa.api.presentation.auth.AuthRequest;
import br.rpe.cadastropessoa.api.presentation.auth.AuthResponse;
import br.rpe.cadastropessoa.api.presentation.auth.NewUsuarioRequest;
import br.rpe.cadastropessoa.domain.entity.Usuario;
import br.rpe.cadastropessoa.domain.enums.Role;
import br.rpe.cadastropessoa.domain.repository.UsuarioRepository;
import br.rpe.cadastropessoa.infrastructure.auth.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UsuarioRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(
            UsuarioRepository userRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService,
            AuthenticationManager authenticationManager
    ) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthResponse cadastrar(NewUsuarioRequest request) {
        var user = Usuario.builder()
                .nome(request.getNome())
                .login(request.getLogin())
                .senha(passwordEncoder.encode(request.getSenha()))
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getLogin(),
                        request.getSenha()));
        var user = userRepository.findByLogin(request.getLogin()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(jwtToken)
                .build();
    }

}