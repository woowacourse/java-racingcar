package racingCar.domain;

import java.util.stream.IntStream;

public class PlayerInfoPair {
    private String name;
    private int position;

    public PlayerInfoPair(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(name);
        stringBuilder.append(" : ");
        IntStream.range(0, position)
                .forEach((t) -> stringBuilder.append("-"));
        return stringBuilder.toString();
    }
}
