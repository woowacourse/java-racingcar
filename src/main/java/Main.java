import domain.Car;
import domain.RacingGame;

import java.util.ArrayList;

public class Main {
    public static void main(String [] args) {
        // 입력 받기
        ArrayList<Car> cars = new ArrayList();

        int nTrials = 10;

        RacingGame racingGame = new RacingGame();
        racingGame.play();
    }
}
