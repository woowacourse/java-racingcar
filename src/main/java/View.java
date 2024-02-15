import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    public List<Car> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = readCarNames();
        return getCars(carNames);
    }

    private String[] readCarNames() {
        String userInput = scanner.nextLine();
        return userInput.split(",");
    }

    private List<Car> getCars(String[] carNames) {
        try {
            Validator.validateParticipant(carNames);
            return makeCars(carNames);
        } catch (IllegalArgumentException e) {
            System.out.println("다시 입력해주세요.");
            return readCars();
        }
    }

    private static List<Car> makeCars(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public int readCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        try {
            String count = scanner.nextLine();
            return Validator.validateCount(count);
        } catch (Exception e) {
            System.out.println("다시 입력해주세요.");
            return readCount();
        }
    }

    public void printRace(String moveResult) {
        System.out.println("\n" + "실행 결과");
        System.out.print(moveResult);
    }

    public void printWinners(String winners) {
        System.out.println(winners);
    }
}
