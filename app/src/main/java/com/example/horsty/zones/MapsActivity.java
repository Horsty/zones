package com.example.horsty.zones;

import android.graphics.Color;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import static android.graphics.Color.RED;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final Marker[] mHometown = new Marker[1];
        // Add a marker in Sydney and move the camera
        final LatLng essen = new LatLng(51.35, 7);
        mMap.addMarker(new MarkerOptions().position(essen).title("Marker in Essen"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(essen));
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                mHometown[0] = mMap.addMarker(new MarkerOptions().position(latLng).title("Your hometown"));
            }
        });

        Polygon polygon = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(essen.latitude,essen.longitude), new LatLng(essen.latitude,essen.longitude+0.5), new LatLng(essen.latitude+0.5,essen.longitude+0.5),new LatLng(essen.latitude+0.5,essen.longitude), new LatLng(essen.latitude,essen.longitude))
                .strokeColor(Color.RED));
        polygon.setFillColor(0x7F00FF00);


        /*Polygon polyg*//*on2 = mMap.addPolygon(new PolygonOptions()
                .add(new LatLng(0, 0), new LatLng(0, 5), new LatLng(3, 5))
                .strokeColor(Color.RED)
                .fill*//*Color(Color.BLUE));*/



    }
}
