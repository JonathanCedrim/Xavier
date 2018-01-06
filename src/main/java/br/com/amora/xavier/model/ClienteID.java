package br.com.amora.xavier.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
@EqualsAndHashCode
public abstract class ClienteID implements Serializable {


    public ClienteID() { }

    public ClienteID(long codigo, String nome, String rg, String cpf, String cep) {
        super();
        this.codigo = codigo;
        this.nome = nome;
        this.rg = rg;
        this.cpf = cpf;
        this.cep = cep;
    }

    @Getter
    @Setter
    private long codigo;

    @Column(length = 60)
    @Getter
    @Setter
    private String nome;

    @Column(length = 20)
    @Getter
    @Setter
    private String rg;

    @Column(length = 20)
    @Getter
    @Setter
    private String cpf;

    @Column(length = 9)
    @Getter
    @Setter
    private String cep;

}
