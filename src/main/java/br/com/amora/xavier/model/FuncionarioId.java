package br.com.amora.xavier.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public class FuncionarioId implements Serializable {
    private static final long serialVersionUID = 1L;

    public FuncionarioId() { }

    public FuncionarioId(long id, long codigo, String nome, String cep, String rg, String cpf) {
        super();
        this.codigo = codigo;
    }

    @Getter
    @Setter
    private long id;

    @Getter
    @Setter
    private long codigo;

    @Column(length = 63)
    @Getter
    @Setter
    private String nome;

    @Column(length = 9)
    @Getter
    @Setter
    private String cep;

    @Column(length = 20)
    @Getter
    @Setter
    private String cpf;

    @Column(length = 20)
    @Getter
    @Setter
    private String rg;
}
