package net.zypr.Fukurou.internal.phase;

import net.zypr.Fukurou.api.game.GameInstance;
import net.zypr.Fukurou.api.phase.GamePhase;
import org.bukkit.event.Listener;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public final class SimpleGamePhase<T extends GameInstance> extends GamePhase<T> {
    private final Consumer<T> initExecution;
    private final Function<T, GamePhase<T>> loopExecution;
    private final Function<T, List<Listener>> listeners;

    public SimpleGamePhase(Consumer<T> initExecution, Function<T, GamePhase<T>> loopExecution, Function<T, List<Listener>> listeners) {
        this.initExecution = initExecution;
        this.loopExecution = loopExecution;
        this.listeners = listeners;
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


}
