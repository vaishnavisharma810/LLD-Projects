package service;

import java.util.HashMap;

public interface LadderService {
    public void registerLadder(int start, int end);
    public HashMap<Integer, Integer> getLaddersMap();
}
