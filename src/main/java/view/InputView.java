package view;

import java.util.List;
import java.util.Scanner;

import static util.StringUtil.isCarNameLength;
import static util.StringUtil.parseStringByComma;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String inputString = scanner.nextLine();

        List<String> nameList = parseStringByComma(inputString);

        for (String carName : nameList) {
            if (!isCarNameLength(carName)) {
                System.out.println("자동차 이름은 5자이하 입니다.");
                return getCarNames();
            }
        }

        return nameList;
    }

    public static int inputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해 주세요");
            return  inputTryNum();
        }
    }


}
