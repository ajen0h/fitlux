package adnavas.fitlux_backend.service;

import adnavas.fitlux_backend.entity.Usuario;
import adnavas.fitlux_backend.repository.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Usuario findById(ObjectId id) {
        return userRepository.findBy_id(id);
    }

    @Override
    @Transactional
    public Usuario addUsuario(Usuario user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.set_id(ObjectId.get());
        return userRepository.save(user);
    }

    @Override
    public Usuario deleteUsuario(ObjectId id) {
        Usuario usuarioDelete = userRepository.findBy_id(id);
        userRepository.delete(usuarioDelete);
        return usuarioDelete;
    }

    @Override
    public Usuario updateUsuario(ObjectId id, Usuario usuario) {
        Usuario usuarioUpdate = userRepository.findBy_id(id);
        usuarioUpdate.setDni(usuario.getDni());
        usuarioUpdate.setRole(usuario.getRole());
        usuarioUpdate.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuarioUpdate.setEmail(usuario.getEmail());
        usuarioUpdate.setUsername(usuario.getUsername());

        userRepository.save(usuarioUpdate);

        return usuarioUpdate;
    }
}
