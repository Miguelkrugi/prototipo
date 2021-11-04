package com.busybrain.api.prototipo.controllers;

import com.busybrain.api.prototipo.models.Utilizador;
import com.busybrain.api.prototipo.models.repositories.UtilizadorRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/busybrain/users")
public class UtilizadorController {
    
    private Logger logger = LoggerFactory.getLogger(UtilizadorController.class); 
    @Autowired
    private UtilizadorRepository utilizadorRepository;
    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Utilizador> getUtilizadores() {
        logger.info("A Exibir os utilizadores");
        return utilizadorRepository.findAll();
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Utilizador addUtilizador(@RequestBody Utilizador utilizador) {

        Utilizador savedUtilizador = utilizadorRepository.save(utilizador);
        logger.info("Adding utilizador...");
        
        return savedUtilizador;
     }



     @GetMapping(path = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
     public Utilizador getUtilizador(@PathVariable(value =  "username") String username) {
         logger.info("Sending student with username " + username);
         return (Utilizador) utilizadorRepository.findByUsername(username);
        
     }

}
