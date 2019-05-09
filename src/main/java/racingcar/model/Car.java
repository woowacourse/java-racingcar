package racingcar.model;

import java.util.List;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean isEnableGo) {
        if (isEnableGo) {
            position++;
        }
    }

    public void addWinners(List<String> winnerList, int maxPosition) {
        if (this.getPosition() == maxPosition) {
            winnerList.add(this.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(" : ");
        for (int i = 0; i < this.position; i++) {
            sb.append("-");
        }
        return sb.toString();
    }
}
