import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    GameView gameView = new GameView();
    private final BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    private List<String> nameList;
    private List<Car> carList;
    private Dice dice = new Dice();

