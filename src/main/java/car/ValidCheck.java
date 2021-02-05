package car;

import java.util.Arrays;
import java.util.regex.Pattern;

public class ValidCheck {
    
    
    private ValidCheck() {
    
    }
    
    public static void carNameValid(String carNamesInput) {
        if (isSpace(carNamesInput) || isNameLength(carNamesInput)) {
            throw new IllegalArgumentException();
        }
    }
    
    public static void round(String roundInput) {
        final String pattern = "[1-9]+[0-9]*";
        if (!Pattern.matches(pattern, roundInput)) {
            throw new IllegalArgumentException();
        }
    }
    
    private static boolean isSpace(String carNamesInput) {
        return carNamesInput.contains(" ");
    }
    
    private static boolean isNameLength(String carNamesInput) {
        final String delimiter = ",";
        String[] carNames = carNamesInput.split(delimiter);
        
        return Arrays.stream(carNames)
                     .anyMatch(name -> name.length() > 5);
    }
    
    
}

//자동차 이름 예외 체크
//시도 횟수 예외 체크

// 라운드 결과 출력
// 우승자 출력
