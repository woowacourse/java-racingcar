package domain;

public interface MovementGenerator {
    Movement generate();

    boolean isMovable(NumberGenerator randomNumberGenerator);
}
