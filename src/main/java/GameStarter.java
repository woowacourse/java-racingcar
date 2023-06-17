import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//어플리케이션을 시작 및 제어하는 main 클래스
public class GameStarter {
    private final InputView inputView = new InputView();
    private final Filter filter = new Filter();
    private final CarFactory carFactory = new CarFactory();
    public static List<Car> carList = new ArrayList<>();
    private int carNum;
    private int tryCount;

    //어플리케이션 시작
    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter();
        gameStarter.run();
    }

    //어플리케이션 흐름 제어
    private void run() {
        initGameProperty();
    }

    private void initGameProperty() {
        checkInput(inputView, filter);
        carFactory.makeCar(carNum);
    }

    private void startGame() {
        carList.forEach(car -> car.setRandomNumber(carFactory.insertRandomNumber()));
        carList.stream()
                .filter(car -> filter.CheckRandomNumber(car.getRandomNumber()))
                .collect(Collectors.toList())
                .forEach(Car::forward);
    }

    private void checkInput(InputView inputView, Filter filter) {
        do {
            carNum = inputView.getCarNumber();
            tryCount = inputView.getTryCount();
        } while (!filter.CheckInputValidate(carNum) || !filter.CheckInputValidate(tryCount));
    }
}
