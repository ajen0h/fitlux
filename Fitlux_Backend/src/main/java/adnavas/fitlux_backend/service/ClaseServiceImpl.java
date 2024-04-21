package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Clase;
import adnavas.fitlux_backend.entity.Usuario;
import adnavas.fitlux_backend.repository.ClaseRepository;
import adnavas.fitlux_backend.repository.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClaseServiceImpl implements ClaseService {

    @Autowired
    ClaseRepository claseRepository;

    @Autowired
    UsuarioRepository userRepository;

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
        claseUpdate.setSala_id(clase.getSala_id());
        claseUpdate.setDeporte_id(clase.getDeporte_id());
        claseUpdate.setFechainicio(clase.getFechainicio());
        claseUpdate.setFechafin(clase.getFechafin());
        claseUpdate.setProfesor_id(clase.getProfesor_id());
        claseUpdate.setUsuarios(clase.getUsuarios());
        claseUpdate.setActiva(clase.isActiva());

        claseRepository.save(claseUpdate);

        return claseUpdate;
    }

    @Override
    public List<Clase> findClasesByDeporte_id(ObjectId deporteId) {
        return claseRepository.findClasesByDeporte_id(deporteId);
    }

    @Override
    public List<Usuario> listarUsuariosClase(List<ObjectId> userIds) {
        return userRepository.findBy_idIn(userIds);
    }

    @Override
    public boolean registrarUsuario(ObjectId claseId, ObjectId userId) {
        try {
            Clase clase = findById(claseId);
            if (!clase.getUsuarios().contains(userId)){
                clase.getUsuarios().add(userId);
                claseRepository.save(clase);
                return true;
            }else{
                return false;
            }

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public boolean eliminarRegistroUsuario(ObjectId claseId, ObjectId userId) {
        try {
            Clase clase = findById(claseId);
            if (clase.getUsuarios().contains(userId)){
                clase.getUsuarios().remove(userId);
                claseRepository.save(clase);
                return true;
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }


}
