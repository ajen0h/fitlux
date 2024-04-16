package adnavas.fitlux_backend.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "avisos")
public class Aviso {
    @MongoId
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId _id;
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId usuario_id;
    private String mensaje;

    public Aviso(ObjectId usuario_id, String mensaje) {
        this.usuario_id = usuario_id;
        this.mensaje = mensaje;
    }
}
