package racingcar.domain;

import java.util.Map;

public class RoundResult implements Map.Entry<String, Integer> {
    private final String carName;
    private int position;

    public RoundResult(String carName, int position) {
        this.carName = carName;
        this.position = position;
    }

    @Override
    public String getKey() {
        return carName;
    }

    @Override
    public Integer getValue() {
        return position;
    }

    @Override
    public Integer setValue(Integer value) {
        int oldPosition = position;
        position = value;
        return oldPosition;
    }
}
