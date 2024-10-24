package main;


import game.Game;
import game.numberbaseball.NumberBaseballStarter;
import game.log.GameLogPrinterPrinter;
import Input.Input;
import data.NumberBaseBallData;
import data.Data;

public class Controller {


    public void start() {
        // 숫자 야구 게임 기록을 생성
        Data<GameLogPrinterPrinter> recordBaseball = new NumberBaseBallData();

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");

        boolean stop = false;

        while (!stop) {
            Mode mode = setMode();
            switch (mode) {
                case STARTGAME:

                    Game<GameLogPrinterPrinter> numberBaseball = new NumberBaseballStarter();
                    recordBaseball.save(numberBaseball.playGame());
                    break;

                case PRINTRECORD:

                    recordBaseball.printData();
                    break;

                case PLAYREPLAY:

                    recordBaseball.printReplay();
                    break;

                case EXITGAME:

                    stop = true;
                    System.out.println("<숫자 야구 게임을 종료합니다>");

                    break;
            }
        }
    }

    private Mode setMode (){
        Input input = new Input();
        int unconvertedMode = input.getMode();
        int modeCount = 0;
        Mode convertedMode = Mode.EXITGAME;

        for (Mode m : Mode.values()) {
            modeCount++;
            convertedMode = m;
            if (modeCount == unconvertedMode) {
                break;
            }
        }
        return convertedMode;
    }
}
