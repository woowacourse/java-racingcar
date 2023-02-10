package racingcar.dto;

import static java.util.stream.Collectors.*;

import java.util.List;
import racingcar.domain.Car;

public class RacingCarWinnerResponse {
    private final List<String> winners;

    public RacingCarWinnerResponse(List<String> winners) {
        this.winners = winners;
    }

    public static RacingCarWinnerResponse of(List<Car> winners) {
        List<String> names = winners.stream()
                .map(Car::getStatus)
                .map(RacingCarStatusResponse::getName)
                .collect(toList());
        return new RacingCarWinnerResponse(names);
    }

    public List<String> getWinners() {
        return winners;
    }

    /**
     * 우승자의 목록을 문자열 형식으로 반환한다.
     * Glen, Bero와 같은 형식으로 반환한다.
     * 만약, 우승자가 한 명이면 뒤에 쉼표를 붙이지 않는다.
     */
    @Override
    public String toString() {
        return String.join(", ", winners);
    }
}
