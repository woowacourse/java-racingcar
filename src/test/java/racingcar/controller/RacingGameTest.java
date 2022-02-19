package racingcar.controller;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.internal.util.reflection.ReflectionMemberAccessor;

import racingcar.models.CarRepository;

@DisplayName("RacingGame 클래스")
class RacingGameTest {

	@Test
	@DisplayName("게임이 정상적으로 실행되는지 확인한다")
	void runGame() {
		final RacingGame racingGame = mock(RacingGame.class);
		when(racingGame.isEnd()).thenReturn(false)
			.thenReturn(false)
			.thenReturn(true);

		while(!racingGame.isEnd()) {
			racingGame.race();
			racingGame.endThisTurn();
		}

		verify(racingGame, times(2)).race();
	}
}