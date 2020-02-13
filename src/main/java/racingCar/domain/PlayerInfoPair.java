package racingCar.domain;

import java.util.stream.IntStream;

public class PlayerInfoPair {
    private static final String COLON_WRAPPED_WITH_SPACE = " : ";
    private static final String HYPHEN = "-";

    private String name;
    private int position;

    public PlayerInfoPair(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.append(COLON_WRAPPED_WITH_SPACE);
        IntStream.range(0, position)
                .forEach((t) -> stringBuilder.append(HYPHEN));
        return stringBuilder.toString();
    }
}
