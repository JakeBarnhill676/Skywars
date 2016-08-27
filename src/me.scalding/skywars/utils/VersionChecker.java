package skywars.utils;

import org.bukkit.Bukkit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Scalding (Jake)
 * This is used to check if the current
 * version running on the server is the
 * same as the one in a webpage
 */
public class VersionChecker {

    private boolean updated() {
        return getVersion()==0.1;
    }

    private double getVersion() {
        try {
            URL github = new URL("https://scaldingmc.github.io/skywars");
            BufferedReader in = new BufferedReader(new InputStreamReader(github.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.startsWith("<h1>VERSION: ")) {
                    inputLine = inputLine.substring(13, inputLine.length() - 5);
                    return Double.valueOf(inputLine);
                }
            }
            in.close();
            return 0;
        }catch(IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public void update() {
        if(!updated()) {
            Bukkit.getLogger().severe("§cSkywars > You are using version 0.1, please update to the version " + getVersion() + ".");
        }
    }



}
