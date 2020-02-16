package racing.model;

public class Car {

    public static final int MAX_NAME_SIZE = 5;
    private final String name;
    private Position position;

    public Car(String name) {
        name = name.trim();
        checkNameLengthUnderSix(name);
        checkNullOrEmptyName(name);
        this.name = name;
        position = new Position();
    }


    private void checkNullOrEmptyName(String name) {
        if (name == null || name.isEmpty()){
            throw new NullPointerException("차이름은 공백 또는 빈 문자열일 수 없습니다.");
        }
    }

    private void checkNameLengthUnderSix(String name) {
        if (name.length() > MAX_NAME_SIZE){
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public boolean isNameEqual(String name) {
        return this.name == name;
    }

    public void move(RandomNo randomNo){
        if (randomNo.isMovable()){
            position.add();
        }
    }

    public String getCurrentResult() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(" : ");
        result.append(position.getPositionByDash());
        return result.toString();
    }

    public String getCurrentResult(Position position) {
        StringBuilder result = new StringBuilder();
        result.append(name).append(" : ");
        result.append(position.getPositionByDash());
        return result.toString();
    }
}
