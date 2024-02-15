package domain;


import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceTest {
    Service service = new Service();

    @DisplayName("쉼표 기준으로 자동차 이름을 분리한다")
    @Test
    void splitTest() {
        List<String> carName = service.separateCarName("릴리,애쉬,엘라");
        Assertions.assertThat(carName).isEqualTo(List.of("릴리", "애쉬", "엘라"));
    }

    @DisplayName("자동차 객체 리스트가 올바르게 생성된다")
    @Test
    void setCarTest() {
        List<String> carName = List.of("ash", "lily", "ella");
        List<Car> cars = service.setCars(carName);
        System.out.println(cars.get(0).getCarName());
        Assertions.assertThat(cars.get(0).getCarName()).isEqualTo("ash");
        Assertions.assertThat(cars.get(0).getLocation()).isEqualTo(0);
    }

