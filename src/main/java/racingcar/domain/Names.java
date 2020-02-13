package racingcar.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Names {
    public static final String COMMA = ",";

    private final List<Name> names;

    public Names(String carNames) throws IllegalArgumentException {
        this.names = Arrays.stream(nameSplitValidation(carNames))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    private String[] nameSplitValidation(String carNames) {
        String[] splittedNames = carNames.split(COMMA);
        if (splittedNames.length == 0 || carNames.contains(",,")) {
            throw new IllegalArgumentException("이름을 입력해주세요.");
        }
        return splittedNames;
    }

    public List<Name> getNames() {
        return names;
    }
}
