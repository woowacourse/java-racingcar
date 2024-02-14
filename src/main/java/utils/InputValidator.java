package utils;

public class InputValidator {
    private static final int CAR_NAME_MAX_LENGTH = 5;
    public static void carNamesValidator(String carNames){
        for(String carName : carNames.split(",")){
            validateCarNameLength(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if(carName.length()> CAR_NAME_MAX_LENGTH){
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_TOO_LONG);
        }
    }
}
