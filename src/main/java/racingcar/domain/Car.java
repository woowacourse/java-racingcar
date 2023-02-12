package racingcar.domain;

public class Car {

    private final Name name;
    private Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public void tryMove(int number) {
        position.moveOrStop(number);
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    //TODO: Car에서 이름이랑 포지션 가져올때 string으로 가져오는지 그냥 필드로 가져오는지..?
    //String으로 가져온다면 어떤방법으로 가져오는지..?
    public String getName() {
        return this.name.getName();
    }
}
