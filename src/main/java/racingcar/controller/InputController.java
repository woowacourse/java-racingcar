package racingcar.controller;

import racingcar.domain.Car;
import racingcar.view.Input;

import java.util.ArrayList;
import java.util.List;

public class InputController {
    public static void inputData(List<Car> carList) {
        saveCarList(carList);
        savaTryNumber();
    }
    
    private static void saveCarList(List<Car> carList) {
        while(true){
            String names = Input.inputCarNames();
            
            try{
                Validation.carNameValidation(names);
                carList = splitList(names);
                return;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Car> splitList(String names) {
        List<Car> carList = new ArrayList<>();
        String[] carNames = names.split(",");

        for (String carName : carNames) {
            carList.add(new Car(carName));
        }

        return carList;
    }

    private static void savaTryNumber() {
        String tryValue = Input.inputTry();
        
    }
}
