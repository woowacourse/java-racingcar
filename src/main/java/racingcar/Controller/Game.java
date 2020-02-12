package racingcar.Controller;

import racingcar.Model.Car;
import racingcar.View.InputView;

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
}
