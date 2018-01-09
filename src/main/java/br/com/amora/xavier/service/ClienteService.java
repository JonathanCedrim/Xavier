package br.com.amora.xavier.service;

import br.com.amora.xavier.model.Cliente;
import br.com.amora.xavier.model.Vendedor;
import br.com.amora.xavier.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    public List<Cliente> getAllClientes() {
        return clienteRepository.findAll();
    }

    public Cliente findClientById(Long id) {
        return clienteRepository.findOne(id);
    }

    public Cliente findClienteByCodigo(long codigoVendedor, long codigoCliente) {
        return clienteRepository.findClienteByCodigo(codigoVendedor, codigoCliente);
    }

    public List<Cliente> findClientesByNome(String nome) {
        return clienteRepository.findClienteByNome(nome);
    }

    public Cliente findClienteByRG( String rg) {
        return clienteRepository.findClienteByRG(rg);
    }

    public Cliente findClienteByCPF(String cpf) {
        return clienteRepository.findClienteByCPF(cpf);
    }

    public List<Cliente> findClientesByCEP(String cep) {
        return clienteRepository.findClientesByCEP(cep);
    }

    public List<Cliente> findClientesByTelefone(String telefone) {
        return clienteRepository.findClientesByTelefone(telefone);
    }

    public Cliente findClienteByCelular(String celular) {
        return clienteRepository.findClienteByCelular(celular);
    }

    public Cliente findClienteByCelularII(String celularII) {
        return clienteRepository.findClienteByCelularII(celularII);
    }

    public void deleteClienteById(Long id) {
        clienteRepository.delete(id);
    }

    public void saveCliente(Cliente cliente) {
        Vendedor vendedor = cliente.getVendedor();
        atualizaCodigoDoClienteDeAcordoComVendedor(vendedor, cliente);
        clienteRepository.save(cliente);
    }

    public void updateCliente(Cliente cliente) {
        Vendedor vendedor = cliente.getVendedor();
        long codigoVendedorAntigo = clienteRepository.getOne(cliente.getId()).getVendedor().getCodigo();

        if(codigoVendedorAntigo != vendedor.getCodigo()) {
            atualizaCodigoDoClienteDeAcordoComVendedor(vendedor, cliente);
        }
        clienteRepository.save(cliente);
    }

    public List<Cliente> findClientesByEmail(String email) {
        return clienteRepository.findClienteByEmail(email);
    }


    private Cliente atualizaCodigoDoClienteDeAcordoComVendedor(Vendedor vendedor, Cliente cliente) {

        List<Cliente> clientes = clienteRepository.getClientesDoVendedor(vendedor.getId());

        cliente.setCodigo(1);

        if(clientes.size() > 0) {
            Cliente ultimoCliente = clientes.get(clientes.size() - 1);
            cliente.setCodigo(ultimoCliente.getCodigo() + 1);
        }

        return cliente;

    }
}
