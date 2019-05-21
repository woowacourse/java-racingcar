package racing.model;

import java.util.*;

public class CarNamesInput {
    private static final int NAME_LENGTH_LIMIT_TOP = 5;
    private static final int NAME_LENGTH_LIMIT_BOTTOM = 1;
    private final List<String> names;

    public CarNamesInput(final String input) throws Exception {
        String[] names = splitNames(input);
        checkCarNamesValidity(names);
        this.names = Arrays.asList(splitNames(input));
    }

    public List<String> getNames() {
        return names;
    }

    private String[] splitNames(String names) {
        return names.replaceAll(" ", "").split(",");
    }


    private void checkCarNamesValidity(String[] names) throws Exception {
        if (checkInvalidNameLength(names) || checkNoInput(names) ||
                checkRepetition(names, new HashSet(Arrays.asList(names)))) {
            throw new Exception("잘못된 입력입니다.");
        }
    }

    private boolean checkInvalidNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > NAME_LENGTH_LIMIT_TOP || name.length() < NAME_LENGTH_LIMIT_BOTTOM)
                return true;
        }
        return false;
    }

    private boolean checkNoInput(String[] names) {
        return names.length == 0;
    }

    private boolean checkRepetition(String[] names, Set<String> namesWithoutRepetition) {
        return names.length != namesWithoutRepetition.size();
    }
}
