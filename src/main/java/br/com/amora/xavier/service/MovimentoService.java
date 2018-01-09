package br.com.amora.xavier.service;

import br.com.amora.xavier.model.Movimento;
import br.com.amora.xavier.repository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovimentoService {

    @Autowired
    private MovimentoRepository movimentoRepository;

    public Movimento getMovimentoById(Long id) {
        return movimentoRepository.getOne(id);
    }

    public Movimento getMovimentoByCodigo(Long codigo) {
        return movimentoRepository.findMovimentoByCodigo(codigo);
    }

    public Movimento getMovimentoByNumeroRecibo(Long numeroRecibo) {
        return movimentoRepository.findMovimentoByNumeroRecibo(numeroRecibo);
    }

    public Movimento getMovimentoByNumeroPedido(Long numeroPedido) {
        return movimentoRepository.findMovimentoBynumeroPedido(numeroPedido);
    }

    public List<Movimento> getMovimentoByCodigoVendedorAndCodigoCliente(long codigoVendedor, long codigoCliente) {
        return movimentoRepository.findMovimentoByCodigoVendedorAndCodigoCliente(codigoVendedor, codigoCliente);
    }

    public List<Movimento> getAllMovimentos() {
        return movimentoRepository.findAll();
    }

    public void saveMovimento(Movimento movimento) {
        atualizaCodigo(movimento);
        movimentoRepository.save(movimento);
    }

    public void updateMovimento(Movimento movimento) {
        movimentoRepository.save(movimento);
    }

    public void deleteMovimentoById(Long id) {
        movimentoRepository.delete(id);
    }

     private void atualizaCodigo(Movimento movimento) {

        List<Movimento> movimentoes = movimentoRepository.findAll();
        movimento.setCodigo(1);//POG

        if (movimentoes.size() > 0) {
            Movimento ultimoMovimento = movimentoes.get(movimentoes.size() - 1);
            movimento.setCodigo(ultimoMovimento.getCodigo() + 1);
        }
    }
}
