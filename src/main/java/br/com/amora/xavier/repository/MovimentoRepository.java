package br.com.amora.xavier.repository;

import br.com.amora.xavier.model.Movimento;
import br.com.amora.xavier.model.Movimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovimentoRepository extends JpaRepository<Movimento, Long> {

    @Query("SELECT m FROM Movimento m WHERE m.codigo = :codigo")
    Movimento findMovimentoByCodigo(Long codigo);

    @Query("SELECT m FROM Movimento m WHERE m.vendedor.id = :codigoVendedor")
    List<Movimento> getMovimentosDoVendedor(@Param("codigoVendedor") long codigoVendedor);

    @Query("SELECT m FROM Movimento m WHERE m.cliente.id = :codigoCliente")
    List<Movimento> getMovimentosDoCliente(@Param("codigoCliente") long codigoCliente);

    @Query("SELECT m FROM Movimento m WHERE m.numeroRecibo = :numeroRecibo")
    Movimento findMovimentoByNumeroRecibo(@Param("numeroRecibo") Long numeroRecibo);

    @Query("SELECT m FROM Movimento m WHERE m.numeroPedido = :numeroPedido")
    Movimento findMovimentoBynumeroPedido(@Param("numeroPedido") Long numeroPedido);


}
