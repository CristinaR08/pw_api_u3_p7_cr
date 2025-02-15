package uce.edu.web.api.controller;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @GET
    @Path("/{id}") //pathVariable
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarPorId(@PathParam("id") Integer id) {
        return Response.status(240).header("mensaje", "Persona creada pero en proceso de validación... :3")
        .header("valor1", 500)
        .entity(this.personaService.buscarPorId(id)).build();
        //return this.personaService.buscarPorId(id);
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
    @Consumes(MediaType.APPLICATION_JSON)
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
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarParcial(PersonaTo persona, @PathParam("id") Integer id) {
        PersonaTo tmp = this.personaService.buscarPorId(id);        
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
        return Response.ok(tmp).build();
    }

    @DELETE
    @Path("/{id}")
    public void borrar( @PathParam("id") Integer id) {
        this.personaService.borrar(id);
    }

}
