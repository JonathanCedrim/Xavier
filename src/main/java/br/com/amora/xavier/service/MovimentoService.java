package br.com.amora.xavier.service;

import br.com.amora.xavier.model.Cliente;
import br.com.amora.xavier.model.Movimento;
import br.com.amora.xavier.repository.MovimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MovimentoService {

    @Autowired
    private MovimentoRepository movimentoRepository;

    @Autowired
    private ClienteService clienteService;

    public Movimento getMovimentoById(long id) {
        return atualizaClienteMovimentoByCodigoCliente(movimentoRepository.getOne(id));
    }

    public Movimento getMovimentoByCodigo(long codigo) {
        return atualizaClienteMovimentoByCodigoCliente(movimentoRepository.findMovimentoByCodigo(codigo));
    }

    public Movimento getMovimentoByNumeroRecibo(long numeroRecibo) {
        return atualizaClienteMovimentoByCodigoCliente(movimentoRepository.findMovimentoByNumeroRecibo(numeroRecibo));
    }

    public Movimento getMovimentoByNumeroPedido(long numeroPedido) {
        return atualizaClienteMovimentoByCodigoCliente(movimentoRepository.findMovimentoBynumeroPedido(numeroPedido));
    }

    public List<Movimento> getMovimentoByCodigoVendedorAndCodigoCliente(long codigoVendedor, long codigoCliente) {
         List<Movimento> movimentos = movimentoRepository.findMovimentoByCodigoVendedorAndCodigoCliente(codigoVendedor, codigoCliente);

         return atualizaClienteMovimentosByCodigoCliente(movimentos);

    }

    public List<Movimento> getMovimentoByData(Movimento movimento) {
        List<Movimento> movimentos = movimentoRepository.findMovimentoByData(movimento.getDataPagamento(), movimento.getDataPagamentoII());

        return atualizaClienteMovimentosByCodigoCliente(movimentos);
    }

    public List<Movimento> getMovimentoByVendedorAndData(Movimento movimento) {
        List<Movimento> movimentos =  movimentoRepository.findMovimentoByVendedorAndData(movimento.getVendedor().getCodigo(), movimento.getDataPagamento(), movimento.getDataPagamentoII());

        return atualizaClienteMovimentosByCodigoCliente(movimentos);
    }

    public List<Movimento> getAllMovimentos() {
        List<Movimento> movimentos =  movimentoRepository.findAll();

        return atualizaClienteMovimentosByCodigoCliente(movimentos);
    }

    public void saveMovimento(Movimento movimento) {
        atualizaCodigo(movimento);
        movimentoRepository.save(movimento);
    }

    public void updateMovimento(Movimento movimento) {
        movimentoRepository.save(movimento);
    }

    public void deleteMovimentoById(long id) {
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

    private Movimento atualizaClienteMovimentoByCodigoCliente(Movimento movimento) {
        movimento.setCliente(clienteService.findClienteByCodigo(movimento.getVendedor().getCodigo(), movimento.getCodigoCliente()));
        return movimento;
    }

    private List<Movimento> atualizaClienteMovimentosByCodigoCliente(List<Movimento> movimentos) { //POG para ter compatiblidade com sistema legado :/
        for(Movimento movimento: movimentos) {
            Cliente cliente = clienteService.findClienteByCodigo(movimento.getVendedor().getCodigo(), movimento.getCodigoCliente());

            movimento.setCliente(cliente);
        }
        return movimentos;
    }
}
