package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> cars = new ArrayList<>();
    private int trialTime;

    public void initialize(){
        String[] carNames = InputView.inputCarName();
        for (String name : carNames){
           cars.add(new Car(name));
        }
        trialTime = InputView.inputTrialTime();
    }

    public void race(){
        OutputView.printResultMessage();
        for (int i = 0; i < trialTime; i++){
            raceOneRound();
        }
        OutputView.printNewLine();
    }

    private void raceOneRound() {
        for (Car car : cars){
            car.goOrNot();
            car.showCurrentPosition();
        }
    }
}
