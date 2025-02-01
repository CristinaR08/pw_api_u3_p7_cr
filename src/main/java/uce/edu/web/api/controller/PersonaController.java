package uce.edu.web.api.controller;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    @Path("/buscar")
    @GET
    public PersonaTo buscarPorId() {
        Integer id = 1;
        return this.personaService.buscarPorId(id);
        //return Response.ok(this.personaService.buscarPorId(id)).build();
    }

    @POST
    @Path("/guardar")
    public void guardar(PersonaTo persona) {
        this.personaService.guardar(persona);
    }

    @PUT
    @Path("/actualizar")
    public void actualizar(PersonaTo persona) {
        this.personaService.actualizar(persona);
    }

    @PATCH
    @Path("/actualizarParcial")
    public void actualizarParcial(PersonaTo persona) {
        PersonaTo tmp = this.personaService.buscarPorId(persona.getId());
        tmp.setNombre(persona.getNombre());
        this.personaService.actualizar(tmp);
    }

    @DELETE
    @Path("/borrar")
    public void borrar() {
        Integer id = 1;
        this.personaService.borrar(id);
    }

}
