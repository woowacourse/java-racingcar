package view;

import domain.car.Car;
import domain.name.Name;
import domain.race.RaceCarInfo;
import domain.race.RaceProgress;
import domain.race.RaceResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private void newLine() {
        System.out.println();
    }
    public void printResultMessage(){
        newLine();
        System.out.println("실행 결과");
    }

    public void printRaceProgressPerRound(List<RaceCarInfo> result) {
        for(RaceCarInfo raceCarInfo: result){
            String name = raceCarInfo.getName().getValue();
            int position=raceCarInfo.getPosition();
            System.out.println(name+" : " + "-".repeat(position));
        }
        newLine();
    }

    public void printRaceResult(RaceResult raceResult) {
        String racerList = raceResult.getWinnerCars().stream()
                .map(Car::getName)
                .map(Name::getValue)
                .collect(Collectors.joining(", "));

        System.out.print(racerList + "가 최종 우승했습니다.");
    }
}
