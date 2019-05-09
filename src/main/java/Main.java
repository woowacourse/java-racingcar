import domain.Car;
import domain.RacingGame;
import view.InputView;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        // 입력 받기
        String [] names = InputView.readNames();
        ArrayList<Car> cars;

        int nTrials = InputView.readNumber();

        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
