package com.saproject.bancosa.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contas", uniqueConstraints = {
        @UniqueConstraint(columnNames = "cpf"),
        @UniqueConstraint(columnNames = "rg"),
        @UniqueConstraint(columnNames = "email")
})
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private final String agencia = "1321";
    private String numeroConta;

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @Min(value = 0, message = "Idade deve ser um número positivo.")
    private int idade;
    @Schema(example = "email@email.com.br")
    @Email(message = "Email deve ser válido.")
    private String email;

    @NotBlank(message = "Senha é obrigatória.")
    private String senha;

    @NotBlank(message = "CPF é obrigatório.")
    private String cpf;

    @NotBlank(message = "RG é obrigatório.")
    private String rg;

    @NotBlank(message = "Telefone é obrigatório.")
    private String telefone;

    @NotBlank(message = "CEP é obrigatório.")
    private String cep;

    private String endereco;

    @Enumerated(EnumType.STRING)
    private TipoConta tipoConta;

    private double saldo = 0.0;

    private boolean ativo = true;

    public boolean podeRealizarOperacao() {
        return ativo && saldo > 0;
    }


    public enum TipoConta {
        CORRENTE, POUPANCA
    }
}
