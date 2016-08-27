package skywars;

import org.bukkit.plugin.java.JavaPlugin;
import skywars.utils.VersionChecker;

/**
 * @author Scalding (Jake)
 *
 * Skywars Plugin
 */
public class SkyWars extends JavaPlugin {

    private static SkyWars instance;

    @Override
    public void onEnable() {
        VersionChecker checker = new VersionChecker();
        instance = this;
        checker.update();
    }

    public static SkyWars getInstance() {
        return instance;
    }


}
