package br.com.amora.xavier.rest;

import br.com.amora.xavier.model.Vendedor;
import br.com.amora.xavier.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/vendedor")
public class VendedorRest {

    @Autowired
    private VendedorService vendedorService;

    @GetMapping
    public List<Vendedor> getAllVendedores() {
        return vendedorService.findAllVendedor();
    }

    @GetMapping(value = "/busca/nome/{nome}")
     public List<Vendedor> getVendedoresByNome(@PathVariable String nome) {
         return vendedorService.findVendedorByNome(nome);
     }

    @GetMapping(value = "/{id}")
    public Vendedor findVendedorById(@PathVariable Long id) {
        return vendedorService.findVendedorById(id);
    }

    @GetMapping(value = "/busca/codigo/{codigo}")
    public Vendedor getVendendorByCodigo(@PathVariable Long codigo) {
        return vendedorService.findVendedorByCodigo(codigo);
    }

    @GetMapping(value = "/busca/rg/{rg}")
    public Vendedor getVendedorByRG(@PathVariable String rg) {
        return vendedorService.findVendedorByRG(rg);
    }

    @GetMapping(value = "/busca/cpf/{cpf}")
    public Vendedor getVendedorByCPF(@PathVariable String cpf) {
        return vendedorService.findVendendorByCPF(cpf);
    }

    @PostMapping
    public void saveVendedor(@RequestBody Vendedor vendedor) {
        vendedorService.saveVendedor(vendedor);
    }

    @PutMapping
    public void updateVendedor(@RequestBody Vendedor vendedor) {
        vendedorService.updateVendedor(vendedor);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteVendedorById(@PathVariable Long id) {
        vendedorService.deleteById(id);
    }
}
