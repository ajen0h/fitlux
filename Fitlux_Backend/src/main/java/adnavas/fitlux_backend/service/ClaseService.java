package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Clase;
import adnavas.fitlux_backend.entity.Usuario;
import org.bson.types.ObjectId;

import java.util.List;

public interface ClaseService {
    List<Clase> findAll();
    Clase findById(ObjectId id);
    Clase addClase(Clase clase);
    Clase deleteClase(ObjectId id);
    Clase updateClase(ObjectId id, Clase clase);

    List<Clase>findClasesByDeporte_id(ObjectId deporteId);

    List<Usuario>listarUsuariosClase(List<ObjectId> userIds);

    boolean registrarUsuario(ObjectId claseId,ObjectId userId);
    boolean eliminarRegistroUsuario(ObjectId claseId,ObjectId userId);
}
