package uce.edu.web.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import uce.edu.web.api.service.IEstudianteService;
import uce.edu.web.api.service.to.EstudianteTo;

@Path("/estudiantes")
public class EstudianteController {

    @Inject
    private IEstudianteService estudianteService;

    @Path("{/id}")
    @GET
    public EstudianteTo buscar(@PathParam("id") Integer id) {
        return this.estudianteService.buscar(id);
    }

    @GET
    @Path("")
    public List<EstudianteTo> buscarTodos(){
        return this.estudianteService.buscarTodos();
    }

    @GET
    @Path("/porCedula")
    public List<EstudianteTo> buscarPorCedula(@QueryParam("cedula") String cedula){
        return this.estudianteService.buscarPorCedula(cedula);
    }

    @GET
    @Path("/porApellidoCedula")
    public List<EstudianteTo> buscarApellidoCedula(@QueryParam("apellido") String apellido, 
    @QueryParam("cedula") String cedula){
        return this.estudianteService.buscarApellidoCedula(apellido, cedula);
    }
    
    @Path("")
    @POST
    public void guardar(EstudianteTo estudiante) {
        this.estudianteService.guardar(estudiante);
    }

    @Path("/{id}")
    @PUT
    public void actualizar(EstudianteTo estudiante, @PathParam("id") Integer id) {
        this.estudianteService.actualizar(estudiante);
    }

    @Path("/{id}/nuevo/{cedula}")
    @PATCH
    public void actualizarParcial(EstudianteTo estudiante, @PathParam("cedula") String cedula) {
        System.out.println(cedula);
        EstudianteTo tmp = this.estudianteService.buscar(estudiante.getId());
        tmp.setNombre(estudiante.getNombre());
        this.estudianteService.actualizar(tmp);
    }

    @Path("/{id}")
    @DELETE
    public void borrar(@PathParam("id") Integer id) {
        this.estudianteService.borrar(id);
    }


}
