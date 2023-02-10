package racingcar.domain;

public class Position implements Comparable<Position> {
    private final int INITIAL_DEFAULT_VALUE = 0;
    private final int MOVE_STEP = 1;
    private int value;

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

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o){
        Position position = (Position)o;
        return this.value == position.value;
    }
}
