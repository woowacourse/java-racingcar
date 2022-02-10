package racingcar.controller;

import racingcar.view.InputView;

import java.util.List;

public class Controller {
    public void run() {
        List<String> cars = InputView.getCarNames();
        cars.stream().forEach(System.out::println);

        int trialNumber = InputView.getTrialNumber();
        System.out.println(trialNumber);
    }
}
