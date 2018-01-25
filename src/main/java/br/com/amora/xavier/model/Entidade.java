package br.com.amora.xavier.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    private String telefone;

    @Getter
    @Setter
    private String observacao;
}
