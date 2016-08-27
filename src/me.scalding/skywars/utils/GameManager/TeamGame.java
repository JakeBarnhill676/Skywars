package skywars.utils.GameManager;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import skywars.utils.GameManager.enums.GameState;
import skywars.utils.GameManager.enums.GameType;

import java.util.List;
import java.util.Map;

/**
 * @author Scalding (Jake)
 */
public class TeamGame extends Game {

    private String name;
    private int size;
    private List<Location> spawnPoints;
    private List<Block> brokenBlocks;
    private Map<Block, Block> placedBlocks;
    private GameState state;
    private GameType type;

    public TeamGame(String name, int size, List<Location> spawnPoints, Map<Player, Player> players, GameState state, GameType type) {
        super(name, size, spawnPoints, players, state, type);
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public List<Location> getSpawnPoints() {
        return spawnPoints;
    }

    public GameState getState() {
        return state;
    }

    public GameType getType() {
        return type;
    }

}
