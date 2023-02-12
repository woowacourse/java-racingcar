import domain.RacingGame;
import view.Input;
import view.Output;

public class Application {
    public static void main(String[] args) {
        Output.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        final String[] carNames = Input.getCarNames(Input.getInput());
        Output.printMessage("시도할 회수는 몇회인가요?");
        final int tryCount = Input.getTryCount(Input.getInput());
        final RacingGame racingGame = new RacingGame(carNames, tryCount);
        racingGame.start();
        Output.printWinner(racingGame.getWinner());
    }
}
