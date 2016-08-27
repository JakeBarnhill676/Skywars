package skywars;

import org.bukkit.plugin.java.JavaPlugin;
import skywars.utils.GameManager.GameManager;
import skywars.utils.SQLManager;
import skywars.utils.VersionChecker;

import java.util.ArrayList;

/**
 * @author Scalding (Jake)
 *
 * Skywars Plugin
 */
public class SkyWars extends JavaPlugin {

    private static SkyWars instance;
    private static SQLManager sqlManager;

    @Override
    public void onEnable() {
        VersionChecker checker = new VersionChecker();
        sqlManager = new SQLManager();
        instance = this;
        checker.update();
        sqlManager.connect();
        GameManager.games = new ArrayList<>();
    }

    public static SkyWars getInstance() {
        return instance;
    }

    public static SQLManager sqlManager() {
        return sqlManager;
    }


}
