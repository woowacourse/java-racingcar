package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.CarDto;
import com.woowacourse.javaracingcar.interfaces.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUserInterface implements UserInterface {
    private final Scanner scanner;
    private boolean isResultTitlePrinted;

    public ConsoleUserInterface() {
        this.scanner = new Scanner(System.in);
        isResultTitlePrinted = false;
    }

    @Override
    public List<String> promptUserNames() {
        final String promptText = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
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
        System.out.println(promptText);
        int input = scanner.nextInt();

        while (!isValidTries(input)) {
            System.out.println("잘못된 입력입니다");
            System.out.println(promptText);
            input = scanner.nextInt();
        }

        return input;
    }

    @Override
    public void printResult(List<CarDto> cars) {
        if (!isResultTitlePrinted) {
            System.out.println("실행 결과");
            isResultTitlePrinted = true;
        }

        for (CarDto c : cars) {
            System.out.println(c);
        }

        System.out.println();
    }

    @Override
    public void printWinners(List<CarDto> winners) {
        String str = RacingcarUtil.joinCarNames(winners);
        System.out.println(str + "가 최종 우승했습니다.");
    }

    private boolean isValidTries(int tries) {
        return tries > 0;
    }
}
