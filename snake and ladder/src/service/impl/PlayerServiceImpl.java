package service.impl;

import model.Player;
import service.PlayerService;

import java.util.ArrayList;
import java.util.List;

public class PlayerServiceImpl implements PlayerService {

    private final List<Player> playerList;
    public PlayerServiceImpl(int numberOfPlayers) {
        this.playerList = new ArrayList<>(numberOfPlayers);
    }

    @Override
    public void registerPlayer(String playerName) {
        Player player = new Player(playerName);
        playerList.add(player);
    }

    @Override
    public List<Player> getPlayerList() {
        return playerList;
    }

}
