package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class OutputView {
	
	public void printCarsPosition(Cars cars) {
		cars.getCarList().forEach(this::printCarPosition);
		System.out.println();
	}

	private void printCarPosition(Car car) {
		System.out.print(car.getName() + " : ");
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printWinners(List<Car> carList) {
		List<String> nameList = carList.stream()
			.map(Car::getName)
			.collect(Collectors.toList());
		System.out.println(String.join(", ", nameList) + "가 최종 우승했습니다.");
	}

	public void printProcessPrompt() {
		System.out.println("실행 결과");
	}
}
