package net.zypr.Fukurou.api.phase;

import net.zypr.Fukurou.api.game.GameInstance;
import net.zypr.Fukurou.internal.Timer;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class GamePhase<T extends GameInstance> {

    private final Timer timer = new Timer();

    public Timer getTimer() {
        return this.timer;
    }

    public abstract Consumer<T> getInitialExecution();
    public abstract Function<T, @Nullable GamePhase<T>> getExecution();
    public abstract Function<T, List<Listener>> getListeners();
}
