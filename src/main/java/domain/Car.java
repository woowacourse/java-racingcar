package domain;

public class Car {

    private String name;
    private int position = 0;

    public Car(String name) {
        if (Const.MIN_NAME_LEN > name.length() || Const.MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException(Const.EX_NAME_LEN);
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getPosition() {
        return this.position;
    }

    public void increasePositionOrNot(int random) {
        if (Const.GO_RAN_NUM <= random) {
            this.position++;
        }
    }
}
