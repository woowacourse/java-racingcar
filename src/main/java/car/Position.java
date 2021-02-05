package car;

import java.util.Objects;

public class Position {
    
    private final int position;
    
    public static Position from(int position) {
        if (!isNegative(position)) {
            throw new IllegalArgumentException();
        }
    
        return new Position(position);
    }
    
    private static boolean isNegative(int position) {
        return position < 0;
    }
    
    private Position(int position) {
        this.position = position;
    }
    
    public Position increase() {
        return new Position(position + 1);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position1 = (Position) o;
        return position == position1.position;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
