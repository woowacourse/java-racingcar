package racingcargame.domain;

public class Position {
    private int value;

    public Position(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isSameToPosition(Position target) {
        return this.value == target.value;
    }

    public void plus(){
        value++;
    }

    public int compare(Position b) {
        return Integer.compare(this.value, b.value);
    }
}
