package net.zypr.Fukurou.api.phase;

import net.zypr.Fukurou.api.game.GameInstance;
import net.zypr.Fukurou.internal.Timer;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface GamePhase<T extends GameInstance> {

    Timer timer();

    Consumer<T> getInitialExecution();
    Function<T, @Nullable GamePhase<T>> getExecution();
    Function<T, List<Listener>> getListeners();
}
