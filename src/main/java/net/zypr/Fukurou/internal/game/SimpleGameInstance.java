package net.zypr.Fukurou.internal.game;

import net.zypr.Fukurou.api.game.GameInstance;

public class SimpleGameInstance extends GameInstance {


    public SimpleGameInstance() {
    }


    @Override
    public int gameTick() {
        return 1;
    }
}
