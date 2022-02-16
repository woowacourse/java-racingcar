package racingcar.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DisplayName("Cars 클래스를 테스트한다.")
public class CarsTest {

    Cars cars;

    @BeforeEach
    public void init() {
        List<Car> carDatas = new ArrayList<>();
        carDatas.add(createCarData("렉스", 3));
        carDatas.add(createCarData("미르", 3));
        carDatas.add(createCarData("스컬", 2));

        cars = new Cars(carDatas);
    }

    public Car createCarData(String name, int posiiton) {
        Car carData = new Car(name);
        for (int i = 0; i < posiiton; i++) {
            carData.goForward(5);
        }
        return carData;
    }

    @Test
    @DisplayName("우승자를 옳바르게 찾는지 테스트한다")
    public void findWinner() {
        String winners = cars.findWinners();

        assertThat(winners).isEqualTo("렉스, 미르");
    }

    @Test
    @DisplayName("현재 턴의 결과를 옳바르게 반환하는지 테스트한다.")
    public void turnResult() {
        List<String> result = cars.turnResult();

        List<String> expected = new ArrayList<>();
        expected.add("렉스 : ---");
        expected.add("미르 : ---");
        expected.add("스컬 : --");

        assertThat(result).isEqualTo(expected);
    }



}
