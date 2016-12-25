package br.com.wine.service;

import br.com.wine.model.Vinho;
import br.com.wine.repository.VinhosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CadastroVinhoService {

  @Autowired
  private VinhosRepository vinhosRepository;

  public void salvar(Vinho vinho) {
    vinhosRepository.save(vinho);
  }

  public Vinho consultar(Long codigo) {
    return vinhosRepository.findOne(codigo);
  }

  public List<Vinho> buscar() {
    return vinhosRepository.findAll();
  }
}
