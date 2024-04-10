package adnavas.fitlux_backend.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
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

    private String username;

    private String dni;

    private String password;

    private String email;

    private String role;

    private boolean enabled;

}