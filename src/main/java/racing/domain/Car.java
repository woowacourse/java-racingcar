package racing.domain;

import static racing.view.output.OutputView.HYPHEN;

public class Car {

    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    public void increaseStep() {
        this.step++;
    }

    public void addHyphen() {
        System.out.print(HYPHEN.repeat(step));
    }
}
