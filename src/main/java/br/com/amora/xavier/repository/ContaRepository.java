package br.com.amora.xavier.repository;

import br.com.amora.xavier.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ContaRepository extends JpaRepository<Conta, Long> {

    @Query("SELECT c FROM Conta c WHERE c.nome LIKE %:nome%")
    public List<Conta> findContasByNome(@Param("nome") String nome);

    @Query("SELECT c FROM Conta c WHERE c.codigo = :codigo")
    public Conta findContaByCodigo(@Param("codigo") long codigo);

    @Query("SELECT c FROM Conta c WHERE c.entidade.codigo = :codigoEntidade")
    public List<Conta> findContasByEntidade(@Param("codigo") long codigoEntidade);

    @Query("SELECT c FROM Conta c WHERE c.dataLancamento >= :dataInicial AND c.dataLancamento <= :dataFinal")
    public List<Conta> findContasByDataLancamento(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

    @Query("SELECT c FROM Conta c WHERE c.dataPagamento >= :dataInicial AND c.dataPagamento <= :dataFinal")
    public List<Conta> findContasByDataPagamento(@Param("dataInicial") Date dataInicial, @Param("dataFinal") Date dataFinal);

    @Query("SELECT c FROM Conta c WHERE c.pago = :status")
    public List<Conta> findCotnasByPago(@Param("status") boolean status);
}
