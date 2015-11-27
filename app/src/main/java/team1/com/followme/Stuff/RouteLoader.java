package team1.com.followme.Stuff;

import android.content.res.AssetManager;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by apex on 11/27/15.
 */
public class RouteLoader {

    private FileParser fileParser;
    private GoogleMap map;

    /**
     * This class manages the loading of the routes into the map
     * @param assetManager
     * @param map
     */
    public RouteLoader(AssetManager assetManager, GoogleMap map){
        fileParser = new FileParser(assetManager);
        this.map = map;
    }

    /**
     * This loads the routes into the map
     * @throws Exception
     */
    public void LoadRoutes()throws Exception{
        // Gets the list of all the routes
        ArrayList<Route> routeList = fileParser.parse();
        // Gets the iterator
        Iterator<Route> iterator = routeList.iterator();
        // While there are routes
        while (iterator.hasNext()){
            // Get the route
            Route tmp = iterator.next();
            Log.i("RouteLoader", "Adding route: "+tmp.getTitle());
            // Get the points to draw on map
            ArrayList<LatLng> points = tmp.getPoints();
            // Iterate the points
            Iterator<LatLng> pointIterator = points.iterator();
            // Create the polyline
            PolylineOptions polylineOptions = new PolylineOptions();
            // While the route has points
            while (pointIterator.hasNext())
                polylineOptions.add(pointIterator.next()); // add them to the polyline
            // We set the color of the polyline
            polylineOptions.color(tmp.getColor());
            // Finally, add it to the map
            map.addPolyline(polylineOptions);
        }
    }

}
