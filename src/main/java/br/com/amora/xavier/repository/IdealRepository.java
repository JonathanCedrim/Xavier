package br.com.amora.xavier.repository;

import br.com.amora.xavier.model.Ideal;
import br.com.amora.xavier.model.Movimento;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IdealRepository extends JpaRepository<Ideal, Long> {

    @Query("SELECT i FROM Ideal i WHERE i.codigo = :codigoIdeal")
    Ideal getIdealByCodigo(@Param("codigoIdeal") long codigoIdeal);

    @Query("SELECT i FROM Ideal i WHERE i.vendedor.codigo = :codigoVendedor")
    List<Ideal> getIdealsByVendedor(@Param("codigoVendedor") long codigoVendedor);

    @Query("SELECT i FROM Ideal i WHERE i.dataInicial >= :dataInicial AND i.dataInicial <= :dataFinal OR i.dataFinal >= :dataInicial AND dataFinal <= :dataFinal")
    List<Ideal> getIdealByData(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

    @Query("SELECT i FROM Ideal i WHERE i.vendedor.codigo = :codigoVendedor AND (i.dataInicial >= :dataInicial AND i.dataInicial <= :dataFinal OR i.dataFinal >= :dataInicial AND i.dataFinal <= :dataFinal)")
    List<Ideal> getIdealByVendedorAndData(@Param("codigoVendedor") long codigoVendedor, @Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

    @Query("SELECT i FROM Ideal i WHERE i.dataLancamento >= :dataInicial AND i.dataLancamento <= :dataFinal")
    List<Ideal> getIdealByDataLancamento(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);
}
