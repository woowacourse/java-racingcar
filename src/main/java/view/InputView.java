package view;

import domain.TryCount;
import dto.request.CarNameDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static domain.Car.BLANK;
import static domain.Car.MAX_NAME_LENGTH;
import static domain.TryCount.MIN_TRY_COUNT;
import static domain.TryCount.TRY_COUNT_LIMIT;

public class InputView {

    private final String DELIMITER = ",";
    private final String DELIMITER_IN_KOREAN = "쉼표";

    public List<CarNameDto> sendCarsName() {
        System.out.printf("경주할 자동차 이름을 입력하세요(이름은 %s(%s)를 기준으로 구분).\n", DELIMITER_IN_KOREAN, DELIMITER);

        Scanner scanner = new Scanner(System.in);
        String[] carsName = scanner.nextLine().split(DELIMITER);

        for (String carName : carsName) {
            validate(carName);
        }

        return Arrays.stream(carsName)
                .map(CarNameDto::new)
                .collect(Collectors.toList());
    }

    public TryCount sendTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        Scanner scanner = new Scanner(System.in);
        int tryCount = scanner.nextInt();
        validateTryCount(tryCount);
        return new TryCount(tryCount);
    }

    private void validate(String name) {
        validateLength(name);
        validateToContainBlank(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LENGTH + "자 이하여야 합니다. " +
                    "입력값 : " + name);
        }
    }

    private void validateToContainBlank(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("이름에 공백을 포함할 수 없습니다." +
                    "입력값 : " + name);
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount < MIN_TRY_COUNT) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다." +
                    "입력값 : " + tryCount);
        }
        if (tryCount > TRY_COUNT_LIMIT) {
            throw new IllegalArgumentException("시도할 회수는 " + TRY_COUNT_LIMIT +"회 이하여야 합니다." +
                    "입력값 : " + tryCount);
        }
    }
}
