package racingcar;

public class StringParser {
    public static void validateCarName(String input) {
        //input=input.trim();
        if (input.matches(".*[^0-9a-zA-Zㄱ-ㅎ가-힣_]+.*")) {
            throw new RuntimeException("올바르지 않은 입력 형식입니다.");
        }
        if (input.length() > 5) {
            throw new RuntimeException("이름은 최대 5자입니다.");
        }
    }

    public static String[] readCarNameInputs(String inputs) {
        inputs=inputs.replaceAll(" ","");
        String[] carNames = inputs.split(",");
        for (String carName : carNames) {
            validateCarName(carName);
        }
        return carNames;
    }
}
