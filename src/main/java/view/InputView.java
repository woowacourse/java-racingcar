package view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);
    inputValidater inputValidater = new inputValidater();

    public Cars readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        inputValidater.validateCars(input);
        return Cars.from(Arrays.asList(input.split(",")));
    }


    public int readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = scanner.nextLine();
        inputValidater.validateCount(input);
        return Integer.parseInt(input);
    }
}
