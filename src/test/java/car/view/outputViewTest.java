package car.view;

import car.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class outputViewTest {
    private final OutputView outputView = new OutputView();
    @Test
    @DisplayName("")
    void 자동차를_출력하는_테스트(){
        outputView.printCars(List.of(new Car("포비", 5)));
    }

    @Test
    @DisplayName("우승자를 출력하는 테스트")
    void 우승자를_출력하는_테스트(){
        List<Car> winners = List.of(new Car("포비"), new Car("네오"));
        outputView.printWinners(winners);
    }
}
