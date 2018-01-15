package br.com.amora.xavier.service;

import br.com.amora.xavier.model.Ideal;
import br.com.amora.xavier.model.Movimento;
import br.com.amora.xavier.model.Vendedor;
import br.com.amora.xavier.repository.IdealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class IdealService {

    @Autowired
    private IdealRepository idealRepository;

    public Ideal getIdealById(long id) { return this.idealRepository.getOne(id); }

    public Ideal getIdealByCodigo(long codigo) { return this.idealRepository.getIdealByCodigo(codigo);}

    public List<Ideal> getIdealsByVendedor(long codigoVendedor) { return this.idealRepository.getIdealsByVendedor(codigoVendedor);}

    public List<Ideal> getIdealByData(Date dataInicial, Date dataFinal) {
        return this.idealRepository.getIdealByData(dataInicial, dataFinal);
    }

    public List<Ideal> getIdealByVendedorAndData(long codigoVendendor, Date dataInicial, Date dataFinal) {
        return this.idealRepository.getIdealByVendedorAndData(codigoVendendor, dataInicial, dataFinal);
    }

    public List<Ideal> getAllIdeals() { return this.idealRepository.findAll(); }

    public void saveIdeal(Ideal ideal) {
        this.atualizaIdeal(ideal);
        this.idealRepository.save(ideal);
    }

    public void updateIdeal(Ideal ideal) { this.idealRepository.save(ideal); }

    public void deleteIdealById(long id) { this.idealRepository.delete(id);}

    private void atualizaIdeal(Ideal Ideal) {
        List<Ideal> ideals = this.idealRepository.findAll();
        Ideal.setCodigo(1);//POG

        if (ideals.size() > 0) {
            Ideal ultimoIdeal = ideals.get(ideals.size() - 1);
            Ideal.setCodigo(ultimoIdeal.getCodigo() + 1);
        }
    }

}
