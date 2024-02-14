package domain.input;

import domain.RacingCount;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class InputView {

    Scanner sc = new Scanner(System.in);

    // TODO : 입력값 검증 및 재입력 기능 추가
    public List<String> inputCars() {
        String input = sc.nextLine();

        return Collections.unmodifiableList(List.of(input.split(",")));
    }

    public RacingCount inputRacingCount() {
        int input = sc.nextInt();

        return new RacingCount(input);
    }
}
