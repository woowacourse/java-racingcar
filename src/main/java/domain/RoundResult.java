package domain;

public class RoundResult {
    private final Integer movingCondition = 4;

    public boolean isGo(Integer randomNumber) {
        return randomNumber >= movingCondition;
    }
}
