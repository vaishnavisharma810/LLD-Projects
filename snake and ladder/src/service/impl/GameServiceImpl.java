package service.impl;

import model.Player;
import service.GameService;
import service.LadderService;
import service.PlayerService;
import service.SnakeService;
import utils.DiceRandomUtils;

public class GameServiceImpl implements GameService {

    private final PlayerService playerService;
    private final SnakeService snakeService;
    private final LadderService ladderService;

    public GameServiceImpl(PlayerService playerService, SnakeService snakeService, LadderService ladderService) {
        this.playerService = playerService;
        this.snakeService = snakeService;
        this.ladderService = ladderService;
    }
    @Override
    public void gameProcess(int numberOfPlayers) {
        int i = 0;
        while(i < numberOfPlayers) {
            playerService.getPlayerList().get(i).setPosition(0);
            i++;
        }
        System.out.println("We will start with " + playerService.getPlayerList().get(0).getName());
        boolean gameIsLive = true;
        DiceRandomUtils dice = new DiceRandomUtils();
        while(gameIsLive) {
            i = 0;
            while(i < numberOfPlayers) {
                Player player = playerService.getPlayerList().get(i);
                String currentPlayerName = player.getName();
                System.out.println(currentPlayerName + "'s turn: ");
                int diceNumber = dice.generateDiceNumber();
                System.out.println("Dice rolled: " + diceNumber);
                int newPosition = player.getPosition() + diceNumber;
                if(newPosition > 100){
                    continue;
                }
                if(snakeService.getSnakesMap().containsKey(newPosition)) {
                    System.out.println("Snake is at " + newPosition +" now you go to: " +snakeService.getSnakesMap().get(newPosition));
                    player.setPosition(snakeService.getSnakesMap().get(newPosition));
                } else if (ladderService.getLaddersMap().containsKey(newPosition)) {
                    System.out.println("Ladder is at " + newPosition +" now you go to: " +ladderService.getLaddersMap().get(newPosition));
                    player.setPosition(ladderService.getLaddersMap().get(newPosition));
                } else {
                    player.setPosition(newPosition);
                }
                System.out.println(player.getName() + " is at position: " + player.getPosition());
                if(player.getPosition() == 100) {
                    System.out.println("Player: " + player.getName() + " won");
                    gameIsLive = false;
                    break;
                }
                i++;
            }
        }
    }
}
