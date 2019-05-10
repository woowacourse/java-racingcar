package racing.model;

public class RoundNumberInput {
    public static int getRoundNumber(String input) throws Exception {
        int roundNumber = Integer.parseInt(input);
        if (roundNumber < 1) {
            throw new Exception();
        }
        return roundNumber;
    }

}
