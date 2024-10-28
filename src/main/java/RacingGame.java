import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int attempts;

    public RacingGame(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            playRound();
            printRoundResult();
        }
        printWinners();
    }

    private void playRound() {
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
        }
    }

    private void printRoundResult() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }

    private void printWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
