package ru.job4j.dream.Serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.job4j.dream.model.CandidateJson;

import java.io.IOException;

public class CustomCandidateSerializer extends StdSerializer<CandidateJson> {

    public CustomCandidateSerializer() {
        this(null);
    }

    public CustomCandidateSerializer(Class<CandidateJson> t) {
        super(t);
    }
    @Override
    public void serialize(
            CandidateJson candidate, JsonGenerator jsonGenerator, SerializerProvider serializer) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("firstName", candidate.getFirstName());
        jsonGenerator.writeStringField("lastName", candidate.getLastName());
        jsonGenerator.writeStringField("password", candidate.getPassword());
        jsonGenerator.writeEndObject();
    }
}
