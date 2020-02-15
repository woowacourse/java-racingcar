package racingcargame.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    private static final String DELIMITER = ",";
    private List<Name> names;

    public Names(List<Name> names) {
        this.names = names;
    }

    public static Names valueOf(String[] strings) {
        return new Names(Arrays.stream(strings)
                .map(Name::new)
                .collect(Collectors.toList()));
    }

    public static Names valueOf(String string) {
        return valueOf(string.split(DELIMITER));
    }

    public List<Name> getNames() {
        return names;
    }
}
