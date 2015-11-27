package team1.com.followme.LIsteners;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by apex on 11/26/15.
 */
public class CustomMarkerListener implements GoogleMap.OnMarkerClickListener {
    @Override
    public boolean onMarkerClick(Marker marker) {
        if(marker.getTitle().equals("Yo")){
            if (marker.isInfoWindowShown())
                marker.hideInfoWindow();
            else
                marker.showInfoWindow();
        }
        return true;
    }
}
