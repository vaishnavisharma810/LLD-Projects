package service.impl;

import service.LadderService;

import java.util.HashMap;

public class LadderServiceImpl implements LadderService {

    private final HashMap<Integer, Integer> LaddersMap;

    public LadderServiceImpl(int numberOfLadders) {
        this.LaddersMap = new HashMap<>();
    }

    public HashMap<Integer, Integer> getLaddersMap() {
        return LaddersMap;
    }

    @Override
    public void registerLadder(int start, int end) {
        if(!LaddersMap.containsKey(start)) {
            LaddersMap.put(start, end);
        }
    }
}
