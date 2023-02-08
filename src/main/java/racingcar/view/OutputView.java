package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.carrepository.CarRepository;

import java.util.List;

public class OutputView {

    public void printNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printGameRoundGuide() {
        System.out.println("시도할 회수는 몇회인가요?");
    }


    public void printResultGuide() {
        System.out.println("실행 결과");
    }

    public void printResult(CarRepository carRepository) {
        List<Car> cars = carRepository.getRepository();
        for (Car car : cars) {
            String position = "-".repeat(car.getPosition());
            System.out.println(String.format("%s : %s", car.getName(), position));
        }
        System.out.println();
    }

    public void printWinners(CarRepository carRepository) {
        List<String> winners = carRepository.findWinner();
        String winner = String.join(", ", winners);
        System.out.println(String.format("%s가 최종 우승했습니다.", winner));
    }
}
