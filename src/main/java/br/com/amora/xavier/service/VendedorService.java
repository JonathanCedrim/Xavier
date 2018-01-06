package br.com.amora.xavier.service;

import br.com.amora.xavier.model.Vendedor;
import br.com.amora.xavier.repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    public List<Vendedor> findAllVendedor() {
        return vendedorRepository.findAll();
    }

    public Vendedor findVendedorById(Long id) {
        return vendedorRepository.findOne(id);
    }

    public Vendedor findVendedorByCodigo(Long codigo) {
        return vendedorRepository.findVendedorByCodigo(codigo);
    }

    public List<Vendedor> findVendedorByNome(String nome) {
        return vendedorRepository.findVendedorByNome(nome);
    }

    public Vendedor findVendedorByRG(String rg) {
        return vendedorRepository.findVendedorByRG(rg);
    }

    public Vendedor findVendendorByCPF(String cpf) {

        return vendedorRepository.findVendedorByCPF(cpf);
    }

    public void deleteById(Long id) {
        vendedorRepository.delete(id);
    }

    public void saveVendedor(Vendedor vendedor) {

            List<Vendedor> vendedores = vendedorRepository.findAll();
            vendedor.setCodigo(1);//para não precisar fazer decisão logica. POG na primeira entrada.

            if (vendedores.size() > 0) {
                Vendedor ultimoVendedor = vendedores.get(vendedores.size() - 1);
                vendedor.setCodigo(ultimoVendedor.getCodigo() + 1);
            }
                vendedorRepository.save(vendedor);
    }

    public void updateVendedor(Vendedor vendedor) {
        vendedorRepository.save(vendedor);
    }
}
