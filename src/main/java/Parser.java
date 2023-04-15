import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Parser {
    private ObjectMapper mapper = new ObjectMapper();
    public List<Facts> parse(InputStream inputStream) {
        List<Facts> catFacts = null;
        try {
            catFacts = mapper.readValue(inputStream, new TypeReference<List<Facts>>() {
            });
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
        return catFacts;
    }
}
