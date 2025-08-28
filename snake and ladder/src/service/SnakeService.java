package service;

import java.util.HashMap;

public interface SnakeService {
    public void registerSnake(int head, int tail);
    public HashMap<Integer, Integer> getSnakesMap();
}
