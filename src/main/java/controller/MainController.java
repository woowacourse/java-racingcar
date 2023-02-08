package controller;

import java.util.List;
import model.Car;
import model.CarRepository;
import view.InputView;
import view.OutputView;

public class MainController {

    private final InputView inputView;
    private final OutputView outputView;

    public MainController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        List<String> carNames = inputView.readCarNames();
        for (String carName : carNames) {
            CarRepository.addCars(new Car(carName));
        }
    }
}
