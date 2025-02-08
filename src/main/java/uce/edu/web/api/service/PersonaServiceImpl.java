package uce.edu.web.api.service;

import java.util.List;
import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IPersonaRepository;
import uce.edu.web.api.repository.modelo.Persona;
import uce.edu.web.api.service.to.PersonaTo;

@ApplicationScoped
public class PersonaServiceImpl implements IPersonaService {

    private Function<PersonaTo, Persona> mapPersona = p -> {
        Persona persona = new Persona(p.getId(), p.getNombre(), p.getApellido(), p.getFechaNacimiento());
        return persona;
    };

    private Function<Persona, PersonaTo> mapTo = pTo -> {
        PersonaTo persona = new PersonaTo(pTo.getId(), pTo.getNombre(), pTo.getApellido(), pTo.getFechaNacimiento());
        return persona;
    };

    private Function<List<Persona>, List<PersonaTo>> mapToList = (pList) -> {
        return pList.stream().map(this.mapTo).toList();
    };

    @Inject
    private IPersonaRepository ipersonaRepository;

    @Override
    public void guardar(PersonaTo persona) {
        this.ipersonaRepository.insertar(this.mapPersona.apply(persona));
    }

    @Override
    public void actualizar(PersonaTo persona) {
        Persona per = this.mapPersona.apply(persona);
        this.ipersonaRepository.actualizar(per);
    }

    @Override
    public void borrar(Integer id) {
       this.ipersonaRepository.eliminar(id);
    }

    @Override
    public PersonaTo buscarPorId(Integer id) { 
        try {
            Persona per = this.ipersonaRepository.buscarPorId(id);
        return this.mapTo.apply(per);
        } catch (Exception e) {
            PersonaTo p = new PersonaTo();
            System.out.println(p);
            return p; 
        }
        
        
    }

    @Override
    public List<PersonaTo> buscarTodos() {
        return this.mapToList.apply(this.ipersonaRepository.buscarTodos());
    }

    @Override
    public List<PersonaTo> buscarPorNombre(String nombre) {
        return this.mapToList.apply(this.ipersonaRepository.buscarPorNombre(nombre));
    }

    @Override
    public List<PersonaTo> buscarApellidoNombre(String apellido, String nombre) {
        return this.mapToList.apply(ipersonaRepository.buscarApellidoNombre(apellido, nombre));
    }

  
}
