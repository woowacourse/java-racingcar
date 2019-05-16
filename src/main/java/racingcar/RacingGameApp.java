package racingcar;

public class RacingGameApp {
    public static void main(String[] args) {
        RacingGameResult result = null;
        RacingGame game = new RacingGame(Input.carNames(), Input.totalRound());
        Output.print(Output.GAME_START);
        for (int i = 0; i < game.getTotalRound(); i++) {
            result = new RacingGameResult(game.playOneRound());
            Output.print(result.getCarsStatString());
        }
        Output.finalWinner(result);
    }
}
