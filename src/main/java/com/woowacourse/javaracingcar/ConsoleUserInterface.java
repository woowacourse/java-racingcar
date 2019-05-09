package com.woowacourse.javaracingcar;

import com.woowacourse.javaracingcar.domain.Car;
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
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();
        String[] splittedNames = RacingCarUtil.splitIntoNames(input);
        if (!RacingCarUtil.isValidNameInput(splittedNames)) {
            return onInvalidUserNames();
        }

        List<String> splittedNameList = new ArrayList<>();
        for (String str : splittedNames) {
            splittedNameList.add(str);
        }
        return splittedNameList;
    }

    @Override
    public int promptTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input = scanner.nextInt();

        if (!isValidTries(input)) {
            onInvalidTries();
        }

        return input;
    }

    @Override
    public void printResult(List<Car> cars) {
        if (!isResultTitlePrinted) {
            System.out.println("실행 결과");
            isResultTitlePrinted = true;
        }

        for (Car c : cars) {
            System.out.println(c);
        }

        System.out.println();
    }

    @Override
    public void printWinners(List<Car> winners) {
        String str = RacingCarUtil.joinCarNames(winners);
        System.out.println(str + "가 최종 우승했습니다.");
    }

    @Override
    public List<String> onInvalidUserNames() {
        System.out.println("잘못된 입력입니다");
        return promptUserNames();
    }

    @Override
    public int onInvalidTries() {
        System.out.println("잘못된 입력입니다");
        return promptTries();
    }

    private boolean isValidTries(int tries) {
        return tries > 0;
    }
}
