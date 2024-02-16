import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RacingGame {
    private static final int MAX_RANDOM_NUMBER_RANGE = 9;
    private static final Pattern NAME_REGEX = Pattern.compile("(.+)((,)(.+))*");
    private static final Pattern TRIAL_REGEX = Pattern.compile("[0-9]+");
    private static final String ERROR_MESSAGE = "[ERROR] 입력 형식이 올바르지 않습니다.";
    public static final String SEPARATOR = ",";

    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        String names = retryInputOnException(this::receiveNames);
        int trialCount = retryInputOnException(this::receiveTrialCount);

        Cars cars = loadCars(names);
        race(trialCount, cars);
        announceWinners(cars);
    }

    private <T> T retryInputOnException(Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE);
            return retryInputOnException(supplier);
        }
    }

    private String receiveNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String names = scanner.nextLine();
        validateCarNames(names);
        return names;
    }

    private void validateCarNames(String names) {
        if (isInvalidFormat(names, NAME_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        if (hasInvalidNameLength(names.split(","))) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean hasInvalidNameLength(String[] names) {
        return Arrays.stream(names)
                .anyMatch(name -> name.isBlank() || name.length() > 5);
    }

    private int receiveTrialCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String trial = scanner.nextLine();

        validateTrialCount(trial);
        return Integer.parseInt(trial);
    }

    private void validateTrialCount(String trialCount) {
        if (isInvalidFormat(trialCount, TRIAL_REGEX)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean isInvalidFormat(String input, Pattern pattern) {
        return !pattern.matcher(input).matches();
    }

    private Cars loadCars(String carNames) {
        List<Car> carList = Arrays.stream(carNames.split(SEPARATOR))
                .map(Car::from)
                .toList();

        return new Cars(carList);
    }

    private void race(int trialCount, Cars cars) {
        printResultPrefix();
        for (int i = 0; i < trialCount; i++) {
            List<Integer> randomNumbers = createRandomNumber(cars.getCount());
            cars.moveAll(randomNumbers);
            printCurrentRace(cars);
        }
    }

    private void printResultPrefix() {
        System.out.println();
        System.out.println("실행 결과");
    }

    protected List<Integer> createRandomNumber(int carCount) {
        return Randoms.getRandomNumbers(carCount, MAX_RANDOM_NUMBER_RANGE);
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
                .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
        System.out.println(winners);
    }
}
