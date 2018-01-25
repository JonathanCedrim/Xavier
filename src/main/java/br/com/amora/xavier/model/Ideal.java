package br.com.amora.xavier.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
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
    private long totalRecebido;

    @Getter
    @Setter
    private long ideal;

    @Getter
    @Setter
    @Column(precision=8, scale = 4)
    private BigDecimal sobra;

    @Getter
    @Setter
    private String responsavel;
}
