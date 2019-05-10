package com.woowacourse.javaracingcarwithoutif;

import com.woowacourse.javaracingcarwithoutif.domain.CarDto;
import com.woowacourse.javaracingcarwithoutif.interfaces.UserInterface;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

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
        List<String> splittedNames = RacingcarUtil.splitIntoNames(scanner.nextLine());

        while (!RacingcarUtil.isValidNameInput(splittedNames)) {
            System.out.println("잘못된 입력입니다");
            System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
            splittedNames = RacingcarUtil.splitIntoNames(scanner.nextLine());
        }

        return splittedNames;
    }

    @Override
    public int promptTries() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input = scanner.nextInt();

        while (!isValidTries(input)) {
            System.out.println("잘못된 입력입니다");
            System.out.println("시도할 회수는 몇회인가요?");
            input = scanner.nextInt();
        }

        return input;
    }

    @Override
    public void printResult(List<CarDto> cars) {
        // 정말 이렇게 하는 게 맞는걸까...?(2)
        Optional<Boolean> optFlag = Optional.of(isResultTitlePrinted);
        Supplier<Boolean> flagSwitch = () -> optFlag
            .filter(i -> !i)
            .map(i -> {
                System.out.println("실행 결과");
                return true;
            }).orElse(true);
        isResultTitlePrinted = flagSwitch.get();

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
