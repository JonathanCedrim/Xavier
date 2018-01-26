package br.com.amora.xavier.rest;

import br.com.amora.xavier.model.Ideal;
import br.com.amora.xavier.model.Movimento;
import br.com.amora.xavier.repository.MovimentoRepository;
import br.com.amora.xavier.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/movimento")
public class MovimentoRest {

    @Autowired
    private MovimentoService movimentoService;

    @GetMapping
    public List<Movimento> getAllMovimentos() {
        return movimentoService.getAllMovimentos();
    }

    @GetMapping(value = "/{id}")
    public Movimento getMovimentoById(@PathVariable long id) {
        return movimentoService.getMovimentoById(id);
    }

    @GetMapping(value = "/busca/codigo/{codigo}")
    public Movimento getMovimentoByCodigo(@PathVariable long codigo) {
        return movimentoService.getMovimentoByCodigo(codigo);
    }

    @GetMapping(value = "/busca/numeroRecibo/{numeroRecibo}")
    public Movimento getMovimentoByNumeroRecibo(@PathVariable long numeroRecibo) {
        return movimentoService.getMovimentoByNumeroRecibo(numeroRecibo);
    }

    @GetMapping(value = "/busca/numeroPedido/{numeroPedido}")
    public Movimento getMovimentoByNumeroPedido(@PathVariable long numeroPedido) {
        return movimentoService.getMovimentoByNumeroPedido(numeroPedido);
    }

    @GetMapping(value = "/busca/vendedor/{codigoVendedor}/cliente/{codigoCliente}")
    public List<Movimento> getMovimentoByVendedorAndCliente(@PathVariable long codigoVendedor, @PathVariable long codigoCliente) {
        return movimentoService.getMovimentoByCodigoVendedorAndCodigoCliente(codigoVendedor, codigoCliente);
    }

    @PostMapping(value= "/busca/data")
    public List<Movimento> getMovimentoByData(@RequestBody Movimento movimento) {
        return this.movimentoService.getMovimentoByData(movimento);
    }

    @PostMapping(value= "/busca/vendedor/data")
    public List<Movimento> getMovimentoByVendedorAndData(@RequestBody Movimento movimento) {
        return this.movimentoService.getMovimentoByVendedorAndData(movimento);
    }

    @PostMapping
    public void saveMovimento(@RequestBody Movimento movimento) {
        movimentoService.saveMovimento(movimento);
    }

    @PutMapping
    public void alterMovimento(@RequestBody Movimento movimento) {
        movimentoService.updateMovimento(movimento);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteMovimentoById(@PathVariable long id) {
        movimentoService.deleteMovimentoById(id);
    }
}

