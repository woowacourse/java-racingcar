package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
import com.woowacourse.javaracingcar.interfaces.NumberGenerator;
import com.woowacourse.javaracingcar.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class AppMain {

    public static void main(String[] args) {
        UserInterface ui = new ConsoleUserInterface();

        List<String> carNames = ui.promptUserNames();
        int tries = ui.promptTries();
        NumberGenerator generator = new RandomNumberGenerator();
        Game game = new Game(generator, createCars(carNames));

        for (int i = 0; i < tries; i++) {
            List<Car> cars = game.loop();
            ui.printResult(cars);
        }

        ui.printWinners(game.getWinners());
    }

    public static List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String s : carNames) {
            cars.add(new Car(s));
        }

        return cars;
    }
}
