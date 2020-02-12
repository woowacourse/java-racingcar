package racing;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputDTO {

    private static final String DELIMITER = ",";
    private List<String> names;

    public InputDTO(String names) {
        this.names = Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public List<String> getNames() {
        return this.names;
    }
}
