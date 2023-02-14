import controller.RacingController;

public class Application {

    public static void main(String[] args) {
        try {
            new RacingController().run();
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }

}
