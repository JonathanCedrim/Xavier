package br.com.amora.xavier.rest;

import br.com.amora.xavier.model.Ideal;
import br.com.amora.xavier.model.Movimento;
import br.com.amora.xavier.repository.MovimentoRepository;
import br.com.amora.xavier.service.IdealService;
import br.com.amora.xavier.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/ideal")
public class IdealRest {

    @Autowired
    private IdealService idealService;

    @GetMapping
    public List<Ideal> getAllIdeals() {
        return idealService.getAllIdeals();
    }

    @GetMapping(value = "/{id}")
    public Ideal getIdealById(@PathVariable Long id) {
        return idealService.getIdealById(id);
    }

    @GetMapping(value = "/busca/codigo/{codigoIdeal}")
    public Ideal getIdealByCodigo(@PathVariable Long codigoIdeal) {
        return idealService.getIdealByCodigo(codigoIdeal);
    }

    @GetMapping(value = "/busca/codigo/vendedor/{codigoVendedor}")
    public List<Ideal> getAllIdealsByVendedor(@PathVariable Long codigoVendedor) { return idealService.getIdealsByVendedor(codigoVendedor);}

    @PostMapping(value = "/busca/data")
    public List<Ideal> getIdealByData(@RequestBody Ideal ideal) {
        return idealService.getIdealByData(ideal);
    }

    @PostMapping(value = "/busca/dataLancamento")
    public List<Ideal> getIdealByDataLancamento(@RequestBody Ideal ideal) {
        return idealService.getIdealByDataLancamento(ideal);
    }

    @PostMapping(value = "/busca/vendedor/data")
    public List<Ideal> getIdealByVendedorAndData(@RequestBody Ideal ideal) {
        return idealService.getIdealByVendedorAndData(ideal);
    }

    @PostMapping
    public void saveIdeal(@RequestBody Ideal ideal) {
        idealService.saveIdeal(ideal);
    }

    @PutMapping
    public void alterIdeal(@RequestBody Ideal ideal) {
        idealService.updateIdeal(ideal);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteIdealById(@PathVariable Long id) {
        idealService.deleteIdealById(id);
    }
}

