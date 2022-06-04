package br.com.springboot.magic_the_gathering.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import br.com.springboot.magic_the_gathering.model.Carta;
import br.com.springboot.magic_the_gathering.repository.CartaRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	
	@Autowired
	private CartaRepository cartaRepository;
	
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
    @RequestMapping(value = "/ola/{nome}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String retornaOla(@PathVariable String nome) {
       
    	Carta carta = new Carta();
    	carta.setNomeCarta(nome);
    	
    	cartaRepository.save(carta);
    	
    	return "Ola " + nome;
    }
    
    
  
    @GetMapping(value = "listarTodos")
    @ResponseBody
    public ResponseEntity<List<Carta>> listaCarta(){
    	
    	List<Carta> cartas = cartaRepository.findAll();
    	
    	return new ResponseEntity<List<Carta>>(cartas, HttpStatus.OK);
    	
	}
    
    
    @PostMapping(value = "salvar")/*Mapeia a URL*/
    @ResponseBody/*Descrição da Resposta*/
    public ResponseEntity<?> salvar(@RequestBody Carta carta){/*Recebe os dados para Salvar*/
    	
    	Carta user = cartaRepository.save(carta);
    	
    	return new ResponseEntity<Carta>(user, HttpStatus.CREATED);
    	
    }
    
    @PutMapping(value = "atualizar")/*Mapeia a URL*/
    @ResponseBody/*Descrição da Resposta*/
    public ResponseEntity<?> atualizar(@RequestBody Carta carta){/*Recebe os dados para atualizar*/
    	
    	if (carta.getId() == 0) {
    	return new ResponseEntity<String>("Id não foi informado para atualização.", HttpStatus.OK);
    	}
    	
    	Carta user = cartaRepository.saveAndFlush(carta);
    	
    	return new ResponseEntity<Carta>(user, HttpStatus.OK);
    	
    }
    
    @DeleteMapping(value = "delete")/*Mapeia a URL*/
    @ResponseBody/*Descrição da Resposta*/
    public ResponseEntity<String> delete(@RequestParam Long idcarta){/*Recebe os dados para delete*/
    	
    	cartaRepository.deleteById(idcarta);
    	
    	return new ResponseEntity<String>("Usuário deletado com Sucesso!", HttpStatus.OK);
    	
    }
    
    @GetMapping(value = "buscarCartaId")/*Mapeia a URL*/
    @ResponseBody/*Descrição da Resposta*/
    public ResponseEntity<Carta> buscarCartaId(@RequestParam (name = "idcarta") Long idcarta){/*Recebe os dados por id*/
    	
    	Carta carta = cartaRepository.findById(idcarta).get();
    	
    	return new ResponseEntity<Carta>(carta, HttpStatus.OK);
    	
    }
    
    @GetMapping(value = "buscarPorNome")/*Mapeia a URL*/
    @ResponseBody/*Descrição da Resposta*/
    public ResponseEntity<List<Carta>> buscarPorNome(@RequestParam (name = "name") String name){/*Recebe os dados por nome*/
    	
        List<Carta> carta = cartaRepository.buscarPorNome(name.trim().toUpperCase());
    	
        return new ResponseEntity<List<Carta>>(carta, HttpStatus.OK);
    	
    }
    
    
}
