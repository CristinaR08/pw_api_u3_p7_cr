package uce.edu.web.api.service;

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

    @Inject
    private IPersonaRepository ipersonaRepository;

    @Override
    public void guardar(PersonaTo persona) {
        this.ipersonaRepository.insertar(this.mapPersona.apply(persona));
    }

    @Override
    public void actualizar(PersonaTo persona) {
        Persona per = this.mapPersona.apply(persona);
        this.ipersonaRepository.actualizar(null);
    }

    @Override
    public void borrar(Integer id) {
       this.ipersonaRepository.eliminar(id);
    }

    @Override
    public PersonaTo buscarPorId(Integer id) {
        Persona per = this.ipersonaRepository.buscarPorId(id);
        return this.mapTo.apply(per);
    }

}
