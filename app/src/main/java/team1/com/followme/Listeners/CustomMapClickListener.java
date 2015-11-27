package team1.com.followme.Listeners;

import android.content.res.AssetManager;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import team1.com.followme.Stuff.RouteLoader;

/**
 * Created by apex on 11/26/15.
 */
public class CustomMapClickListener implements GoogleMap.OnMapClickListener {

    private GoogleMap map;
    private Marker marker = null;
    private RouteLoader routeLoader;

    /**
     * Defines a custom OnMapClickListener, with the given map
     * @param map
     */
    public CustomMapClickListener(GoogleMap map, AssetManager assetManager){
        this.map = map;
        routeLoader = new RouteLoader(assetManager, map);
    }

    @Override
    public void onMapClick(LatLng latLng) {
        if(marker == null) {
            try{
                routeLoader.LoadRoutes();
            }
            catch (Exception e){}
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(latLng).title("Destino");
            marker = map.addMarker(markerOptions);
        }
        else{
            marker.setPosition(latLng);
        }
        marker.showInfoWindow();
        marker.setDraggable(true);
        marker.setFlat(true);
        CameraPosition cameraPosition = new CameraPosition.Builder().target(latLng).zoom(map.getCameraPosition().zoom).build();
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
