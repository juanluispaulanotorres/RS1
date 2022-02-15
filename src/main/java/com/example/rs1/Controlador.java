package com.example.rs1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    List<PersonaService> lista;

    @PostMapping("/persona")
    public void addPersona(@RequestBody Persona p) {

        PersonaService persona = new PersonaServiceImpl();

        persona.setNombre(p.getNombre());
        persona.setPoblacion(p.getPoblacion());
        persona.setEdad(p.getEdad());

        // Añadir a la lista una persona
        lista.add(persona);

        System.out.println("Persona añadida");
        System.out.println("Listado actual: " + lista);
    }
}