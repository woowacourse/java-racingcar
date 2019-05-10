package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static List<String> askAndReceiveCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();
        names = names.replaceAll("\\s+","");
        List<String> carNames = new ArrayList<>(Arrays.asList(names.split(",")));
        return carNames;
    }

    public static int askAndReceiveTotalTurns() {
        try {
            int userInput = askAndReceiveTurns();
            checkConditionsForTurns(userInput);
            return userInput;
        }catch(Exception e) {
            return askAndReceiveTotalTurns();
        }
    }

    public static void checkConditionsForTurns(int userInput) {
        if (userInput <= 0) {throw new IllegalArgumentException();}
    }

    public static int askAndReceiveTurns() {
        System.out.println("시도할 횟수는 몇회인가요?: ");
        Scanner reader = new Scanner(System.in);
        int userInput = reader.nextInt();
        return userInput;
    }
}
