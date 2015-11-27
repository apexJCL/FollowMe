package team1.com.followme.Stuff;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class FileParser {

    private final AssetManager assetManager;
    private ArrayList<Route> routeArray = new ArrayList<>(0);

    public FileParser(AssetManager assetManager){
        this.assetManager = assetManager;
    }

    /**
     * It loads the file and parses it to valid routes
     * @throws IOException File not found
     */
    public ArrayList<Route> parse()throws IOException{
        InputStream file = assetManager.open("routes");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file));
        String line;
        Route tmp = null;
        while ((line = reader.readLine()) != null){
            if(line.matches("'.*'")){
                if(tmp != null)
                    routeArray.add(tmp);
                tmp = new Route(line);
            }
            else{
                if (line.matches("[A-Z]+")){
                    tmp.setColor(line);
                }
                else{
                    tmp.addPoint(line);
                }
            }
        }
        routeArray.add(tmp);
        return routeArray;
    }
}
