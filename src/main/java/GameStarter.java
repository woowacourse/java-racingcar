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
        startGame(tryCount);
    }

    private void initGameProperty() {
        checkInput(inputView, filter);
        carFactory.makeCar(carNum);
    }

    private void startGame(int tryCount) {
        ResultView resultView = new ResultView();
        for (int i = 0; i < tryCount; i++) {
            carList.forEach(car -> car.setRandomNumber(carFactory.insertRandomNumber()));
            carList.stream()
                    .filter(car -> filter.CheckRandomNumber(car.getRandomNumber()))
                    .collect(Collectors.toList())
                    .forEach(Car::forward);

            showResult(carList, resultView);
        }
    }

    private void showResult(List<Car> carList, ResultView resultView) {
        carList.forEach(resultView::showCarLocation);
        System.out.println();
    }

    private void checkInput(InputView inputView, Filter filter) {
        do {
            carNum = inputView.getCarNumber();
            tryCount = inputView.getTryCount();
        } while (!filter.CheckInputValidate(carNum) || !filter.CheckInputValidate(tryCount));
    }
}
