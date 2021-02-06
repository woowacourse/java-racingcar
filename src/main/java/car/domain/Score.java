package car.domain;

public final class Score {
    
    private final Name name;
    
    private final Position position;
    
    public Score(Name name, Position position) {
        this.name = name;
        this.position = position;
    }
    
    public String getName() {
        return name.getName();
    }
    
    public int getPosition() {
        return position.getPosition();
    }
}
