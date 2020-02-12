package racing.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingReqDTO {

    private static final String DELIMITER = ",";
    private final List<String> names;
    private final int count;

    public RacingReqDTO(String names, int count) {
        this.names = Arrays.stream(names.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        this.count = count;
    }

    public List<String> getNames() {
        return Collections.unmodifiableList(this.names);
    }

    public int getCount() {
        return count;
    }
}
