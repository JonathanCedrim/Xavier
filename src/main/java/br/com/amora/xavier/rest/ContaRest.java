package br.com.amora.xavier.rest;

import br.com.amora.xavier.model.Conta;
import br.com.amora.xavier.model.Ideal;
import br.com.amora.xavier.service.ContaService;
import br.com.amora.xavier.service.IdealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/conta/")
public class ContaRest {

    @Autowired
    private ContaService contaService;

    @GetMapping
    public List<Conta> getAllContas() {
        return contaService.getAllIdealsEmpresa();
    }

    @GetMapping(value = "/{id}")
    public Conta getContaById(@PathVariable long id) {
        return contaService.getContaById(id);
    }

    @GetMapping(value = "/busca/codigo/{codigoConta}")
    public Conta getContaByCodigo(@PathVariable long codigoConta) {
        return contaService.getContaByCodigo(codigoConta);
    }

    @GetMapping(value = "/busca/entidade/{codigoEntidade}")
    public List<Conta> getContaByData(@RequestBody long codigoEntidade) {
        return contaService.getContaByEntidade(codigoEntidade);
    }

    @PostMapping(value = "/busca/dataLancamento")
    public List<Conta> getContaByDataLancamento(@RequestBody Conta conta) {
        return contaService.getContaByDataLancamento(conta);
    }

    @PostMapping(value = "/busca/dataPagamento")
    public List<Conta> getContaByDataPagamento(@RequestBody Conta conta) {
        return contaService.getContaByDataPagamento(conta);
    }

    @PostMapping
    public void saveConta(@RequestBody Conta conta) {
        contaService.saveConta(conta);
    }

    @PutMapping
    public void alterConta(@RequestBody Conta conta) {
        contaService.updateConta(conta);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteContaById(@PathVariable Long id) {
        contaService.deleteContaById(id);
    }

}
