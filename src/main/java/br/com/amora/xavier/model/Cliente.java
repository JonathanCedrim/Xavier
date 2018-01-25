package br.com.amora.xavier.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;

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
    private String nome;

    @Column(length = 20, unique = true)
    @Getter
    @Setter
    private String rg;

    @Column(length = 20, unique = true)
    @Getter
    @Setter
    private String cpf;

    @Getter
    @Setter
    private String email;

    @Column(length = 9)
    @Getter
    @Setter
    private String cep;

    @Column(length = 20)
    @Getter
    @Setter
    private String estadoCivil;

    @Getter
    @Setter
    private Date dataNascimento;

    @Getter
    @Setter
    private String observacao;

    @Getter
    @Setter
    private String conjugue;

    @Getter
    @Setter
    private String municipio;

    @Column(length = 2)
    @Getter
    @Setter
    private String sigla;

    @Getter
    @Setter
    private String bairro;

    @Getter
    @Setter
    private String endereco;

    @Getter
    @Setter
    private String numero;

    @Getter
    @Setter
    private String referencia;

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
    private Date dataCadastro;

    @Column(length = 1)
    @Getter
    @Setter
    private String selecionado;

    @Column(length = 1)
    @Getter
    @Setter
    private String spc;

    @Getter
    @Setter
    @ManyToOne
    @JsonIgnore
    @JsonBackReference
    private Vendedor vendedor;

    @Getter
    @Setter
    @OneToMany(mappedBy= "cliente")
    @JsonIgnore
    private List<Movimento> movimentos;

    @Getter
    @Setter
    @Column(precision = 4, scale = 2)
    private long saldo;

}