package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Clase;
import adnavas.fitlux_backend.repository.ClaseRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    ClaseRepository claseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Clase> findAll() {
        return claseRepository.findAll();
    }

    @Override
    public Clase findById(ObjectId id) {
        return claseRepository.findBy_id(id);
    }

    @Override
    @Transactional
    public Clase addClase(Clase clase) {
        return claseRepository.save(clase);
    }

    @Override
    public Clase deleteClase(ObjectId id) {
        Clase claseDelete = claseRepository.findBy_id(id);
        claseRepository.delete(claseDelete);
        return claseDelete;
    }

    @Override
    public Clase updateClase(ObjectId id, Clase clase) {
        Clase claseUpdate = claseRepository.findBy_id(id);
        claseUpdate.setSala(clase.getSala());
        claseUpdate.setDeporte(clase.getDeporte());
        claseUpdate.setFechainicio(clase.getFechainicio());
        claseUpdate.setFechafin(clase.getFechafin());
        claseUpdate.setProfesor(clase.getProfesor());
        claseUpdate.setUsuarios(clase.getUsuarios());
        claseUpdate.setActiva(clase.isActiva());

        claseRepository.save(claseUpdate);

        return claseUpdate;
    }
}
