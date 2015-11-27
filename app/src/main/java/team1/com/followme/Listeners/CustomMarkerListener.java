package team1.com.followme.Listeners;

import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by apex on 11/26/15.
 */
public class CustomMarkerListener implements GoogleMap.OnMarkerClickListener {
    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.d("MarkerListener", "Marker name: "+marker.getTitle());
        if(marker.getTitle().equals("Yo")){
            if (marker.isInfoWindowShown())
                marker.hideInfoWindow();
            else
                marker.showInfoWindow();
        }
        return true;
    }
}
