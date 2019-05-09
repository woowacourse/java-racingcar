package racingcar.model;

import java.util.List;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    /* 테스트를 위한 생성자 */
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
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

    public int getMaxPosition(int maxPosition) {
        return Integer.max(this.position, maxPosition);
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
