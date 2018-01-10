package br.com.amora.xavier.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@EqualsAndHashCode
public class Vendedor extends Funcionario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private long id;//FKge2n40m7bl1smfffx9jveymmu
    
    @Getter
    @Setter
    private long codigo;

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

    @Getter
    @Setter
    @OneToMany(mappedBy = "vendedor")
    @JsonBackReference
    private List<Cliente> clientes;

    @Getter
    @Setter
    @OneToMany(mappedBy = "vendedor")
    @JsonIgnore
    private List<Movimento> movimentos;

    @Getter
    @Setter
    private String observacao;

    @Getter
    @Setter
    private String registroInicial;

    @Getter
    @Setter
    private String registroFinal;

    @Getter
    @Setter
    private String pedidoInicial;

    @Getter
    @Setter
    private String pedidoFinal;
}
