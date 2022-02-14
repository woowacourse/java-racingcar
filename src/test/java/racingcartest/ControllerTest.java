package racingcartest;

import org.junit.jupiter.api.Test;
import racingcar.controller.GameController;
import racingcar.controller.OutputViewController;
import racingcar.model.Car;
import racingcar.util.StringConst;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ControllerTest {

    @Test
    public void controllerCarCountTest() {
        String[] names = {"pobi", "jun", "jason"};
        GameController gameController = new GameController();
        ArrayList<Car> carList = gameController.generateCarList(names);
        assertThat(carList.size()).isEqualTo(names.length);
    }

    @Test
    public void controllerMaxPosition() {
        String[] names = {"pobi", "jun", "jason"};
        GameController gameController = new GameController();
        ArrayList<Car> carList = gameController.generateCarList(names);
        carList.get(0).movePosition(5);
        carList.get(0).movePosition(6);
        carList.get(1).movePosition(4);
        int maxPosition = gameController.getMaxPosition(carList);
        assertThat(maxPosition).isEqualTo(2);
    }

    @Test
    public void controllerHashMapTest() {
        LinkedHashMap<String, String> testInfo = new LinkedHashMap<>();
        testInfo.put("pobi", "--");
        testInfo.put("jun", "-");
        testInfo.put("jason", "");
        String[] names = {"pobi", "jun", "jason"};
        GameController gameController = new GameController();
        OutputViewController outputViewController = new OutputViewController();
        ArrayList<Car> carList = gameController.generateCarList(names);
        carList.get(0).movePosition(5);
        carList.get(0).movePosition(6);
        carList.get(1).movePosition(4);
        LinkedHashMap<String, String> realInfo = outputViewController.getCarListInfo(carList, StringConst.POSITION_DELEIMIER.getValue());
        assertThat(realInfo.entrySet()).isEqualTo(testInfo.entrySet());
    }

    @Test
    public void controllerDuplicateTest() {
        String[] names = {"pobi", "jun", "jason"};
        GameController gameController = new GameController();
        ArrayList<Car> carList = gameController.generateCarList(names);
        carList.get(0).movePosition(5);
        carList.get(1).movePosition(4);
        OutputViewController outputViewController = new OutputViewController();
        ArrayList<String> winner = outputViewController.mapWinner(carList);
        assertThat(String.join(StringConst.WINNER_DELIMITER.getValue(), winner)).isEqualTo("pobi, jun");
    }
}
