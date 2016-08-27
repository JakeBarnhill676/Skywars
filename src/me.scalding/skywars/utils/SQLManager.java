package skywars.utils;

import skywars.SkyWars;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Jake on 8/26/2016.
 */
public class SQLManager {

    private Connection connection;

    public void connect() {
        try {
            if (!SkyWars.getInstance().getConfig().getBoolean("mysql.enabled")) return;
            String host = SkyWars.getInstance().getConfig().getString("mysql.host");
            int port = SkyWars.getInstance().getConfig().getInt("mysql.port");
            String database = SkyWars.getInstance().getConfig().getString("mysql.database");
            String username = SkyWars.getInstance().getConfig().getString("mysql.root");
            String password = SkyWars.getInstance().getConfig().getString("mysql.password");
            if (connection != null && !connection.isClosed()) {
                return;
            }

            synchronized (this) {
                if (connection != null && !connection.isClosed()) {
                    return;
                }
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
