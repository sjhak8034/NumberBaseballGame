package data;

import game.log.GameLogPrinterPrinter;

import java.util.ArrayList;

public class NumberBaseBallData implements Data<GameLogPrinterPrinter> {

    private final ArrayList<GameLogPrinterPrinter> logData = new ArrayList<>(){};
    // 판 단위의 로그를 저장

    @Override
    public void save(GameLogPrinterPrinter record) {
        logData.add(record);
    }
    // 판당 기록을 출력
    @Override
    public void printData() {
        System.out.println("< 게임 기록 보기 >");
        for (int i = 0; i < logData.size(); i++) {
            GameLogPrinterPrinter logger = logData.get(i);
            logger.printSuccessLog(i);
        }

    }
    // 사용자의 모든 입력을 출력
    @Override
    public void printReplay() {
        System.out.println("< Replay >");
        for (int i = 0; i < logData.size(); i++) {
            GameLogPrinterPrinter logger = logData.get(i);
            logger.printReplay(i);
        }

    }



}
