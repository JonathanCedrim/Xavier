package br.com.amora.xavier.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode
public class Ideal implements Serializable {
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
    @ManyToOne
    private Vendedor vendedor;

    @Getter
    @Setter
    private Date dataLancamento;

    @Getter
    @Setter
    private Date dataInicial;

    @Getter
    @Setter
    private Date dataFinal;

    @Getter
    @Setter
    private int totalRecebido;

    @Getter
    @Setter
    private int ideal;

    @Getter
    @Setter
    private double sobra;

    @Getter
    @Setter
    private String responsavel;
}
