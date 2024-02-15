package view;

import domain.RacingCount;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {

    Scanner sc = new Scanner(System.in);

    // TODO : 입력값 검증 및 재입력 기능 추가
    public List<String> inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = sc.nextLine();

        return Collections.unmodifiableList(List.of(input.split(",")));
    }

    public RacingCount inputRacingCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        int input = sc.nextInt();

        return new RacingCount(input);
    }
}
