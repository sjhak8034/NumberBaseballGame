package Games.NumberBaseballGame;

public class CurrentResult {
    private int strike = 0;
    private int ball = 0;
    private int out = 0;
    private int score = 0;


    public void incrementStrike() {
        strike++;
    }
    public void incrementBall() {
        ball++;
    }
    public void incrementOut() {
        out++;
    }
    public void incrementScore() {
        score++;
    }
    public void resetSBO(){
        strike = 0;
        ball = 0;
        out = 0;
    }

    public int getStrike() {
        return strike;
    }
    public int getBall() {
        return ball;
    }
    public int getOut() {
        return out;
    }
    public int getScore() {
        return score;
    }
}
