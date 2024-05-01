package br.rpe.cadastropessoa.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@Getter
@Setter
public abstract class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 5685723107175298455L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Size(min = 4, max = 50)
    @Column(nullable = false)
    private String nome;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Endereco endereco;

    @Column(length = 16, nullable = false)
    private String telefone;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(getId(), pessoa.getId()) && Objects.equals(getCpf(), pessoa.getCpf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCpf());
    }
}
