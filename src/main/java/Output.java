import java.util.List;

public class Output {
    // 에러
    final String error_message = "[ERROR] : ";

    public void printErrorMessage(String message){
        System.out.println(error_message + message);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printEachCarDistance(List<Car> cars) {
        cars.forEach(car -> System.out.println(car.toString()));
        System.out.println();
    }

    public void printWinner(Winner winner){
        System.out.println(winner.toString());
    }

}
