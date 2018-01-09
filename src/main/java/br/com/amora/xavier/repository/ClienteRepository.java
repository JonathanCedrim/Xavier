package br.com.amora.xavier.repository;

import br.com.amora.xavier.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
    List<Cliente> findClienteByNome(@Param("nome") String nome);

    @Query("SELECT c FROM Cliente c WHERE c.codigo = :codigoCliente AND c.vendedor.codigo = :codigoVendedor")
    Cliente findClienteByCodigo(@Param("codigoVendedor") long codigoVendedor, @Param("codigoCliente") long codigoCliente);

    @Query("SELECT c FROM Cliente c WHERE c.rg = :rg")
    Cliente findClienteByRG(@Param("rg") String rg);

    @Query("SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    Cliente findClienteByCPF(@Param("cpf") String cpf);

    @Query("SELECT c FROM Cliente c WHERE c.cep = :cep")
    List<Cliente> findClientesByCEP(@Param("cep") String cep);

    @Query("SELECT c FROM Cliente c WHERE c.telefone = :telefone")
    List<Cliente> findClientesByTelefone(@Param("telefone") String telefone);

    @Query("SELECT c FROM Cliente c WHERE c.celular = :celular")
    Cliente findClienteByCelular(@Param("celular") String celular);

    @Query("SELECT c FROM Cliente c WHERE c.celularII = :celularII")
    Cliente findClienteByCelularII(@Param("celularII") String celularII);

    @Query("SELECT c FROM Cliente c WHERE c.email = :email")
    List<Cliente> findClienteByEmail(@Param("email") String email);

    @Query("SELECT c FROM Cliente c WHERE c.vendedor.codigo = :codigoVendedor")
    List<Cliente> getClientesDoVendedor(@Param("codigoVendedor") long codigoVendedor);
}
