package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void PrintWinners(List<Car> winners) {
        System.out.println(
                winners.stream()
                        .map(Car::getName)
                        .collect((Collectors.joining(", ", "", "가 최종 우승했습니다.")))
        );
    }
}
