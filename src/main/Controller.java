package main;


import game.Game;
import game.numberbaseball.NumberBaseballStarter;
import game.log.GameLogPrinter;
import Input.Input;
import data.NumberBaseBallData;
import data.Data;

public class Controller {


    public void start() {
        // 숫자 야구 게임 기록을 생성
        Data<GameLogPrinter> recordBaseball = new NumberBaseBallData();

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");

        boolean stop = false;

        while (!stop) {
            Mode mode = getModeFromUserInput();
            switch (mode) {
                case STARTGAME:

                    Game<GameLogPrinter> numberBaseball = new NumberBaseballStarter();
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

    private Mode getModeFromUserInput(){
        Input input = new Input();
        int selectedModeNumber = input.getUserInputForMode();

        return Mode.fromInt(selectedModeNumber);
    }

}
