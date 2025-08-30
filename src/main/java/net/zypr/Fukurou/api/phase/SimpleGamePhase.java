package net.zypr.Fukurou.api.phase;

import net.zypr.Fukurou.api.game.GameInstance;
import net.zypr.Fukurou.internal.Timer;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class SimpleGamePhase<T extends GameInstance> implements GamePhase<T> {
    private final Consumer<T> initExecution;
    private final Function<T, GamePhase<T>> loopExecution;
    private final Function<T, List<Listener>> listeners;
    private final Timer timer;

    public SimpleGamePhase(Consumer<T> initExecution, Function<T, GamePhase<T>> loopExecution, Function<T, List<Listener>> listeners,
                           Timer timer) {
        this.initExecution = initExecution;
        this.loopExecution = loopExecution;
        this.listeners = listeners;
        this.timer = timer;
    }

    @Override
    public Consumer<T> getInitialExecution() {
        return initExecution;
    }

    @Override
    public Function<T, GamePhase<T>> getExecution() {
        return loopExecution;
    }

    @Override
    public Function<T, List<Listener>> getListeners() {
        return listeners;
    }

    @Override
    public Timer timer() {
        return timer;
    }

}
