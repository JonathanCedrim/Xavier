package br.com.amora.xavier.repository;

import br.com.amora.xavier.model.Entidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EntidadeRepository extends JpaRepository<Entidade, Long> {

    @Query("SELECT e FROM Entidade e WHERE e.nome LIKE %:nome%")
    List<Entidade> findEntidadeByNome(@Param("nome") String nome);

    @Query("SELECT e FROM Entidade e WHERE e.codigo = :codigoEntidade")
    Entidade findEntidadeByCodigo(@Param("codigoEntidade") long codigoEntidade);

    @Query("SELECT e FROM Entidade e WHERE e.telefone = :telefone")
    List<Entidade> findEntidadesByTelefone(@Param("telefone") String telefone);

    @Query("SELECT e FROM Entidade e WHERE e.celular = :celular")
    List<Entidade> findEntidadeByCelular(@Param("celular") String celular);

    @Query("SELECT e FROM Entidade e WHERE e.celularII = :celularII")
    List<Entidade> findEntidadeByCelularII(@Param("celularII") String celularII);

    @Query("SELECT e FROM Entidade e WHERE e.email = :email")
    List<Entidade> findEntidadeByEmail(@Param("email") String email);
}
