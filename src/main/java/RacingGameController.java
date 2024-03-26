import java.util.*;
import java.util.stream.Collectors;

public class RacingGameController {
    private final List<Car> cars = new ArrayList<>();
    private final ConsoleView view = new ConsoleView();
    private final Scanner scanner = new Scanner(System.in);

    public void startGame() {
        view.printRequestCarNames();
        String[] carNames = scanner.nextLine().split(",");
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        view.printRequestTryNumber();
        int tries = scanner.nextInt();

        view.printRaceResult();
        for (int i = 0; i < tries; i++) {
            for (Car car : cars) {
                car.move(new Random().nextInt(10));
                view.printCarPosition(car.getName(), car.getPosition());
            }
            System.out.println();
        }

        String winners = findWinners();
        view.printWinners(winners);
    }

    private String findWinners() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public static void main(String[] args) {
        new RacingGameController().startGame();
    }
}

