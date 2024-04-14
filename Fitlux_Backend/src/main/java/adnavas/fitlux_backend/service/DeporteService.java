package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Deporte;
import org.bson.types.ObjectId;

import java.util.List;

public interface DeporteService {
    List<Deporte> findAll();
    Deporte findById(ObjectId id);
    Deporte addDeporte(Deporte deporte);
    Deporte deleteDeporte(ObjectId id);
    Deporte updateDeporte(ObjectId id, Deporte deporte);
}
