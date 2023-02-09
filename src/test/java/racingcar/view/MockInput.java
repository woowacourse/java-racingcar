package racingcar.view;

public class MockInput implements Input {

    @Override
    public int gameCountInput() {
        return 3;
    }

    @Override
    public String carNameInput() {
        return "judy,nunu,pobi";
    }
}
