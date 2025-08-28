import model.Player;
import service.GameService;
import service.LadderService;
import service.PlayerService;
import service.SnakeService;
import service.impl.GameServiceImpl;
import service.impl.LadderServiceImpl;
import service.impl.PlayerServiceImpl;
import service.impl.SnakeServiceImpl;
import utils.DiceRandomUtils;
import java.util.Scanner;

public class GameApplication {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to Snake and Ladder Game");
        System.out.println("INFO: Board is of 100 cells, numbered from 1 to 100");

        //Get Players

        System.out.println("Enter Number of players");
        int numberOfPlayers = in.nextInt();
        PlayerService playerService = new PlayerServiceImpl(numberOfPlayers);
        for(int i = 1; i <= numberOfPlayers; i++) {
            System.out.println("Enter name of player number: " + i);
            String name = in.next();
            playerService.registerPlayer(name);
        }

        //Get Snakes

        System.out.println("Enter number of snakes you want in the game: ");
        int numberOfSnakes = in.nextInt();
        SnakeService snakeService = new SnakeServiceImpl(numberOfSnakes);
        System.out.println("Enter position (head > tail) for every snake in the game");
        for(int i = 1; i <= numberOfSnakes; i++) {
            int head = in.nextInt();
            int tail = in.nextInt();
            snakeService.registerSnake(head, tail);
        }

        //Get Ladders

        System.out.println("Enter number of ladders you want in the game: ");
        int numberOfLadders = in.nextInt();
        LadderService ladderService = new LadderServiceImpl(numberOfLadders);
        System.out.println("Enter position (start < end) for every ladder in the game");
        for(int i = 1; i <= numberOfLadders; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            ladderService.registerLadder(start, end);
        }

        //Start Game

        System.out.println("!!!LET'S START OUR GAME, All Players are at position 0!!!");
        GameService gameService = new GameServiceImpl(playerService, snakeService, ladderService);
        gameService.gameProcess(numberOfPlayers);
        in.close();
    }
}