package br.com.amora.xavier.rest;

import br.com.amora.xavier.model.Ideal;
import br.com.amora.xavier.model.Movimento;
import br.com.amora.xavier.repository.MovimentoRepository;
import br.com.amora.xavier.service.IdealService;
import br.com.amora.xavier.service.MovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/busca/codigo/{codigo}")
    public Ideal getIdealByCodigo(@PathVariable Long codigo) {
        return idealService.getIdealByCodigo(codigo);
    }

    @GetMapping(value = "/busca/data/dataInicial/{dataInicial}/dataFinal/{dataFinal}")
    public List<Ideal> getIdealByData(@PathVariable Date dataInicial, @PathVariable Date dataFinal ) {
        return idealService.getIdealByData(dataInicial, dataFinal);
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

