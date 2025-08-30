package net.zypr.Fukurou.api.game;

import net.zypr.Fukurou.internal.Timer;
import net.zypr.Fukurou.internal.game.SimpleGameInstance;


public interface GameInstance {

    static GameInstance of(Timer timer, Runnable gameTerminatedExecution) {
        return new SimpleGameInstance(timer, gameTerminatedExecution);
    }

    Timer getTimer();
    int getGameTick();
}
