package net.zypr.Fukurou.internal;

import net.zypr.Fukurou.api.GameControllable;
import net.zypr.Fukurou.api.executor.GameExecutor;
import net.zypr.Fukurou.api.game.GameInstance;
import net.zypr.Fukurou.api.phase.GamePhase;
import org.bukkit.plugin.java.JavaPlugin;

public class GameExecutorImpl<T extends GameInstance> implements GameExecutor<T> {
    private GameScheduler<T> gameScheduler;
    private final T gameInstance;

    public GameExecutorImpl(T gameInstance, JavaPlugin plugin, GamePhase<T> firstPhase) {
        this.gameInstance = gameInstance;
        this.gameScheduler = new GameScheduler<>(gameInstance, plugin, new GamePhaseScheduler<>(gameInstance, firstPhase, plugin));
    }

    public GameExecutorImpl(T gameInstance, JavaPlugin plugin, GamePhase<T> firstPhase, GameControllable gameControllable) {
        this.gameInstance = gameInstance;
        this.gameScheduler = new GameScheduler<>(gameInstance, plugin, new GamePhaseScheduler<>(gameInstance, firstPhase, plugin), gameControllable);
    }

    @Override
    public boolean start() {
        if (gameScheduler.isRunningGame()) {
            return false;
        }
        this.gameScheduler.start();
        return true;
    }

    @Override
    public T getGameInstance() {
        return this.gameInstance;
    }

    @Override
    public GameScheduler<T> getGameScheduler() {
        return this.gameScheduler;
    }

    @Override
    public GamePhaseScheduler<T> getGamePhaseScheduler() {
        return this.gameScheduler.getGamePhaseScheduler();
    }

    @Override
    public GamePhase<T> getPhase() {
        return this.gameScheduler.getGamePhaseScheduler().getPhase();
    }


}
