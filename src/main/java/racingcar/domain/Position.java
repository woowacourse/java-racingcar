package racingcar.domain;

import java.util.Comparator;

public class Position implements Comparable<Position> {
    private final Integer INITIAL_DEFAULT_VALUE = 0;
    private final Integer MOVE_STEP = 1;
    private Integer value;

    public Position() {
        this.value = INITIAL_DEFAULT_VALUE;
    }

    public void increasePosition() {
        this.value += MOVE_STEP;
    }

    @Override
    public int compareTo(Position o) {
        if(this.value > o.value){
            return 1;
        }
        if(this.value == o.value){
            return 0;
        }
        return -1;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        Position position = (Position)o;
        return this.value == position.value;
    }
}
