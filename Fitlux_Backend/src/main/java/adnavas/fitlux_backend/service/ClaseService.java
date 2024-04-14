package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Clase;
import org.bson.types.ObjectId;

import java.util.List;

public interface ClaseService {
    List<Clase> findAll();
    Clase findById(ObjectId id);
    Clase addClase(Clase clase);
    Clase deleteClase(ObjectId id);
    Clase updateClase(ObjectId id, Clase clase);
}
