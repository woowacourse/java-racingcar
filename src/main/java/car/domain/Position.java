package car.domain;

import java.util.Objects;

final class Position {
    
    private static final int DEFAULT_POSITION = 0;
    
    private static final int ONE_STEP = 1;
    
    private final int position;
    
    public Position() {
        this(DEFAULT_POSITION);
    }
    
    private Position(int position) {
        this.position = position;
    }
    
    public static Position from(int position) {
        if (isNegative(position)) {
            throw new IllegalArgumentException();
        }
        
        return new Position(position);
    }
    
    private static boolean isNegative(int position) {
        return position < 0;
    }
    
    public int getPosition() {
        return position;
    }
    
    public Position increase() {
        return new Position(position + ONE_STEP);
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
