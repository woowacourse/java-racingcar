package handler;

import java.io.IOException;

import domain.Cars;
import view.InputView;

public class InputHandler {

    private InputView inputView = new InputView();

    public Cars readCars() throws IOException {
        String inputName = inputView.readCarNames();
        String[] names = inputName.split(",");

        return new Cars(names);
    }
}
