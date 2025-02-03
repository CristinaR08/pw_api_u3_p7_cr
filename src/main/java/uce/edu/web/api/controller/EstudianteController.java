package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;

@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService estudianteService;

    @Path("/buscar")
    @GET
    public EstudianteTo buscar() {
        Integer id = 1;
        return this.estudianteService.buscar(id);
    }
    
    @Path("/guardar")
    @POST
    public void guardar(EstudianteTo estudiante) {
        this.estudianteService.guardar(estudiante);
    }

    @Path("/actualizar")
    @PUT
    public void actualizar(EstudianteTo estudiante) {
        this.estudianteService.actualizar(estudiante);
    }

    @Path("/actualizarParcial")
    @PATCH
    public void actualizarParcial(EstudianteTo estudiante) {
        EstudianteTo tmp = this.estudianteService.buscar(estudiante.getId());
        tmp.setNombre(estudiante.getNombre());
        this.estudianteService.actualizar(tmp);
    }

    @Path("/borrar")
    @DELETE
    public void borrar() {
        Integer id = 1;
        this.estudianteService.borrar(id);
    }


}
