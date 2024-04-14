package adnavas.fitlux_backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "usuarios")
public class Usuario {
    @Id
    private ObjectId _id;

    @Indexed(unique = true)
    private String username;

    @Indexed(unique = true)
    private String email;

    private String password;

    @Indexed(unique = true)
    private String dni;

    private String fullname;

    private String role;

    private boolean enabled;

    public Usuario(String username, String email, String password, String dni, String fullname, String role, boolean enabled) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.fullname = fullname;
        this.role = role;
        this.enabled = enabled;
    }
}