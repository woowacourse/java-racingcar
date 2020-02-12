package racingcar.io;

import racingcar.domain.Car;

import java.util.List;
import java.util.Scanner;

public class userInput {
    static final Scanner scanner = new Scanner(System.in);

    public static String inputCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return scanner.nextLine();
    }

    public static int inputIteration() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return scanner.nextInt();
    }


}
