package net.zypr.Fukurou.api.executor;

import net.zypr.Fukurou.api.game.GameInstance;
import net.zypr.Fukurou.api.phase.GamePhase;
import net.zypr.Fukurou.internal.GamePhaseScheduler;
import net.zypr.Fukurou.internal.GameScheduler;

public interface GameExecutor<T extends GameInstance>{
    boolean start();

    T getGameInstance();

    GameScheduler<T> getGameScheduler();

    GamePhaseScheduler<T> getGamePhaseScheduler();

    GamePhase<T> getPhase();
}
