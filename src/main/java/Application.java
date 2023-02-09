import controller.RacingGameManager;

public class Application {
    public static void main(String[] args) {
        try {
            RacingGameManager.run();
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println(e.getMessage());
            RacingGameManager.run();
        }
    }
}
