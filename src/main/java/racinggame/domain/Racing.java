package racinggame.domain;


import racinggame.util.InputView;

import java.util.List;

public class Racing {
    public List<Car> initializeCars() {
        return null;
    }

    public void startLeague(List<Car> cars, int trial) {

    }

    public static void main(String[] args) {
        Racing racing = new Racing();
        List<Car> cars = racing.initializeCars();
        int trial = InputView.getTrial();

        racing.startLeague(cars, trial);
    }
}
