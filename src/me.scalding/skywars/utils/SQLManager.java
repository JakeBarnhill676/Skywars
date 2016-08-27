package skywars.utils;

import skywars.SkyWars;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Jake on 8/26/2016.
 */
public class SQLManager {

    private Connection connection;
    private String host, database, username, password;
    private int port;

    public void connect() {
        try {
            if (!SkyWars.getInstance().getConfig().getBoolean("mysql.enabled")) return;
            host = SkyWars.getInstance().getConfig().getString("mysql.host");
            port = SkyWars.getInstance().getConfig().getInt("mysql.port");
            database = SkyWars.getInstance().getConfig().getString("mysql.database");
            username = SkyWars.getInstance().getConfig().getString("mysql.root");
            password = SkyWars.getInstance().getConfig().getString("mysql.password");
            if (connection != null && !connection.isClosed()) {
                return;
            }

            synchronized (this) {
                if (connection != null && !connection.isClosed()) {
                    return;
                }
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database, this.username, this.password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
