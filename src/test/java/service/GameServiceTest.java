package service;

import domain.Car;
import domain.repository.CarRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Converter;

import java.util.List;

class GameServiceTest {

    @DisplayName("입력받은 문자열이 잘 쪼개지는지")
    @Test
    void 문자열_분리_확인() {
        String inputNames = "pobi,crong,honux";
        String[] names = Converter.splitInput(inputNames);
        Assertions.assertThat(names[0]).isEqualTo("pobi");
        Assertions.assertThat(names[1]).isEqualTo("crong");
        Assertions.assertThat(names[2]).isEqualTo("honux");
    }


    @DisplayName("자동차 이름을 받으면 자동차 객체가 생성 되어야 한다.")
    @Test
    void 자동차_생성_확인() {
        GameService gameService = new GameService(new CarRepository());
        String[] names = new String[]{"pobi", "crong", "honux"};
        List<Car> cars = gameService.splitNames(names);
        Assertions.assertThat(cars.get(0).getName()).isEqualTo("pobi");
        Assertions.assertThat(cars.get(1).getName()).isEqualTo("crong");
        Assertions.assertThat(cars.get(2).getName()).isEqualTo("honux");
    }
}