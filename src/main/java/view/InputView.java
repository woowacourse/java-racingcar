package view;

import domain.TryCount;
import dto.request.CarNameDto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    public List<CarNameDto> sendCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        Scanner scanner = new Scanner(System.in);
        return Arrays.stream(scanner.next().split(","))
                .map(CarNameDto::new)
                .collect(Collectors.toList());
    }

    public TryCount sendTryCount() {
        System.out.println("시도할 회수는 몇회인가요?");

        Scanner scanner = new Scanner(System.in);
        return new TryCount(scanner.nextInt());
    }
}
