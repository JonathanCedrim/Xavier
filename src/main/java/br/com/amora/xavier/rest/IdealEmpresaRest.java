package br.com.amora.xavier.rest;

import br.com.amora.xavier.model.IdealEmpresa;
import br.com.amora.xavier.service.IdealEmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/idealEmpresa")
public class IdealEmpresaRest {

    @Autowired
    private IdealEmpresaService idealEmpresaService;

    @GetMapping
    public List<IdealEmpresa> getAllIdeals() {
        return idealEmpresaService.getAllIdealsEmpresa();
    }

    @GetMapping(value = "/{id}")
    public IdealEmpresa getIdealById(@PathVariable Long id) {
        return idealEmpresaService.getIdealEmpresaById(id);
    }

    @GetMapping(value = "/busca/codigo/{codigoIdeal}")
    public IdealEmpresa getIdealEmpresaByCodigo(@PathVariable Long codigoIdeal) {
        return idealEmpresaService.getIdealEmpresaByCodigo(codigoIdeal);
    }

    @PostMapping(value = "/busca/data")
    public List<IdealEmpresa> getIdealEmpresaByData(@RequestBody IdealEmpresa idealEmpresa) {
        return idealEmpresaService.getIdealEmpresaByData(idealEmpresa);
    }

    @PostMapping(value = "/busca/dataLancamento")
    public List<IdealEmpresa> getIdealEmpresaByDataLancamento(@RequestBody IdealEmpresa idealEmpresa) {
        return idealEmpresaService.getIdealEmpresaByDataLancamento(idealEmpresa);
    }

    @PostMapping
    public void saveIdeal(@RequestBody IdealEmpresa idealEmpresa) {
        idealEmpresaService.saveIdealEmpresa(idealEmpresa);
    }

    @PutMapping
    public void alterIdealEmpresa(@RequestBody IdealEmpresa idealEmpresa) {
        idealEmpresaService.updateIdealEmpresa(idealEmpresa);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteIdealEmpresaById(@PathVariable Long id) {
        idealEmpresaService.deleteIdealEmpresaById(id);
    }
}
