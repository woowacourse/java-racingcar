package view;

import domain.car.Car;
import domain.car.Cars;
import domain.race.RaceProgress;
import domain.race.RaceResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private void newLine() {
        System.out.println();
    }

    public void printRaceProgresses(List<RaceProgress> raceProgresses) {
        newLine();
        System.out.println("실행 결과");
        raceProgresses.stream()
                      .forEach(System.out::println);
    }

    public void printRaceResult(Cars cars) {
        String racerList = cars.getMaxPositionCars()
                               .stream()
                               .map(Car::toString)
                               .collect(Collectors.joining(", "));

        System.out.println(racerList + "가 최종 우승했습니다.");
    }
}
