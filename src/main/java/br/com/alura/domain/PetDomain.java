package br.com.alura.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PetDomain{
        private Long id;
        private String tipo;
        private String nome;
        private String raca;
        private Integer idade;
        private String cor;
        private Double peso;

        public PetDomain() {
        }

        public PetDomain(String tipo, String nome, String raca, Integer idade, String cor, Double peso) {
            this.tipo = tipo;
            this.nome = nome;
            this.raca = raca;
            this.idade = idade;
            this.cor = cor;
            this.peso = peso;
        }
}
