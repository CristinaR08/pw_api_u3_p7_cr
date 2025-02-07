package uce.edu.web.api.repository;

import java.util.List;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import uce.edu.web.api.repository.modelo.Estudiante;

@Transactional
@ApplicationScoped
public class EstudianteRepositoryImpl implements IEstudianteRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Estudiante buscar(Integer id) {
        return this.entityManager.find(Estudiante.class, id);
    }

    @Override
    public void insertar(Estudiante estudiante) {
        this.entityManager.persist(estudiante);
    }

    @Override
    public void actualizar(Estudiante estudiante) {
        this.entityManager.merge(estudiante);
    }

    @Override
    public void eliminar(Integer id) {
        this.entityManager.remove(this.buscar(id));
    }

    @Override
    public List<Estudiante> buscarTodos() {
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e", Estudiante.class);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarPorCedula(String cedula) {
        TypedQuery<Estudiante> myQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.cedula =: cedula", Estudiante.class);
        myQuery.setParameter("cedula", cedula);
        return myQuery.getResultList();
    }

    @Override
    public List<Estudiante> buscarApellidoCedula(String apellido, String cedula) {
        TypedQuery<Estudiante> mQuery = this.entityManager.createQuery("SELECT e FROM Estudiante e WHERE e.apellido =: apellido AND e.cedula =: cedula", Estudiante.class);
        mQuery.setParameter("apellido", apellido);
        mQuery.setParameter("cedula", cedula);
        return mQuery.getResultList();
    }

}
