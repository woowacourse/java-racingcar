package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class OutputView {
	
	public void printCarsPosition(Cars cars) {
		System.out.println("실행 결과");
		cars.getCarList().forEach(car -> {
			printCarPosition(car);
		});
	}

	private void printCarPosition(Car car) {
		System.out.print(car.getName() + ":");
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print("-");
		}
		System.out.println();
	}

	public void printWinners(Cars cars) {
		System.out.println(String.join(", ", cars.getWinners()) + "가 최종 우승했습니다.");
	}
}
