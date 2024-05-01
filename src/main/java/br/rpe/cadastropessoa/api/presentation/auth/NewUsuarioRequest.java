package br.rpe.cadastropessoa.api.presentation.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewUsuarioRequest {

    private String nome;
    private String login;
    private String senha;
}