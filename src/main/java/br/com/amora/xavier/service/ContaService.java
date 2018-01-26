package br.com.amora.xavier.service;

import br.com.amora.xavier.model.Conta;
import br.com.amora.xavier.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    public Conta getContaById(long id) {
        return this.contaRepository.getOne(id); }

    public Conta getContaByCodigo(long codigo) {
        return this.contaRepository.findContaByCodigo(codigo);}

    public List<Conta> getContaByEntidade(long codigoEntidade) {
        return this.contaRepository.findContasByEntidade(codigoEntidade);
    }

    public List<Conta> getContaByDataLancamento(Conta conta) {
        return this.contaRepository.findContasByDataLancamento(conta.getDataInicial(), conta.getDataFinal());
    }

    public List<Conta> getContaByDataPagamento(Conta conta) {
        return this.contaRepository.findContasByDataPagamento(conta.getDataInicial(), conta.getDataFinal());
    }

    public List<Conta> getAllIdealsEmpresa() {
        return this.contaRepository.findAll(); }

    public void saveConta(Conta conta) {
        this.atualizaCodigoConta(conta);
        this.contaRepository.save(conta);
    }

    public void updateConta(Conta conta) {
        this.contaRepository.save(conta); }

    public void deleteContaById(long id) {
        this.contaRepository.delete(id);}

    private void atualizaCodigoConta(Conta Conta) {
        List<Conta> contasEmpresa = this.contaRepository.findAll();
        Conta.setCodigo(1);//POG

        if (contasEmpresa.size() > 0) {
            Conta ultimoConta = contasEmpresa.get(contasEmpresa.size() - 1);
            Conta.setCodigo(ultimoConta.getCodigo() + 1);
        }
    }
}
