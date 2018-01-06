package br.com.amora.xavier.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@EqualsAndHashCode
public abstract class Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(length = 2)
    @Getter
    @Setter
    private String sigla;

    @Column(length = 20)
    @Getter
    @Setter
    private String municipio;

    @Column(length = 9)
    @Getter
    @Setter
    private String cep;

    @Getter
    @Setter
    private String bairro;

    @Column(length = 63)
    @Getter
    @Setter
    private String endereco;

    @Column(length = 10)
    @Getter
    @Setter
    private String numero;

    @Column(length = 20)
    @Getter
    @Setter
    private String cidade;

    @Column(length = 20)
    @Getter
    @Setter
    private String telefone;

    @Column(length = 20)
    @Getter
    @Setter
    private String operadora;

    @Column(length = 20, unique = true)
    @Getter
    @Setter
    private String celular;

    @Column(length = 20)
    @Getter
    @Setter
    private String operadoraII;

    @Column(length = 20, unique = true)
    @Getter
    @Setter
    private String celularII;

    @Column(length = 70, unique = true)
    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private Date dataNascimento;

    @Getter
    @Setter
    private long salario;
}
