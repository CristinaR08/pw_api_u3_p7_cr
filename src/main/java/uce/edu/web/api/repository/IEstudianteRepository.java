package uce.edu.web.api.repository;

import java.util.List;

import uce.edu.web.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {

    public Estudiante buscar(Integer id); //Read

    public void insertar(Estudiante estudiante); //Create

    public List<Estudiante> buscarTodos();

    public List<Estudiante> buscarPorCedula(String nombre);

    public List<Estudiante> buscarApellidoCedula(String apellido, String nombre);

    public void actualizar(Estudiante estudiante); //Update

    public void eliminar(Integer id); //Delete

}
