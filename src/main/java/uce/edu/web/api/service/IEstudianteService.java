package uce.edu.web.api.service;

import java.util.List;

import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {
    
    public EstudianteTo buscar(Integer id);

    public List<EstudianteTo> buscarTodos();

    public List<EstudianteTo> buscarPorCedula(String cedula);

    public List<EstudianteTo> buscarApellidoCedula(String apellido, String cedula);

    public void guardar(EstudianteTo estudiante);

    public void actualizar(EstudianteTo estudiante);

    public void borrar(Integer id);


}
