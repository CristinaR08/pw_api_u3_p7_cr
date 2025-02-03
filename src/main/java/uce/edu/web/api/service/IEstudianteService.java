package uce.edu.web.api.service;

import uce.edu.web.api.service.to.EstudianteTo;

public interface IEstudianteService {
    
    public EstudianteTo buscar(Integer id);

    public void guardar(EstudianteTo estudiante);

    public void actualizar(EstudianteTo estudiante);

    public void borrar(Integer id);


}
