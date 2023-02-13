package racingcar.dto;

import static racingcar.domain.Name.Validator.*;

import java.util.List;

public class RacingCarNamesRequest {
    private final List<String> names;

    private RacingCarNamesRequest(List<String> names) {
        this.names = names;
    }

    public static RacingCarNamesRequest of(String input) {
        String[] names = input.split(",");
        validate(names);
        return new RacingCarNamesRequest(List.of(names));
    }

    private static void validate(String[] names) {
        for (String name : names) {
            validateBlankName(name);
            validateNameLength(name);
        }
        validateDuplicateNames(names);
    }

    public List<String> getNames() {
        return names;
    }
}
