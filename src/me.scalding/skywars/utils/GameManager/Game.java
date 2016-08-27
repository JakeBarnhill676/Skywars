package skywars.utils.GameManager;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import skywars.utils.GameManager.enums.GameState;
import skywars.utils.GameManager.enums.GameType;

import java.util.List;
import java.util.Map;

/**
 * @author Scalding (Jake)
 */
public abstract class Game {


    Game(String name, int size, List<Location> spawnPoints, List<Player> players, GameState state, GameType type) {

    }

    Game(String name, int size, List<Location> spawnPoints, Map<Player, Player> players, GameState state, GameType type) {

    }

    public abstract String getName();
    public abstract int getSize();
    public abstract List<Location> getSpawnPoints();
    public abstract GameState getState();
    public abstract GameType getType();

}
