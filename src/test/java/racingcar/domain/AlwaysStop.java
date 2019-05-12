package racingcar.domain;

class AlwaysStop implements Movable {
    public boolean isMovable() {
        return false;
    }
}