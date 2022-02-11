package racingcartest;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.controller.GameController;
import racingcar.controller.OutputViewController;
import racingcar.model.Car;
import racingcar.util.Checker;
import racingcar.util.StringConst;

public class MainTest {
	Checker checker = new Checker();

	@DisplayName("자동차 이름 입력 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"", "abc,abc", "!@#,abc", "asdkqop,qwe", ",,,,"})
	public void nameExceptNullTest(String input) {
		assertThat(checker.checkNameConditions(input)).contains("[ERROR]");
	}

	@DisplayName("자동차 이름 입력 NULL 예외 테스트")
	@Test
	public void nameNullTest() {
		assertThat(checker.checkNameConditions(null)).contains("[ERROR]");
	}

	@DisplayName("레이싱 횟수 입력 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"", "ab", "-100"})
	public void turnTest(String input) {
		assertThat(checker.checkTurnConditions(input)).contains("[ERROR]");
	}

	@DisplayName("레이싱 횟수 입력 NULL 예외 테스트")
	@Test
	public void turnNullTest() {
		assertThat(checker.checkTurnConditions(null)).contains("[ERROR]");
	}

	@DisplayName("4 이상일 때 자동차 이동하는지 테스트")
	@Test
	public void carMoveTest() {
		Car car = new Car("pobi");
		car.movePosition(5);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@DisplayName("자동차 위치와 특정 위치 일치 테스트")
	@Test
	public void carPositionEqualTest() {
		Car car = new Car("pobi");
		car.movePosition(5);
		car.movePosition(6);
		assertThat(car.isMaxPosition(2)).isEqualTo(true);
	}

	@DisplayName("입력된 이름과 생성된 차의 개수 일치 테스트")
	@Test
	public void controllerCarCountTest() {
		String[] names = {"pobi", "jun", "jason"};
		GameController gameController = new GameController();
		ArrayList<Car> carList = gameController.generateCarList(names);
		assertThat(carList.size()).isEqualTo(names.length);
	}

	@DisplayName("자동차들의 가장 먼 위치 테스트")
	@Test
	public void controllerMaxPosition() {
		String[] names = {"pobi", "jun", "jason"};
		GameController gameController = new GameController();
		ArrayList<Car> carList = gameController.generateCarList(names);
		carList.get(0).movePosition(5);
		carList.get(0).movePosition(6);
		carList.get(1).movePosition(4);
		int maxPosition = gameController.getMaxPosition(carList);
		assertThat(maxPosition).isEqualTo(2);
	}

	@DisplayName("자동차 정보의 이름, 위치 일치 테스트")
	@Test
	public void controllerHashMapTest() {
		LinkedHashMap<String, String> testInfo = new LinkedHashMap<>();
		testInfo.put("pobi", "--");
		testInfo.put("jun", "-");
		testInfo.put("jason", "");
		String[] names = {"pobi", "jun", "jason"};
		GameController gameController = new GameController();
		OutputViewController outputViewController = new OutputViewController();
		ArrayList<Car> carList = gameController.generateCarList(names);
		carList.get(0).movePosition(5);
		carList.get(0).movePosition(6);
		carList.get(1).movePosition(4);
		LinkedHashMap<String, String> realInfo = outputViewController.getCarListInfo(carList);
		assertThat(realInfo.entrySet()).isEqualTo(testInfo.entrySet());
	}

	@DisplayName("우승자가 두 명일 경우 포맷 일치 테스트")
	@Test
	public void controllerDuplicateTest() {
		String[] names = {"pobi", "jun", "jason"};
		GameController gameController = new GameController();
		ArrayList<Car> carList = gameController.generateCarList(names);
		carList.get(0).movePosition(5);
		carList.get(1).movePosition(4);
		OutputViewController outputViewController = new OutputViewController();
		ArrayList<String> winner = outputViewController.mapWinner(carList);
		assertThat(String.join(StringConst.WINNER_DELIMITER.getValue(), winner)).isEqualTo("pobi, jun");
	}
}
