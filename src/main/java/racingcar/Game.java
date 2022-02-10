package racingcar;

import java.util.*;

public class Game {
    private InputView inputView;
    private int roundNumber;
    private List<Car> cars = new ArrayList<>();

    public Game(InputView inputView) {
        this.inputView = inputView;
    }

    public void playGame() {
        for (int i = 0; i < roundNumber; i++) {
            playRound();
        }
    }

    public void playRound() {
        Random random = new Random();
        for (Car car : cars) {
            car.moveOrHold(random.nextInt(10) < 4);
        }
    }

    public void setGame() {
        List<String> carNames = Arrays.asList(StringParser.readCarNameInputs(inputView.readCarNamesInput()));
        carNames.forEach(x -> cars.add(new Car(x)));

        roundNumber = inputView.readRoundNumberInput();

        cars.forEach(System.out::println);
        System.out.println(roundNumber);
    }

    public void play() {
        setGame();
        playGame();
        showResult();
    }
    public void showResult(){
        List<Car> winners = decideWinner();
    }
    public List<Car> decideWinner(){
        cars.stream().mapToInt(x->x.getPosition()).max();
        Comparator<Car> comparatorByAge = Comparator.comparingInt(Car::getPosition);

        Car carWithMaxPosition = cars.stream()
                .max(comparatorByAge)
                .get();
    }
}
