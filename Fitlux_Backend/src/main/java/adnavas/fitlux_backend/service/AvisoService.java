package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Aviso;
import org.bson.types.ObjectId;

import java.util.List;

public interface AvisoService {
    List<Aviso> findAll();
    Aviso findById(ObjectId id);
    Aviso addAviso(Aviso aviso);
    Aviso deleteAviso(ObjectId id);
    Aviso updateAviso(ObjectId id, Aviso aviso);
}
