package view;

import domain.car.Car;
import domain.car.Cars;
import domain.name.Name;
import domain.race.RaceCarInfo;
import domain.race.RaceProgress;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private void newLine() {
        System.out.println();
    }

    public void printAllRaceProgress(List<RaceProgress> raceProgresses) {
        newLine();
        System.out.println("실행 결과");
        raceProgresses.forEach(this::printSingleRaceProgress);
    }


    private void printSingleRaceProgress(RaceProgress raceProgress) {
        raceProgress.getRaceCarInfo()
                    .stream()
                    .forEach(this::printRaceCarInfo);
        newLine();
    }

    private void printRaceCarInfo(RaceCarInfo raceCarInfo) {
        System.out.println(formatRaceCarInfo(raceCarInfo));
    }

    private String formatRaceCarInfo(RaceCarInfo raceCarInfo) {
        return new StringBuilder()
                .append(raceCarInfo.getName()
                                   .getValue())
                .append(" : ")
                .append("-".repeat(raceCarInfo.getPosition()))
                .toString();
    }
    public void printRaceResult(Cars cars) {
        String racerList = cars.getMaxPositionCars()
                               .stream()
                               .map(Car::getName)
                               .map(Name::getValue)
                               .collect(Collectors.joining(", "));

        System.out.println(racerList + "가 최종 우승했습니다.");
    }
}
