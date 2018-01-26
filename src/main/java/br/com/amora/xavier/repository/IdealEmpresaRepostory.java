package br.com.amora.xavier.repository;

import br.com.amora.xavier.model.IdealEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface IdealEmpresaRepostory extends JpaRepository<IdealEmpresa, Long> {

    @Query("SELECT i FROM IdealEmpresa i WHERE i.codigo = :codigo")
    IdealEmpresa findIdealEmpresaEmpresaByCodigo(@Param("codigo") long codigo);

    @Query("SELECT i FROM IdealEmpresa i WHERE i.codigo = :codigoIdealEmpresa")
    IdealEmpresa getIdealEmpresaByCodigo(@Param("codigoIdealEmpresa") long codigoIdealEmpresa);

    @Query("SELECT i FROM IdealEmpresa i WHERE i.dataInicial >= :dataInicial AND i.dataInicial <= :dataFinal OR i.dataFinal >= :dataInicial AND dataFinal <= :dataFinal")
    List<IdealEmpresa> getIdealEmpresaByData(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

    @Query("SELECT i FROM IdealEmpresa i WHERE i.dataLancamento >= :dataInicial AND i.dataLancamento <= :dataFinal")
    List<IdealEmpresa> getIdealEmpresaByDataLancamento(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

}
