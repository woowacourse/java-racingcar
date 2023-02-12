package racingcar.dto;

import java.util.List;

public class RacingCarNamesRequest {
    private final List<String> names;

    private RacingCarNamesRequest(List<String> names) {
        this.names = names;
    }

    public static RacingCarNamesRequest of(String input) {
        String[] names = input.split(",");
        return new RacingCarNamesRequest(List.of(names));
    }

    public List<String> getNames() {
        return names;
    }
}
