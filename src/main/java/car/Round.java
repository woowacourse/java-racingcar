package car;

public final class Round {
    
    private final int round;
    
    private Round(int round) {
        this.round = round;
    }
    
    public static Round from(int round) {
        if (!isPositive(round)) {
            throw new IllegalArgumentException();
        }
        
        return new Round(round);
    }
    
    private static boolean isPositive(int round) {
        return round >= 1;
    }
    
    public int getRound() {
        return round;
    }
}
