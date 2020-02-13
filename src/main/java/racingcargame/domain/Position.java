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

    public static int compare(Position a, Position b) {
        return Integer.compare(a.value, b.value);
    }
}
