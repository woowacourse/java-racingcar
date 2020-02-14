package controller;

import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameManagerTest {

    GameManager gameManager = new GameManager();

    @DisplayName("입력받은 이름으로 car 객체 생성")
    @Test
    void setCarList() {
        String[] input = new String[]{"k3", "k5"};
        gameManager.setCarList(input);

        List<Car> result = new ArrayList<>();
        result.add(new Car("k3"));
        result.add(new Car("k5"));

        assertThat(result).isEqualTo(gameManager.getCarList());
    }

    @DisplayName("4이상 숫자가 주어지면 전진")
    @Test
    void MoveOrStay() {
        Car car = new Car("car");
        GameManager.moveOrStay(car, 1);
        assertThat(car.getPosition()).isEqualTo(0);

        GameManager.moveOrStay(car, 4);
        assertThat(car.getPosition()).isEqualTo(1);

        GameManager.moveOrStay(car, 4);
        GameManager.moveOrStay(car, 6);
        assertThat(car.getPosition()).isEqualTo(3);
    }
}
