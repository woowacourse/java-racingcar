import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGame {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int MAX_RANDOM_NUMBER_RANGE = 9;

    public void run() {
        String names = receiveNames();
        int trialCount = receiveTrialCount();
        Cars cars = loadCars(names);
        System.out.println("실행 결과");
        race(trialCount, cars);
        announceWinners(cars);
    }

    private String receiveNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        validateCarNames(names);
        return names;
    }

    private void validateCarNames(String names) {
        final String NAMES_REGEX = "((.{1,5}))(,(.{1,5}))*";
    }

    private int receiveTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String trial = scanner.nextLine();
        int trialCount = Integer.parseInt(trial);
        System.out.println();
        return trialCount;
    }

    private Cars loadCars(String carNames) {
        return new Cars(Arrays.stream(carNames.split(","))
                .map(Car::fromName)
                .toList()
        );
    }

    private void race(int trialCount, Cars cars) {
        for (int i = 0; i < trialCount; i++) {
            List<Integer> randomNumbers = Randoms.getRandomNumbers(cars.getSize(), MAX_RANDOM_NUMBER_RANGE);
            cars.moveAll(randomNumbers);
            printCurrentRace(cars);

        }
    }

    private void printCurrentRace(Cars cars) {
        cars.getCarList().forEach(car -> {
            System.out.printf("%s : %s\n", car.getCarName(), "-".repeat(car.getCarLocation()));
        });
        System.out.println();
    }

    private void announceWinners(Cars cars) {
        String winners = cars.getCarList().stream()
                .filter(car -> car.getCarLocation() == cars.getMaxLocation())
                .map(Car::getCarName)
                .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";;
        System.out.println(winners);
    }


}
