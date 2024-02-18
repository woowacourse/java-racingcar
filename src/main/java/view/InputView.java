package view;

import util.Exceptions;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        return scanner.nextLine().trim();
    }

    public int inputRound() {
        System.out.println("시도할 회수는 몇회인가요?");
        String rawRound = scanner.nextLine().trim();
        try {
            return Integer.parseInt(rawRound);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Exceptions.NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }
}
