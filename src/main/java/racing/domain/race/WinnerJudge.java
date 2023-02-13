package racing.domain.race;

import java.util.List;
import racing.domain.car.Car;

public interface WinnerJudge {
    List<Car> getWinner(List<Car> cars);
}
