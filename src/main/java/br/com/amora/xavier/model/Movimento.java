package br.com.amora.xavier.model;

import com.fasterxml.jackson.annotation.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@EqualsAndHashCode
public class Movimento implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Getter
    @Setter
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    @ManyToOne
    private Cliente cliente;

    @Getter
    @Setter
    private long codigoCliente;

    @Getter
    @Setter
    private Date dataCadastro;

    @Getter
    @Setter
    private long numeroRecibo;

    @Getter
    @Setter
    private long numeroPedido;

    @Getter
    @Setter
    private long valorCompra;

    @Getter
    @Setter
    private long valorRecebido;

    @Getter
    @Setter
    private long saldo;

    @Getter
    @Setter
    private Date dataPagamento;

    @Getter
    @Setter
    private Date dataPagamentoII;

    @Getter
    @Setter
    private String observacao;
}
