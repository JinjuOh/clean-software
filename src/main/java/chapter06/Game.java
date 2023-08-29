package chapter06;

public class Game {

    private int itsCurrentFrame = 0;
    private boolean firstThrowInFrame = true;
    private Scorer scorer = new Scorer();

    public int score() {
        return scoreForFrame(itsCurrentFrame);
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }

    public void add(int pins) {
        scorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if(lastBallInFrame(pins)) {
            advanceFrame();
        } else
            firstThrowInFrame = false;
    }

    private boolean lastBallInFrame(int pins) {
        return strike(pins) || (!firstThrowInFrame);
    }

    private boolean strike(int pins) {
        return firstThrowInFrame && pins == 10;
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(10, itsCurrentFrame + 1);
    }

    public int scoreForFrame(int theFrame) {
        return scorer.scoreForFrame(theFrame);
    }


}
