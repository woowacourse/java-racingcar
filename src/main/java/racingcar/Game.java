package racingcar;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    private InputView inputView;
    private int roundNumber;
    private List<Car> cars = new ArrayList<>();
    public static final String NOT_FOUND_CARS = "[ERROR] 자동차를 찾을 수 없습니다.";
    private static final int randomRange = 10;
    private static final int pivotNumber = 4;

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void playGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < roundNumber; i++) {
            playRound();
        }
    }

    public void playRound() {

        Random random = new Random();

        for (Car car : cars) {
            car.moveOrHold(random.nextInt(randomRange) < pivotNumber);
        }

        cars.stream().forEach(car -> car.printPosition());
        System.out.println();
    }

    public void setGame() {
        setCars();
        setRoundNumbers();

        // 체크 로직 !
        cars.forEach(System.out::println);
        System.out.println(roundNumber);

    }

    private void setCars() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> carNames = Arrays.asList(StringParser.readCarNameInputs(inputView.readCarNamesInput()));
        carNames.forEach(x -> cars.add(new Car(x)));
    }

    private void setRoundNumbers() {
        System.out.println("시도할 회수는 몇회인가요?");
        roundNumber = inputView.readRoundNumberInput();
    }

    public void play() {
        setGame();
        playGame();
        inputView.terminate();
    }

}
