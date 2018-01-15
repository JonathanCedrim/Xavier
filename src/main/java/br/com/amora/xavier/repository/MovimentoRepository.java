package br.com.amora.xavier.repository;

import br.com.amora.xavier.model.Movimento;
import br.com.amora.xavier.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

    @Query("SELECT m FROM Movimento m WHERE m.codigo = :codigo")
    Movimento findMovimentoByCodigo(Long codigo);

    @Query("SELECT m FROM Movimento m WHERE m.vendedor.codigo = :codigoVendedor")
    List<Movimento> getMovimentosDoVendedor(@Param("codigoVendedor") long codigoVendedor);

    @Query("SELECT m FROM Movimento m WHERE m.cliente.codigo = :codigoCliente")
    List<Movimento> getMovimentosDoCliente(@Param("codigoCliente") long codigoCliente);

    @Query("SELECT m FROM Movimento m WHERE m.numeroRecibo = :numeroRecibo")
    Movimento findMovimentoByNumeroRecibo(@Param("numeroRecibo") Long numeroRecibo);

    @Query("SELECT m FROM Movimento m WHERE m.numeroPedido = :numeroPedido")
    Movimento findMovimentoBynumeroPedido(@Param("numeroPedido") Long numeroPedido);

    @Query("SELECT m FROM Movimento m WHERE m.vendedor.codigo = :codigoVendedor AND m.cliente.codigo = :codigoCliente")
    List<Movimento> findMovimentoByCodigoVendedorAndCodigoCliente(@Param("codigoVendedor") long codigoVendedor, @Param("codigoCliente") long codigoCliente);

    @Query("SELECT m FROM Movimento m WHERE m.vendedor.codigo = :codigoVendedor AND (m.dataPagamento >= :dataPagamento AND m.dataPagamento <= :dataPagamentoII OR m.dataPagamentoII >= :dataPagamento AND m.dataPagamentoII <= :dataPagamentoII)")
    List<Movimento> findMovimentoByVendedorAndData(@Param("codigoVendedor") long codigoVendedor, @Param("dataPagamento") Date dataPagamento, @Param("dataPagamentoII") Date dataPagamentoII);
}
