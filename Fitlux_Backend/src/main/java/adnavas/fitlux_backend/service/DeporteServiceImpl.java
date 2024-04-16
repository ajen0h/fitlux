package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Deporte;
import adnavas.fitlux_backend.repository.DeporteRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeporteServiceImpl implements DeporteService{

    @Autowired
    DeporteRepository deporteRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Deporte> findAll() {
        return deporteRepository.findAll();
    }

    @Override
    public Deporte findById(ObjectId id) {
        return deporteRepository.findBy_id(id);
    }

    @Override
    public Deporte addDeporte(Deporte deporte) {
        return deporteRepository.save(deporte);
    }

    @Override
    public Deporte deleteDeporte(ObjectId id) {
        Deporte deporteDelete = deporteRepository.findBy_id(id);
        deporteRepository.delete(deporteDelete);
        return deporteDelete;
    }

    @Override
    public Deporte updateDeporte(ObjectId id, Deporte deporte) {
        Deporte deporteUpdate = deporteRepository.findBy_id(id);
        deporteUpdate.setNombre(deporte.getNombre());
        deporteUpdate.setDescripcion(deporte.getDescripcion());
        deporteRepository.save(deporteUpdate);
        return deporteUpdate;
    }
}
