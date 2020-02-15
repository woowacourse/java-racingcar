package racingcar.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * 클래스 이름 : .java
 *
 * @author
 * @version 1.0
 * <p>
 * 날짜 : 2020/02/15
 */
public class PositionTest {
	@Test
	@DisplayName("Position 생성자 정상 케이스 테스트")
	void Position_생성자_테스트() {
		//given
		int inputPosition = 3;
		//when
		Position position = new Position(inputPosition);
		//then
		assertThat(position).isInstanceOf(Position.class);
	}

	@Test
	@DisplayName("Position 생성자 비정상 케이스 테스트 : null 입력")
	void Position_생성자_null일시_예외처리() {
		//given
		Integer inputPosition = null;
		//when then
		assertThatNullPointerException().isThrownBy(() -> new Position(inputPosition));
	}

	@ParameterizedTest
	@DisplayName("Position 생성자 비정상 케이스 테스트 : 양수 이외의 수 입력")
	@ValueSource(ints = {-1, 0})
	void Position_생성자_양수가_아닐시_예외처리(Integer inputPosition) {
		assertThatThrownBy(() -> {
			Position position = new Position(inputPosition);
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("양수만 입력해야합니다.");
	}

	@Test
	@DisplayName("moveForward 정상 케이스 테스트 : 하나 앞으로")
	void moveForward_실행시_position에_더하기_일() {
		//given
		Position position = new Position();
		//when
		position.moveForward();
		//then
		assertThat(position).isEqualTo(new Position(2));
	}
}
