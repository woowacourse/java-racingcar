package view;

import dto.CarDto;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public List<CarDto> readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();

        List<CarDto> name = Arrays.stream(names.split(","))
                .map(CarDto::new)
                .collect(Collectors.toList());
        validateListIsNotEmpty(name);

        return name;
    }

    private void validateListIsNotEmpty(final List<CarDto> input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 1개 이상 입력해주세요.");
        }
    }

    public int readTryTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        final String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 정수형 범위여야합니다.");
        }
    }
}
