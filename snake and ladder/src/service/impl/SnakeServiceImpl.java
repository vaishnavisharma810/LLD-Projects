package service.impl;

import service.SnakeService;

import java.util.HashMap;

public class SnakeServiceImpl implements SnakeService {

    private final HashMap<Integer, Integer> snakesMap;
    public SnakeServiceImpl(int numberOfSnakes) {
        this.snakesMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> getSnakesMap() {
        return snakesMap;
    }

    @Override
    public void registerSnake(int head, int tail) {
        if(!snakesMap.containsKey(head)) {
            snakesMap.put(head, tail);
        }
    }
}
