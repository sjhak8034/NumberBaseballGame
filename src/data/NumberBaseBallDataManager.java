package data;

import game.log.GameLog;
import game.log.LogPrinter;

import java.util.ArrayList;
import java.util.List;

public class NumberBaseBallDataManager implements Data<LogPrinter<GameLog>> {

    private final List<LogPrinter<GameLog>> logData = new ArrayList<>(){};
    // 판 단위의 로그를 저장

    @Override
    public void save(LogPrinter<GameLog> record) {
        logData.add(record);
    }
    // 판당 기록을 출력
    @Override
    public void printData() {
        System.out.println("< 게임 기록 보기 >");
        int index = 0;
        for (LogPrinter<GameLog> logger : logData) {
            logger.printSuccessLog(index++);
        }
    }

    @Override
    public void printReplay() {
        System.out.println("< Replay >");
        int index = 0;
        for (LogPrinter<GameLog> logger : logData) {
            logger.printReplay(index++);
        }
    }



}
