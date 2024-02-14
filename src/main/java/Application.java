public class Application {

    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(new InputView(), new OutputView());
        racingGameController.run();
    }
}
