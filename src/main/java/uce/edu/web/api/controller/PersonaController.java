package uce.edu.web.api.controller;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import uce.edu.web.api.service.IPersonaService;
import uce.edu.web.api.service.to.PersonaTo;

@Path("/personas")
public class PersonaController {

    @Inject
    private IPersonaService personaService;

    public void guardar(PersonaTo persona) {
        this.personaService.guardar(persona);
    }

    public void actualizar(PersonaTo persona) {
        this.personaService.actualizar(persona);
    }

    public void borrar(Integer id) {
        this.personaService.borrar(id);
    }

    @Path("/buscar")
    @GET
    public Response buscarPorId() {
        Integer id = 1;
        //return this.personaService.buscarPorId(id);
        return Response.ok(this.personaService.buscarPorId(id)).build();
    }

}
