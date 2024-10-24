package data;

import game.log.GameLogPrinter;

import java.util.ArrayList;

public class NumberBaseBallData<T extends GameLogPrinter> implements Data<T> {

    private final ArrayList<T> logData = new ArrayList<>(){};
    @Override
    public void save(T record) {
        logData.add(record);
    }
    @Override
    public void printData() {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < logData.size(); i++) {
            T logger = logData.get(i);
            logger.printSuccessLog(i);
        }

    }
    @Override
    public void printReplay() {
        System.out.println("< Replay >");
        for (int i = 0; i < logData.size(); i++) {
            T logger = logData.get(i);
            logger.printReplay(i);
        }

    }



}
