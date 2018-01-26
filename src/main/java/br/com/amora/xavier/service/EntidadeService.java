package br.com.amora.xavier.service;

import br.com.amora.xavier.model.Entidade;
import br.com.amora.xavier.repository.EntidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntidadeService {

    @Autowired
    private EntidadeRepository entidadeRepository;

    public Entidade getEntidadeById(long id) {
        return this.entidadeRepository.getOne(id);
    }

    public Entidade getEntidadeByCodigo(long codigo) {
        return this.entidadeRepository.findEntidadeByCodigo(codigo);
    }

    public List<Entidade> getEntidadeByNome(String nome) {
        return this.entidadeRepository.findEntidadeByNome(nome);
    }

    public List<Entidade> getEntidadeByTelefone(String telefone) {
        return this.entidadeRepository.findEntidadesByTelefone(telefone);
    }

    public List<Entidade> getEntidadeByCelular(String celular) {
        return this.entidadeRepository.findEntidadeByCelular(celular);
    }

    public List<Entidade> getEntidadeByCelularII(String celularII) {
        return this.entidadeRepository.findEntidadeByCelular(celularII);
    }

    public List<Entidade> getEntidadeByEmail(String email) {
        return this.entidadeRepository.findEntidadeByEmail(email);
    }

    public List<Entidade> getAllIdealsEmpresa() { return this.entidadeRepository.findAll(); }

    public void saveEntidade(Entidade entidade) {
        this.atualizaCodigoEntidade(entidade);
        this.entidadeRepository.save(entidade);
    }

    public void updateEntidade(Entidade entidade) { this.entidadeRepository.save(entidade); }

    public void deleteEntidadeById(long id) { this.entidadeRepository.delete(id);}

    private void atualizaCodigoEntidade(Entidade Entidade) {
        List<Entidade> entidadesEmpresa = this.entidadeRepository.findAll();
        Entidade.setCodigo(1);

        if (entidadesEmpresa.size() > 0) {
            Entidade ultimoEntidade = entidadesEmpresa.get(entidadesEmpresa.size() - 1);
            Entidade.setCodigo(ultimoEntidade.getCodigo() + 1);
        }
    }
}
