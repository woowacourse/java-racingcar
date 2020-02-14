package racinggame.domain.car;

public class Position {
    private int position;

    public Position(int position) {
        this.position = position;
    }

    public boolean match(int position) {
        return position == this.position;
    }
}
