import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printTryResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }
    
    public void printWinners(List<Car> cars) {
        int longestDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("생성된 자동차가 없습니다."));

        String winnerNames = String.join(", ",
                cars.stream()
                        .filter(car -> car.getDistance() == longestDistance)
                        .map(Car::getName)
                        .toList()
        );

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printTryCountInputMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
