package domain;

import exception.CommaNotFoundException;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.addAll;

public class Names {

    private static final String COMMA = ",";

    private final List<Name> names = new ArrayList<>();

    public Names(final String input) {
        sliceNameByComma(input).stream()
                .map(Name::new)
                .forEach(names::add);
    }

    private static List<String> sliceNameByComma(final String names) {
        validateComma(names);

        return getSplitName(names);
    }

    private static List<String> getSplitName(final String names) {
        List<String> splitNames = new ArrayList<>();
        addAll(splitNames, names.split(COMMA));

        return splitNames;
    }

    private static void validateComma(final String names) {
        if (!names.contains(COMMA)) {
            throw new CommaNotFoundException();
        }
    }

    public List<Name> getNames() {
        return names;
    }
}
