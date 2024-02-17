package racinggame.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {


    @DisplayName("생성시 에러가 발생하지 않는다.")
    @Test
    public void create() throws Exception {
        Assertions.assertThatCode(() -> Cars.of(List.of("아톰", "이상")))
                .doesNotThrowAnyException();
    }

    @DisplayName("2대 미만의 자동차로 생성시 에러가 발생한다.")
    @Test
    public void createCarSizeException() throws Exception {
        Assertions.assertThatCode(() -> Cars.of(List.of("아톰")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 자동차 이름으로 생성시 에러가 발생한다.")
    @Test
    public void createCarDuplicatedException() throws Exception {
        Assertions.assertThatCode(() -> Cars.of(List.of("이상", "이상")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("모든 자동차를 움직일 수 있다.")
    @Test
    void moveAll() {
        Cars cars = Cars.of(List.of("아톰", "이상"));
        Assertions.assertThatCode(() -> cars.moveAll(() -> true))
                .doesNotThrowAnyException();

        Assertions.assertThat(cars.getCars()).isEqualTo(List.of(Car.of("아톰", 1), Car.of("이상", 1)));
    }

    @DisplayName("라운드의 결과를 반환한다.")
    @Test
    public void buildRoundResult() throws Exception {
        Cars cars = Cars.of(List.of("아톰", "이상"));
        RoundResult roundResult = cars.buildRoundResult();
        List<CarInfo> carInfos = roundResult.carInfos();

        Assertions.assertThat(carInfos).isEqualTo(List.of(new CarInfo("아톰", 0), new CarInfo("이상", 0)));
    }

    @DisplayName("최종 승자의 이름들을 반환한다.")
    @Test
    public void findWinnerName() throws Exception {
        Cars cars = Cars.of(List.of("아톰", "이상"));
        List<String> winnerName = cars.findWinnerName();

        Assertions.assertThat(winnerName).isEqualTo(List.of("아톰", "이상"));
    }
}
