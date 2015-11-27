package team1.com.followme.Listeners;

import android.location.Location;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class CustomLocationChangeListener implements GoogleMap.OnMyLocationChangeListener {

    private GoogleMap map;
    private Marker myposition;

    public CustomLocationChangeListener(GoogleMap map){
        this.map = map;
    }

    @Override
    public void onMyLocationChange(Location location) {
        if(myposition == null){
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(location.getLatitude(), location.getLongitude()));
            markerOptions.title("Yo");
            myposition = map.addMarker(markerOptions);
            CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(location.getLatitude(), location.getLongitude())).zoom(15).build();
            map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            myposition.showInfoWindow();
        }
        else{
            myposition.setPosition(new LatLng(location.getLatitude(), location.getLongitude()));
        }
    }
}
