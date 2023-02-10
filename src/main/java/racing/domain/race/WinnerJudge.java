package racing.domain.race;

import racing.domain.car.Car;
import java.util.List;

public interface WinnerJudge {
    List<Car> getWinner(List<Car> cars);
}
