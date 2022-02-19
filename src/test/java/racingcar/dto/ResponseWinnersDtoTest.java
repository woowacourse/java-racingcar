package racingcar.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.Car;
import racingcar.domain.vo.CarName;

public class ResponseWinnersDtoTest {

    @DisplayName("ResponseWinnersDto 테스트")
    @Test
    public void ResponseWinnersDto_test() throws Exception {
        ResponseWinnersDto dto = new ResponseWinnersDto(new ArrayList<>());

        assertThat(dto).isNotNull();
        assertThat(dto).isOfAnyClassIn(ResponseWinnersDto.class);
    }

    @DisplayName("getWinners() 테스트")
    @Test
    public void getWinners_test() throws Exception {
        List<Car> winners = new ArrayList<>();
        Car car = new Car(new CarName("name"));
        winners.add(car);
        ResponseWinnersDto dto = new ResponseWinnersDto(winners);
        List<Car> results = dto.getWinners();

        assertThat(results).hasSize(1);
        assertThat(results.get(0)).isEqualTo(car);
    }
}
