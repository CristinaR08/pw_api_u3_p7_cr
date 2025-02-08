package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Persona;

@Transactional
@ApplicationScoped
public class PersonaRepositoryImpl implements IPersonaRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Persona buscarPorId(Integer id) {
        try {
            return this.entityManager.find(Persona.class, id);
        } catch (Exception e) {
            Persona p = new Persona();
            System.out.println(p);
            return p;
        }
    }

    @Override
    public List<Persona> buscarTodos() {
        TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p", Persona.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Persona> buscarPorNombre(String nombre) {
        TypedQuery<Persona> myQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.nombre =: nombre", Persona.class);
        myQuery.setParameter("nombre", nombre);
        return myQuery.getResultList();
    }

    
    @Override
    public List<Persona> buscarApellidoNombre(String apellido, String nombre) {
        TypedQuery<Persona> mQuery = this.entityManager.createQuery("SELECT p FROM Persona p WHERE p.apellido =: apellido AND p.nombre =: nombre", Persona.class);
        mQuery.setParameter("apellido", apellido);
        mQuery.setParameter("nombre", nombre);
        return mQuery.getResultList();
    }



    @Override
    public void insertar(Persona persona) {
        this.entityManager.persist(persona);
    }

    @Override
    public void actualizar(Persona persona) {
        this.entityManager.merge(persona);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscarPorId(id));
    }

   
}
