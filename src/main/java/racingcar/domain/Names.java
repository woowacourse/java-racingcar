package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Names {
    private List<Name> names;

    public Names(String names) {
        this.names = Arrays.stream(splitNames(names))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private String[] splitNames(String names) {
        return Stream.of(names.split(","))
                .map(s -> s.replaceAll(" ", ""))
                .toArray(String[]::new);
    }

}
