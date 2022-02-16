package com.example.rs1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

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
    }

    // Modificación
    @PutMapping("/persona/{id}")
    public void modificaPersona(@PathVariable int id, @RequestBody Persona p) {

        if (id <= 0 || id >= lista.size()) {
            System.out.println("La persona que busca no existe");

        } else {
            // Si el id coincide con el índice de la lista, modifico los datos de la persona que ocupe esa posición
            for (PersonaService persona:lista) {
                if (id == lista.indexOf(persona)) {
                    persona.setNombre(p.getNombre());
                    persona.setPoblacion(p.getPoblacion());
                    persona.setEdad(p.getEdad());
                }
            }
            lista.stream().forEach(System.out::println);
        }
    }

    // Eliminar
    @DeleteMapping("/persona/{id}")
    public void eliminaPersona(@PathVariable int id) {

        if (id <= 0 || id >= lista.size()) {
            System.out.println("La persona que busca no existe");

        } else {
            for (PersonaService persona:lista) {
                if (id == lista.indexOf(persona)) {
                    lista.remove(id);
                }
            }
            lista.stream().forEach(System.out::println);
        }
    }

    // Consulta por id
    @GetMapping("/persona/{id}")
    public void consultaId(@PathVariable int id) {

        if (id <= 0 || id >= lista.size()) {
            System.out.println("La persona que busca no existe");

        } else {
            for (PersonaService persona:lista) {
                if (id == lista.indexOf(persona)) {
                    System.out.println(persona);
                }
            }
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