package br.com.amora.xavier.repository;

import br.com.amora.xavier.model.Vendedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VendedorRepository extends JpaRepository<Vendedor, Long> {

    @Query("SELECT v FROM Vendedor v WHERE v.nome LIKE %:nome%")
    List<Vendedor> findVendedorByNome(@Param("nome") String nome);

    @Query("SELECT v FROM Vendedor v WHERE v.codigo = :codigo")
    Vendedor findVendedorByCodigo(@Param("codigo") Long codigo);


    @Query("SELECT v FROM Vendedor v WHERE v.rg = :rg")
    Vendedor findVendedorByRG(@Param("rg") String rg);

    @Query("SELECT v FROM Vendedor v WHERE v.cpf = :cpf")
    Vendedor findVendedorByCPF(@Param("cpf") String cpf);


    @Query("SELECT COUNT(v) FROM Vendedor v")
    Long getTotalVendedor();

}
