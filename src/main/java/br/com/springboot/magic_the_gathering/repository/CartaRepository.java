package br.com.springboot.magic_the_gathering.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.springboot.magic_the_gathering.model.Carta;

@Repository
public interface CartaRepository extends JpaRepository<Carta, Long> {

	@Query(value = "select u from Carta u where upper(trim(u.nomeCarta)) like %?1% " ) 
	List<Carta> buscarPorNome(String name);
}
