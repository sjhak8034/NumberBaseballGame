package data;

import game.log.GameLogPrinter;

import java.util.ArrayList;

public class NumberBaseBallData implements Data<GameLogPrinter> {

    private final ArrayList<GameLogPrinter> logData = new ArrayList<>(){};
    // 판 단위의 로그를 저장

    @Override
    public void save(GameLogPrinter record) {
        logData.add(record);
    }
    // 판당 기록을 출력
    @Override
    public void printData() {
        System.out.println("< 게임 기록 보기 >");
        int index = 0;
        for (GameLogPrinter logger : logData) {
            logger.printSuccessLog(index++);
        }
    }

    @Override
    public void printReplay() {
        System.out.println("< Replay >");
        int index = 0;
        for (GameLogPrinter logger : logData) {
            logger.printReplay(index++);
        }
    }



}
