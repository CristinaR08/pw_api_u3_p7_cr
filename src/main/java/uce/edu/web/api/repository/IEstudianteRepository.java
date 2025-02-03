package uce.edu.web.api.repository;

import uce.edu.web.api.repository.modelo.Estudiante;

public interface IEstudianteRepository {

    public Estudiante buscar(Integer id); //Read

    public void insertar(Estudiante estudiante); //Create

    public void actualizar(Estudiante estudiante); //Update

    public void eliminar(Integer id); //Delete

}
