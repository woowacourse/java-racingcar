package racingcartest;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.controller.GameController;
import racingcar.controller.OutputViewController;
import racingcar.model.Car;
import racingcar.util.Checker;

public class MainTest {
	Checker checker = new Checker();

	@ParameterizedTest
	@ValueSource(strings = {"", "abc,abc", "!@#,abc", "asdkqop,qwe", ",,,,"})
	public void nameExceptNullTest(String input) {
		assertThat(checker.checkNameConditions(input)).contains("[ERROR]");
	}

	@Test
	public void nameNullTest() {
		assertThat(checker.checkNameConditions(null)).contains("[ERROR]");
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "ab", "-100"})
	public void turnTest(String input) {
		assertThat(checker.checkTurnConditions(input)).contains("[ERROR]");
	}

	@Test
	public void turnNullTest() {
		assertThat(checker.checkTurnConditions(null)).contains("[ERROR]");
	}

	@Test
	public void carMoveTest() {
		Car car = new Car("pobi");
		car.movePosition(5);
		assertThat(car.getPosition()).isEqualTo(1);
	}

	@Test
	public void carPositionEqualTest() {
		Car car = new Car("pobi");
		car.movePosition(5);
		car.movePosition(6);
		assertThat(car.isMaxPosition(2)).isEqualTo(true);
	}

	@Test
	public void controllerCarCountTest() {
		String[] names = {"pobi", "jun", "jason"};
		GameController gameController = new GameController();
		ArrayList<Car> carList = gameController.generateCarList(names);
		assertThat(carList.size()).isEqualTo(names.length);
	}

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
}
