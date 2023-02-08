package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    List<Car> Cars = new ArrayList<>();

    public Cars(String userInput) {
        validateNotNull(userInput);
        validateHasComma(userInput);
        validateLength(userInput);
    }


    private void validateNotNull(String userInput) {
        if (userInput == null || "".equals(userInput)) {
            throw new IllegalArgumentException("자동차 이름을 입력해주세요");
        }
    }

    private void validateHasComma(String userInput) {
        if (userInput.indexOf(',') == -1) {
            throw new IllegalArgumentException("두 대 이상 입력해주세요");
        }
    }

    private void validateLength(String userInput) {
        String[] userInputSplit = userInput.split(",");
        if (userInputSplit.length > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("dkdkd");
        }
        for(String inputSplit :userInputSplit){
            Cars.add(new Car(inputSplit));
        }
    }
}
