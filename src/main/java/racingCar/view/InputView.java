package racingCar.view;

import java.util.Scanner;

public class InputView {

    public static final String DELIMITER = ",";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String inputValue() {
        return scanner.nextLine();
    }

    public String[] inputCarNames() {
        String cars = scanner.nextLine();
        return deleteSpace(cars.split(DELIMITER));
    }

    public String[] deleteSpace(String[] carNames){
        for(int i = 0; i< carNames.length; i++){
            carNames[i] = carNames[i].trim();
        }
        return carNames;
    }

}
