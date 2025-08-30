package net.zypr.Fukurou.api.game;

import net.zypr.Fukurou.internal.Timer;

public class SimpleGameInstance implements GameInstance {


    private final Timer timer;
    private final Runnable gameTerminatedExecution;


    public SimpleGameInstance(Timer timer, Runnable gameTerminatedExecution) {
        this.timer = timer;
        this.gameTerminatedExecution = gameTerminatedExecution;
    }

    @Override
    public Timer getTimer() {
        return timer;
    }


    @Override
    public int getGameTick() {
        return 5;
    }

}
