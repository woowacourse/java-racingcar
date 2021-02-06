package car.domain;

public final class Score {
    
    private final String name;
    
    private final int position;
    
    public Score(String name, int position) {
        this.name = name;
        this.position = position;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPosition() {
        return position;
    }
}
