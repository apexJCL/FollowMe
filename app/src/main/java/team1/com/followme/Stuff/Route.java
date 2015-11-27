package team1.com.followme.Stuff;

import android.graphics.Color;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * This class is a container for a "route", that will become a Polyline on the Google map
 */
public class Route {

    private String title; // Title of the route
    private int color; // Color of the route
    private String _color;
    private ArrayList<LatLng> points = new ArrayList<>(0); // Lat, Long points to track it on the map

    /**
     * It creates a route with the given title
     * @param title Title of the route
     */
    public Route(String title){
        this.title = title;
    }

    /**
     * Adds a point to the route tracing, it parses a lat, long to double and adds it
     * @param latlong
     */
    public void addPoint(String latlong){
        StringTokenizer stk = new StringTokenizer(latlong, ",");
        addPoint(Double.parseDouble(stk.nextToken()), Double.parseDouble(stk.nextToken()));
    }

    /**
     * Adds a point to the route tracing
     * @param latitude
     * @param longitude
     */
    private void addPoint(double latitude, double longitude){
        points.add(new LatLng(latitude, longitude));
    }

    public ArrayList<LatLng> getPoints(){ return points; }

    /**
     * Defines the color of the polyline to be drawed
     * @param color
     */
    public void setColor(String color){
        _color = color;
        this.color = getAndroidColor(color);
    }

    /**
     * Returns the assigned title
     * @return
     */
    public String getTitle(){
        return title;
    }

    /**
     * Returns the color of the route
     * @return
     */
    public int getColor(){
        return color;
    }

    /**
     * It returns the color in string format
     * @return
     */
    public String _getColor(){ return _color; }

    /**
     * Parses the string to the desired color
     * @param color
     * @return
     */
    private int getAndroidColor(String color){
        switch (color){
            case "BLUE":
                return Color.BLUE;
            case "CYAN":
                return Color.CYAN;
            case "GRAY":
            case "GREY":
                return Color.GRAY;
            case "GREEN":
                return Color.GREEN;
            case "MAGENTA":
                return Color.MAGENTA;
            case "RED":
                return Color.RED;
            case "YELLOW":
                return Color.YELLOW;
            default:
                return Color.BLACK;
        }
    }

}
