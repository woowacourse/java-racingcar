package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String READ_CARS_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    public List<String> readCarNames(){
        System.out.println(READ_CARS_NAME_MESSAGE);
        return Arrays.asList(scanner.nextLine().trim().split(","));
    }

}
