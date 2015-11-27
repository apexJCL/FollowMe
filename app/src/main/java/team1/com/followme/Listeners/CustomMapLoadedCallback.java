package team1.com.followme.Listeners;

import android.content.res.AssetManager;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import team1.com.followme.Stuff.RouteLoader;

/**
 * This class listens when the map ends loading, then it loads the routes into view
 */
public class CustomMapLoadedCallback implements GoogleMap.OnMapLoadedCallback {

    private RouteLoader routeLoader;

    public CustomMapLoadedCallback(GoogleMap map, AssetManager assetManager){
        routeLoader = new RouteLoader(assetManager, map);
    }

    @Override
    public void onMapLoaded() {
        try{
            Log.i("Route Loader", "Started ...");
            routeLoader.LoadRoutes();
            Log.i("Route Loader", "Done!");
        }
        catch (Exception e) {e.printStackTrace();}
    }
}
