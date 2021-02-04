package car;

public class Position {
    private final int position;
    
    public Position() {
        this(0);
    }
    
    public Position(int position) {
        this.position = position;
    }
    
    public int getPosition() {
        return position;
    }
    
    public Position move() {
        return new Position(position + 1);
    }
}
