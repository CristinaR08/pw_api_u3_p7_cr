package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.service.to.PersonaTo;

public interface IPersonaService {

    public PersonaTo buscarPorId(Integer id);

    public List<PersonaTo> buscarTodos();

    public List<PersonaTo> buscarPorNombre(String nombre);

    public List<PersonaTo> buscarApellidoNombre(String apellido, String nombre);

    public void guardar(PersonaTo persona);

    public void actualizar(PersonaTo persona);

    public void borrar(Integer id);

}
