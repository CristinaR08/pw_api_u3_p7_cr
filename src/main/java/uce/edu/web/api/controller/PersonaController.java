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
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/{id}") //pathVariable
    public PersonaTo buscarPorId(@PathParam("id") Integer id) {
        return this.personaService.buscarPorId(id);
        //return Response.ok(this.personaService.buscarPorId(id)).build();
    }

    @GET
    @Path("")
    public List<PersonaTo> buscarTodos(){
        return this.personaService.buscarTodos();
    }

    @GET
    @Path("/porNombre")
    public List<PersonaTo> buscarPorNombre(@QueryParam("nombre") String nombre){
        return this.personaService.buscarPorNombre(nombre);
    }

    @GET
    @Path("/porApellidoNombre")
    public List<PersonaTo> buscarApellidoNombre(@QueryParam("apellido") String apellido, 
    @QueryParam("nombre") String nombre){
        return this.personaService.buscarApellidoNombre(apellido, nombre);
    }

    @POST
    @Path("")
    public void guardar(PersonaTo persona) {
        this.personaService.guardar(persona);
    }

    @PUT
    @Path("/{id}")
    public void actualizar(PersonaTo persona, @PathParam("id") Integer id) {
        persona.setId(id);
        this.personaService.actualizar(persona);
    }

    @PATCH
    @Path("/{id}/nuevo/{cedula}")
    public void actualizarParcial(PersonaTo persona, @PathParam("id") Integer id, @PathParam("cedula") String cedula) {
        System.out.println(cedula);
        PersonaTo tmp = this.personaService.buscarPorId(id);        
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
    }

    @DELETE
    @Path("/{id}")
    public void borrar( @PathParam("id") Integer id) {
        this.personaService.borrar(id);
    }

}
