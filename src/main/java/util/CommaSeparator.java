package util;

import static exception.ErrorMessage.ENTER_NAME_WITH_COMMA;
import static java.util.Collections.addAll;

import exception.CommaNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CommaSeparator {

    private static final String COMMA = ",";

    public static List<String> sliceNameByComma(final String names) {
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
            throw new CommaNotFoundException(ENTER_NAME_WITH_COMMA.toString());
        }
    }
}
