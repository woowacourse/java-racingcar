package view;

import domain.Name;
import domain.TryCount;
import dto.request.CarNameDto;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<Name> sendCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.nextLine().split(","))
                .map(Name::new)
                .collect(Collectors.toList());
    }

    public TryCount sendTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return getTryCount(new Scanner(System.in));
    }

    private TryCount getTryCount(Scanner scanner) {
        try {
            return new TryCount(scanner.nextInt());
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException("정수를 입력해주세요.");
        }
    }
}
