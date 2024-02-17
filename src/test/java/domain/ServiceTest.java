package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ServiceTest {
    final Service service = new Service();

    @BeforeEach
    @Test
    void setCars(){
        service.getCars().clear();
    }

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

        Assertions.assertThat(cars.get(0).getCarName()).isEqualTo("ash");
        Assertions.assertThat(cars.get(0).getLocation()).isEqualTo(0);
    }

    @DisplayName("입력된 자동차 이름이 한 개라면 예외가 발생한다")
    @Test
    void amountTest() {
        Assertions.assertThatThrownBy(() -> service.setCars(List.of("Ash")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("두 대 이상");
    }

    @DisplayName("입력된 자동차 이름 중에 중복되는 이름이 존재하면 예외가 발생한다")
    @Test
    void duplicationTest() {
        Assertions.assertThatThrownBy(() -> service.setCars(List.of("Ash", "Ash", "Lily")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복");
    }

    @DisplayName("입력한 시도 횟수만큼 경주를 진행한다")
    @Test
    void playGameTest() {
        service.setCars(List.of("ash", "lily"));

        Assertions.assertThatCode(() -> service.playGame(3))
                .doesNotThrowAnyException();
    }

    @DisplayName("최종 우승자를 올바르게 결정한다")
    @Test
    void getWinnerNameTest() {
        service.setCars(List.of("ash", "lily"));
        List<Car> cars = service.getCars();
        cars.get(0).incLocation();

        Assertions.assertThat(service.getWinnerName()).isEqualTo(List.of("ash"));
    }
}
