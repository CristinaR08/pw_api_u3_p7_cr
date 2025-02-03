package uce.edu.web.api.service;

import java.util.function.Function;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import uce.edu.web.api.repository.IEstudianteRepository;
import uce.edu.web.api.repository.modelo.Estudiante;
import uce.edu.web.api.service.to.EstudianteTo;

@ApplicationScoped
public class EstudianteServiceImpl implements IEstudianteService {

    private Function<EstudianteTo, Estudiante> mapEstudiante = e -> {
        Estudiante estudiante = new Estudiante(e.getId(), e.getNombre(), e.getApellido(), e.getCedula(), e.getCorreo(),
                e.getTelefono());
        return estudiante;
    };

    private Function<Estudiante, EstudianteTo> mapTo = eTo -> {
        EstudianteTo estudiante = new EstudianteTo(eTo.getId(), eTo.getNombre(), eTo.getApellido(), eTo.getCedula(),
                eTo.getCorreo(), eTo.getTelefono());
        return estudiante;
    };

    @Inject
    private IEstudianteRepository iEstudianteRepository;

    @Override
    public void guardar(EstudianteTo estudiante) {
        this.iEstudianteRepository.insertar(this.mapEstudiante.apply(estudiante));
    }

    @Override
    public void actualizar(EstudianteTo estudiante) {
        Estudiante est = this.mapEstudiante.apply(estudiante);
        this.iEstudianteRepository.actualizar(est);
    }

    @Override
    public void borrar(Integer id) {
        this.iEstudianteRepository.eliminar(id);
    }

    @Override
    public EstudianteTo buscar(Integer id) {
        Estudiante est = this.iEstudianteRepository.buscar(id);
        return this.mapTo.apply(est);
    }

}
