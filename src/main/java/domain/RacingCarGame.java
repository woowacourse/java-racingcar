package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;

public class RacingCarGame {

    private static final String DELIMITER = ",";

    private ArrayList<Car> cars = new ArrayList<>();
    private int times;

    public void run() {
        setName();
        setRepeat();
    }

    private void setRepeat() {
        OutputView.inputRepeatInstruction();
        times = InputView.inputRepeat();
    }

    private void setName() {
        OutputView.inputNameInstruction();
        String name = InputView.inputNames();
        String[] names = splitName(name);
        for (String n : names) {
            cars.add(new Car(n));
        }
    }

    private String[] splitName(String name) {
        return name.split(DELIMITER);
    }
}
