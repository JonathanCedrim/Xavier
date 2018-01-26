package br.com.amora.xavier.service;

import br.com.amora.xavier.model.IdealEmpresa;
import br.com.amora.xavier.repository.IdealEmpresaRepostory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdealEmpresaService {
    
    @Autowired
    private IdealEmpresaRepostory idealEmpresaRepostory;

    public IdealEmpresa getIdealEmpresaById(long id) { return this.idealEmpresaRepostory.getOne(id); }

    public IdealEmpresa getIdealEmpresaByCodigo(long codigo) { return this.idealEmpresaRepostory.getIdealEmpresaByCodigo(codigo);}


    public List<IdealEmpresa> getIdealEmpresaByData(IdealEmpresa ideal) {
        return this.idealEmpresaRepostory.getIdealEmpresaByData(ideal.getDataInicial(), ideal.getDataFinal());
    }

    public List<IdealEmpresa> getIdealEmpresaByDataLancamento(IdealEmpresa ideal) {
        return this.idealEmpresaRepostory.getIdealEmpresaByDataLancamento(ideal.getDataInicial(), ideal.getDataFinal());
    }

    public List<IdealEmpresa> getAllIdealsEmpresa() { return this.idealEmpresaRepostory.findAll(); }

    public void saveIdealEmpresa(IdealEmpresa ideal) {
        this.atualizaCodigoIdealEmpresa(ideal);
        this.idealEmpresaRepostory.save(ideal);
    }

    public void updateIdealEmpresa(IdealEmpresa ideal) { this.idealEmpresaRepostory.save(ideal); }

    public void deleteIdealEmpresaById(long id) { this.idealEmpresaRepostory.delete(id);}

    private void atualizaCodigoIdealEmpresa(IdealEmpresa IdealEmpresa) {
        List<IdealEmpresa> idealsEmpresa = this.idealEmpresaRepostory.findAll();
        IdealEmpresa.setCodigo(1);//POG

        if (idealsEmpresa.size() > 0) {
            IdealEmpresa ultimoIdealEmpresa = idealsEmpresa.get(idealsEmpresa.size() - 1);
            IdealEmpresa.setCodigo(ultimoIdealEmpresa.getCodigo() + 1);
        }
    }
}
