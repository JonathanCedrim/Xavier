package br.com.amora.xavier.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(length = 60)
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

    @Column(length = 60, unique = true)
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


    @Column(length = 60)
    @Getter
    @Setter
    private String observacao;

    @Column(length = 60)
    @Getter
    @Setter
    private String conjugue;

    @Column(length = 30)
    @Getter
    @Setter
    private String municipio;

    @Column(length = 2)
    @Getter
    @Setter
    private String sigla;

    @Column(length = 30)
    @Getter
    @Setter
    private String bairro;

    @Column(length = 60)
    @Getter
    @Setter
    private String endereco;

    @Column(length = 10)
    @Getter
    @Setter
    private String numero;

    @Column(length = 60)
    @Getter
    @Setter
    private String referencia;

    @Column(length = 60)
    @Getter
    @Setter
    private String telefone;

    @Getter
    @Setter
    private String operadora;

    @Column(length = 60, unique = true)
    @Getter
    @Setter
    private String celular;

    @Getter
    @Setter
    private String operadoraII;

    @Column(length = 60, unique = true)
    @Getter
    @Setter
    private String celularII;

    @Column(length = 60)
    @Getter
    @Setter
    private Date dataCadastro;

    @Column(length = 1)
    @Getter
    @Setter
    private String selecionado;

    @Column(length = 4)
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
    @OneToMany(mappedBy = "vendedor")
    @JsonBackReference
    private List<Movimento> movimentos;
}