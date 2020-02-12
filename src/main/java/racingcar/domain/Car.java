package racingcar.domain;

public class Car {
    public static final String POSITION_MARK = "-";

    private String name;
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

    public int movePosition(int moveValue) {
        if (moveValue >= 4) {
            this.position++;
        }
        return this.position;
    }

    public String currntPositon() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0 ; i < this.position ; i++) {
            stringBuilder.append(POSITION_MARK);
        }
        return this.name +  " : " + stringBuilder;
    }

}
