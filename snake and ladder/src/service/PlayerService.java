package service;

import model.Player;
import java.util.List;

public interface PlayerService {
    public void registerPlayer(String name);
    public List<Player> getPlayerList();
}
