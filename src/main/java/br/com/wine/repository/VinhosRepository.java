package br.com.wine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wine.model.Vinho;
import org.springframework.stereotype.Repository;

@Repository
public interface VinhosRepository extends JpaRepository<Vinho, Long>{

}
