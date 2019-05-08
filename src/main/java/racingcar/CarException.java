package racingcar;

import racingcar.Car;

import java.util.*;

public class CarException {
    public static List<String> askCarNamesException(List<String> names){
        try {
            if (isWhiteSpaceOnly(names) || isDuplicate(names) || isOverLimit(names)){
                throw new IllegalArgumentException();
            }
            return names;
        } catch(Exception e) {
            return Car.askCarNames();
        }
    }

    public static boolean isWhiteSpaceOnly(List<String> names) {
        boolean result = false;
        for(int i=0; i<names.size();){
            result = names.get(i).isEmpty();
            i = (result) ? names.size() : i + 1;
        }
        return result;
    }

    public static boolean isDuplicate(List<String> names) {
        Set<String> nameSet = new HashSet<>(names);
        if (names.size() != nameSet.size()) {
            System.out.println("이름에 중복이 있습니다!");
            return true;
        }
        return false;
    }

    public static boolean isOverLimit(List<String> names) {
        boolean overLimit = false;
        while (!overLimit && !names.isEmpty()) {
            overLimit = checkLimit(names.get(0));
            names.remove(0);
        }
        return overLimit;
    }

    public static boolean checkLimit(String name) {
        if (name.length() > 5 || name.length() <= 0) {
            System.out.println("이름은 0글자 이상 5글자 이하만 입력해 주세요!");
            return true;
        }
        return false;
    }

    public static int askTotalTurnsException() {
        try {
            int userInput = askAndReceiveTurns();
            if (userInput <= 0) {throw new IllegalArgumentException();}
            return userInput;
        }catch(Exception e) {
            return askTotalTurnsException();
        }
    }

    public static int askAndReceiveTurns() {
        System.out.println("시도할 횟수는 몇회인가요?: ");
        Scanner reader = new Scanner(System.in);
        int userInput = reader.nextInt();
        return userInput;
    }
}
