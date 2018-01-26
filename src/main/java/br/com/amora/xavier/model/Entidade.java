package br.com.amora.xavier.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Entidade implements Serializable {
    private static final long SerialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private long codigo;

    @Getter
    @Setter
    @OneToMany(mappedBy = "entidade")
    private List<Conta> contas;

    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String telefone;

    @Getter
    @Setter
    private String operadora;

    @Getter
    @Setter
    private String celular;

    @Getter
    @Setter
    private String operadoraII;

    @Getter
    @Setter
    private String celularII;

    @Getter
    @Setter
    private String observacao;
}
