import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {

    private final Scanner scanner = new Scanner(System.in);

    public List<Car> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userInput = scanner.nextLine();
        String[] carNames = userInput.split(",");

        return getCars(carNames);
    }

    private List<Car> getCars(String[] carNames) {
        try {
            List<Car> cars = new ArrayList<>();
            for (String carName : carNames) {
                cars.add(new Car(carName));
            }
            return cars;
        } catch (IllegalArgumentException e) {
            System.out.println("다시 입력해주세요.");
            return readCars();
        }
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
}
