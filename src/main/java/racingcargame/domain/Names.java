package racingcargame.domain;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Names implements Iterable<Name> {
    private static final String DELIMITER = ",";
    private List<Name> names;

    public Names(List<Name> names) {
        if (names == null) {
            throw new IllegalArgumentException("null값을 입력하지 마시요.");
        }
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

    @Override
    public Iterator<Name> iterator() {
        return names.iterator();
    }
}
