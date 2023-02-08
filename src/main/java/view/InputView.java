package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        return Arrays.asList(input.split(","));
    }

    public String getTrial() {
        System.out.println("시도할 횟수는 몇회인가요?");
        return scanner.nextLine();
    }
}
