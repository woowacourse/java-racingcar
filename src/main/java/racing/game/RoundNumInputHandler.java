package racing.game;

public class RoundNumInputHandler {
    private static final int ROUND_MIN_LIMIT = 1;

    public static int getRoundNumber(String input) throws Exception {
        int roundNumber = Integer.parseInt(input);
        if (roundNumber < ROUND_MIN_LIMIT)
            throw new Exception();
        return roundNumber;
    }
}
