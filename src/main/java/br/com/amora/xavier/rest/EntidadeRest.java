package br.com.amora.xavier.rest;

import br.com.amora.xavier.model.Entidade;
import br.com.amora.xavier.service.EntidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/entidade")
public class EntidadeRest {

    @Autowired
    private EntidadeService entidadeService;

    @GetMapping
    public List<Entidade> getAllEntidades() {
        return entidadeService.getAllIdealsEmpresa();
    }

    @GetMapping(value = "/{id}")
    public Entidade getEntidadeById(@PathVariable long id) {
        return entidadeService.getEntidadeById(id);
    }

    @GetMapping(value = "/busca/codigo/{codigoEntidade}")
    public Entidade getEntidadeByCodigo(@PathVariable long codigoEntidade) {
        return entidadeService.getEntidadeByCodigo(codigoEntidade);
    }

    @GetMapping(value = "/busca/nome/{nome}")
    public List<Entidade> getEntidadeByNome(@RequestBody String nome) {
        return entidadeService.getEntidadeByNome(nome);
    }

    @GetMapping(value = "/busca/celular/{celular}")
    public List<Entidade> getEntidadeByCelular(@RequestBody String celular) {
        return entidadeService.getEntidadeByCelular(celular);
    }

    @GetMapping(value = "/busca/celularII/{celularII}")
    public List<Entidade> getEntidadeBycelularII(@RequestBody String celularII) {
        return entidadeService.getEntidadeByCelularII(celularII);
    }

    @GetMapping(value = "/busca/email/{email}")
    public List<Entidade> getEntidadeByEmail(@RequestBody String email) {
        return entidadeService.getEntidadeByEmail(email);
    }
    
    @PostMapping
    public void saveEntidade(@RequestBody Entidade entidade) {
        entidadeService.saveEntidade(entidade);
    }

    @PutMapping
    public void alterEntidade(@RequestBody Entidade entidade) {
        entidadeService.updateEntidade(entidade);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEntidadeById(@PathVariable Long id) {
        entidadeService.deleteEntidadeById(id);
    }
}
