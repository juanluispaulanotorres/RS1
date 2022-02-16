package com.example.rs1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class Controlador {

    @Autowired
    List<PersonaService> lista;

    // Inserción
    @PostMapping("/persona")
    public void addPersona(@RequestBody Persona p) {

        PersonaService persona = new PersonaServiceImpl();

        persona.setNombre(p.getNombre());
        persona.setPoblacion(p.getPoblacion());
        persona.setEdad(p.getEdad());

        // Añadir a la lista una persona
        lista.add(persona);

        System.out.println("Persona añadida");
        System.out.println("Listado actual: ");

        lista.stream().forEach(System.out::println);
        //System.out.println(lista + "\n");
    }

    // Modificación
    @PutMapping("/persona/{id}")
    public void modificaPersona(@PathVariable int id, @RequestBody Persona p) {

        //Autoincrementable (para el id)
        //final AtomicInteger contador = new AtomicInteger();

        if (id == 0) {
            System.out.println("La persona que busca no existe");

        } else {
            PersonaService persona = new PersonaServiceImpl();

            persona.setNombre(persona.getNombre());
            persona.setPoblacion(persona.getPoblacion());
            persona.setEdad(p.getEdad());
        }
    }

    // Consulta por nombre
    @GetMapping("/persona/nombre/{nombre}")
    public void consultaNombre(@PathVariable String nombre) {
        lista.stream().filter(personaService -> personaService.getNombre() != null)
                .filter(personaService -> personaService.getNombre().equalsIgnoreCase(nombre))
                .forEach(System.out::println);
    }
}