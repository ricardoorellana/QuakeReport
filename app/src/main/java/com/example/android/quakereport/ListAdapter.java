package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Rorellanam on 7/26/16.
 */
public class ListAdapter extends ArrayAdapter<Earthquake> {
    private static final String LOCATION_SEPARATOR = " of ";

    public ListAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String primaryLocation;
        String locationOffset;

        View listItemView = convertView;

        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Earthquake currentEarthquake = getItem(position);



        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitudeTextView);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) magnitude.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(currentEarthquake.getMagnitude());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        //To display magnitude with format
        DecimalFormat formatter = new DecimalFormat("0.0");
        String magnitudeOutput = formatter.format(currentEarthquake.getMagnitude());
        magnitude.setText(magnitudeOutput);

        String location = currentEarthquake.getLocation();

        if (location.contains(LOCATION_SEPARATOR)) {
            String[] parts = location.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = location;
        }

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_locationTextView);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        TextView date = (TextView) listItemView.findViewById(R.id.dateTextView);
        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(currentEarthquake.getTimeInMilliSeconds());

        String formattedDate = formatDate(dateObject);
        date.setText(formattedDate);


        TextView time = (TextView) listItemView.findViewById(R.id.timeView);
        String formattedTime = formatTime(dateObject);

        time.setText(formattedTime);

        return listItemView;
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }




    private int getMagnitudeColor(double magnitude) {
        int magnitudeColor;
        int magnitudeInt = (int) Math.floor(magnitude);

        switch (magnitudeInt) {
            case 0:
            case 1 :
                magnitudeColor = R.color.magnitude1;
                break;
            case 2 :
                magnitudeColor = R.color.magnitude2;
                break;
            case 3 :
                magnitudeColor = R.color.magnitude3;
                break;
            case 4 :
                magnitudeColor = R.color.magnitude4;
                break;
            case 5 :
                magnitudeColor = R.color.magnitude5;
                break;
            case 6 :
                magnitudeColor = R.color.magnitude6;
                break;
            case 7 :
                magnitudeColor = R.color.magnitude7;
                break;
            case 8 :
                magnitudeColor = R.color.magnitude8;
                break;
            case 9 :
                magnitudeColor = R.color.magnitude9;
                break;
           default :
                magnitudeColor = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitudeColor);
    }
}
