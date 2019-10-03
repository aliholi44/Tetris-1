package com.mainpakage.sprites;

public class GameThread extends Thread {
    static final long FPS = 1000;
    private CustomView view;
    private boolean running = false;

    public GameThread (CustomView view) {
        this.view = view;
    }

    public void setRunning (boolean run) {
        running = run;
    }

    public boolean isRunning () {
        return this.running == true;
    }

    @Override
    public void run () {
        long ticksPS = 1000 / FPS;
        long startTime;
        long sleepTime;

        while (running) {
            startTime = System.currentTimeMillis();
            view.postInvalidate();
            sleepTime = ticksPS-(System.currentTimeMillis() - startTime);

            try {
                if (sleepTime > 0)
                    sleep(sleepTime);
            }
            catch (Exception e) {}
        }
    }

}
