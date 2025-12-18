package net.zypr.Fukurou.api.game;

import net.zypr.Fukurou.internal.Timer;


public abstract class GameInstance {

    private final Timer timer = new Timer();

    public Timer getTimer() {
        return this.timer;
    }

    public abstract int gameTick();
}
