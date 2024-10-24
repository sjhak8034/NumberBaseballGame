package game.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GameLog {
    private int strike = 0;
    private int ball = 0;
    private int out = 0;
    private final int level;
    private int win = 0;
    private final String formattedDateTime;

    public GameLog(int level) {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        formattedDateTime = now.format(formatter);
        this.level= level;
    }

    public void incrementStrike() {
        strike++;
    }

    public void incrementBall() {
        ball++;
    }

    public boolean isCorrect() {
        if(strike ==level ){
            this.win++;
            return true;
        }
        return false;
    }

    public boolean isOut() {
        if(strike ==0 && ball == 0){
            this.out++;
            return true;
        }
        return false;
    }

    public void printStrikeBall() {
        System.out.println(ball + " 볼 " + strike + " 스트라이크");
    }

    public void printLevel() {
        System.out.printf("[%d 레벨]",level);
    }

    public void printTime(){

        System.out.printf("[ "+formattedDateTime+" ]");
    }


}
