package racingcar.domain;

public class Car {
    public static final String NAME_MUSTBE_1TO5 = "이름은 1자 이상 5자 이하여야 합니다.";
    public static final String RANDOM_OUTOF_BOUND = "범위를 초과한 난수입니다.";
    private final String name;
    private int position = 0;

    public Car(String name) {
        if (name == null || name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException(NAME_MUSTBE_1TO5);
        }
        this.name = name;
    }

    public boolean checkMove(int i) {
        if (i < 0 || i >= 10) {
            throw new NumberFormatException(RANDOM_OUTOF_BOUND);
        }
        if (i >= 4 && i <= 9) {
            proceed();
            return true;
        }
        return false;
    }

    private void proceed() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
