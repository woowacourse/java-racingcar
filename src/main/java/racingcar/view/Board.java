package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Name;

public class Board {

    public void announceRacingStart() {
        System.out.println("실행 결과");
    }

    public void recordCurrentScore(List<Car> participants) {
        for (Car participant : participants) {
            System.out.println(participant.getName() + " : " + "-".repeat(participant.getLocation()));
        }
        System.out.println();
    }

    public void recordRacingWinners(List<Name> winners) {
        System.out.println(winners.stream()
            .map(Name::toString)
            .collect(Collectors.joining(",")) + "(이)가 최종 우승하였습니다.");
    }
}
