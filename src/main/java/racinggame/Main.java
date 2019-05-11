package racinggame;

        import racinggame.view.UserInput;
        import racinggame.view.resultOutput;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        CarGenerator cg = new CarGenerator();
        Winner winner;

        winner = game.playGames(cg.createCars(), UserInput.inputGameCount());
        resultOutput.winnersOutput(winner.getWinners());
    }
}