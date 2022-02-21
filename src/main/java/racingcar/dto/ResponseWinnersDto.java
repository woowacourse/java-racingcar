package racingcar.dto;

import java.util.List;
import racingcar.domain.vo.Car;

public class ResponseWinnersDto {

    private List<Car> winners;

    public ResponseWinnersDto(List<Car> winners) {
        this.winners = winners;
    }

    public List<Car> getWinners() {
        return winners;
    }
}
