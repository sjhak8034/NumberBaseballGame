package data;

import game.log.GameLogPrinter;

import java.util.ArrayList;

public class NumberBaseBallData implements Data<GameLogPrinter> {

    private final ArrayList<GameLogPrinter> logData = new ArrayList<>(){};
    @Override
    public void save(GameLogPrinter record) {
        logData.add(record);
    }
    @Override
    public void printData() {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < logData.size(); i++) {
            GameLogPrinter logger = logData.get(i);
            logger.printSuccessLog(i);
        }

    }
    @Override
    public void printReplay() {
        System.out.println("< Replay >");
        for (int i = 0; i < logData.size(); i++) {
            GameLogPrinter logger = logData.get(i);
            logger.printReplay(i);
        }

    }



}
