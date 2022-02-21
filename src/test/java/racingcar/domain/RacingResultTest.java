package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import racingcar.service.dto.CarDto;

public class RacingResultTest {

	RacingResult racingResult;

	@BeforeEach
	public void init() {
		racingResult = new RacingResult();
		racingResult.add(List.of(Car.of("라라"), Car.of("포비", 1), Car.of("더즈")));
		racingResult.add(List.of(Car.of("라라", 1), Car.of("포비", 2), Car.of("더즈", 1)));

	}
	@Test
	@DisplayName("게임 결과 조회 성공")
	public void findResultTest() {
		List<CarDto> resultCars = racingResult.findResult(Round.of(2)).stream()
			.map(CarDto::of)
			.collect(Collectors.toList());

		Assertions.assertThat(resultCars.get(1).getName()).isEqualTo("포비");
		Assertions.assertThat(resultCars.get(1).getPosition()).isEqualTo(2);
	}

	@Test
	@DisplayName("게임 결과 실패 - 존재하지 않는 ROUND")
	public void findResultErrorTest() {
		Assertions.assertThatThrownBy(() -> {
				racingResult.findResult(Round.of(3));
			}).isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("해당 라운드 결과가 존재하지 않습니다.");
	}
}
