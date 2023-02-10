package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class GameRoundTest {

	@DisplayName("게임 라운드 생성 테스트")
	@ParameterizedTest(name = "totalRound = {0}")
	@ValueSource(ints = {1, 2, 3, 4, 5})
	void createGameRoundTest(int totalRound) {
		GameRound gameRound = new GameRound(totalRound);
		assertThat(gameRound).isNotNull();
	}

	@DisplayName("게임 라운드 종료 확인 테스트")
	@ParameterizedTest(name = "totalRound = {0}, executeTime = {1}, expectedIsEnd = {2}")
	@CsvSource(value = {"1:1:true", "2:2:true", "10:1:false"}, delimiterString = ":")
	void isEndRoundTest(int totalRound, int executeTimes, boolean expectedIsEnd) {
		GameRound gameRound = new GameRound(totalRound);
		for (int count = 0; count < executeTimes; count++) {
			gameRound.increaseRound();
		}
		assertThat(gameRound.isEnd()).isEqualTo(expectedIsEnd);
	}

}
