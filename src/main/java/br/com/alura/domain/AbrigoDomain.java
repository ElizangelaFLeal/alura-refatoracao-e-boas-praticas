package br.com.alura.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbrigoDomain {
    private Long id;
    private String nome;
    private String telefone;
    private String email;
    private PetDomain[] pets;

    public AbrigoDomain() {
    }

    public AbrigoDomain(String nome, String telefone, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }
}
