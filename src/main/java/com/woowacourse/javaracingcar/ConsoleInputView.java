package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.interfaces.InputView;

import java.util.List;
import java.util.Scanner;

public class ConsoleInputView implements InputView {
    private static final int TRIES_MIN = 1;

    @Override
    public List<String> promptUserNames() {
        final String promptText = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
        final Scanner scanner = new Scanner(System.in);

        System.out.println(promptText);
        List<String> splittedNames = RacingcarUtil.splitIntoNames(scanner.nextLine());

        while (!RacingcarUtil.isValidNameInput(splittedNames)) {
            System.out.println("잘못된 입력입니다");
            System.out.println(promptText);
            splittedNames = RacingcarUtil.splitIntoNames(scanner.nextLine());
        }

        return splittedNames;
    }

    @Override
    public int promptTries() {
        final String promptText = "시도할 회수는 몇회인가요?";
        final Scanner scanner = new Scanner(System.in);

        System.out.println(promptText);
        int input = scanner.nextInt();

        while (!isValidTries(input)) {
            System.out.println("잘못된 입력입니다");
            System.out.println(promptText);
            input = scanner.nextInt();
        }

        return input;
    }

    private boolean isValidTries(int tries) {
        return tries >= TRIES_MIN;
    }
}
