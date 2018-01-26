package br.com.amora.xavier.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode
public class Conta implements Serializable {

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
    @ManyToOne
    private Entidade entidade;

    @Getter
    @Setter
    @Column(precision = 4, scale = 2)
    private long valorConta;

    @Getter
    @Setter
    @Column(precision = 4, scale = 2)
    private long valorPago;

    @Getter
    @Setter
    private Date dataInicial;

    @Getter
    @Setter
    private Date dataFinal;

    @Getter
    @Setter
    private Date dataPagamento;

    @Getter
    @Setter
    private Date dataLancamento;

    @Getter
    @Setter
    private String observacao;

    @Getter
    @Setter
    private boolean pago;
}
