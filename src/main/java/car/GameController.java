package car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private Scanner scanner;
    
    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void start() {
        final String delimiter = ",";
        int round = 0;
        List<Car> carNames = new ArrayList<>();
        String[] carNamesSplit = null;
        
        String carNamesInput = scanner.nextLine();
        
        if (ValidCheck.carNameValid(carNamesInput)) {
            carNamesSplit = carNamesInput.split(delimiter);
        }
        String roundInput = scanner.nextLine();
        
        if (ValidCheck.round(roundInput)) {
            round = Integer.parseInt(roundInput);
        }
        
        for (String carName : carNamesSplit) {
            carNames.add(new Car(carName));
        }
        
        nextStep(carNames, round);
    }
    
    private void nextStep(List<Car> carNames, int round) {
    
    }
}
