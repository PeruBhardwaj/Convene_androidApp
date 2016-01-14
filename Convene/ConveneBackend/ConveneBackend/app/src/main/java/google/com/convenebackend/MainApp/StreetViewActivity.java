package google.com.convenebackend.MainApp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.SupportStreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

import google.com.convenebackend.R;

public class StreetViewActivity extends AppCompatActivity implements GoogleMap.OnMarkerDragListener, StreetViewPanorama.OnStreetViewPanoramaChangeListener {

    private static final String MARKER_POSITION_KEY = "MarkerPosition";

    private StreetViewPanorama mStreetViewPanorama;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_street_view);

        Intent intent = getIntent();
        Double x = intent.getDoubleExtra(MapsActivity.EXTRA_MESSAGE1, -33.8736);
        Double y = intent.getDoubleExtra(MapsActivity.EXTRA_MESSAGE2, 151.20689);

        final LatLng DUBLIN = new LatLng(x, y);

        SupportStreetViewPanoramaFragment streetViewPanoramaFragment =
                (SupportStreetViewPanoramaFragment)
                        getSupportFragmentManager().findFragmentById(R.id.streetviewpanorama);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(
                new OnStreetViewPanoramaReadyCallback() {
                    @Override
                    public void onStreetViewPanoramaReady(StreetViewPanorama panorama) {


                        mStreetViewPanorama = panorama;
                        mStreetViewPanorama.setOnStreetViewPanoramaChangeListener(StreetViewActivity.this);
                        // Only need to set the position once as the streetview fragment will maintain
                        // its state.
                        if (savedInstanceState == null) {
                            mStreetViewPanorama.setPosition(DUBLIN);

                        }
                    }
                });
    }

    @Override
    public void onStreetViewPanoramaChange(StreetViewPanoramaLocation location) {
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        mStreetViewPanorama.setPosition(marker.getPosition(), 150);
    }

    @Override
    public void onMarkerDrag(Marker marker) {
    }

}


