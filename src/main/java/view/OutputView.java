package view;

import domain.car.Car;
import domain.name.Name;
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
        raceProgresses.stream().forEach(System.out::println);
    }

    public void printRaceResult(RaceResult raceResult) {
        String racerList = raceResult.getWinnerCars().stream()
                .map(Car::getName)
                .map(Name::getValue)
                .collect(Collectors.joining(", "));

        System.out.println(racerList + "가 최종 우승했습니다.");
    }
}
