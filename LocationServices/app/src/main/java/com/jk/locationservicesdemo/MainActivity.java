package com.jk.locationservicesdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.model.LatLng;
import com.jk.locationservicesdemo.databinding.ActivityMainBinding;
import com.jk.locationservicesdemo.helpers.LocationHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = this.getClass().getCanonicalName();
    ActivityMainBinding binding;
    private LocationHelper locationHelper;
    private Location lastLocation;
    private LocationCallback locationCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());

        this.binding.btnReverseGeocoding.setOnClickListener(this::onClick);
        this.binding.btnOpenMap.setOnClickListener(this::onClick);

        this.locationHelper = LocationHelper.getInstance();
        this.locationHelper.checkPermissions(this);

//        this.lastLocation = this.locationHelper.getLastLocation(this);
//        if (this.lastLocation != null){
//            this.binding.tvLocationAddress.setText(this.lastLocation.toString());
//        }else{
//            this.binding.tvLocationAddress.setText("Last location not obtained");
//        }

        this.locationHelper.getLastLocation(this).observe(this, new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                if (location != null){
                    lastLocation = location;

                    Address obtainedAddress = locationHelper.performForwardGeocoding(getApplicationContext(), lastLocation);

                    if (obtainedAddress != null){
                        binding.tvLocationAddress.setText(obtainedAddress.getAddressLine(0));
                    }else{
                        binding.tvLocationAddress.setText(lastLocation.toString());
                    }
                }else{
                    binding.tvLocationAddress.setText("Last location not obtained");
                }
            }
        });

        this.initiateLocationListener();
    }

    @Override
    public void onClick(View v) {
        if (v != null){
            switch (v.getId()){
                case R.id.btn_open_map:{
                    this.openMap();
                    break;
                }
                case R.id.btn_reverse_geocoding:{
                    this.doReverseGeocoding();
                    break;
                }
            }
        }
    }

    private void openMap(){
        Log.d(TAG, "onClick: Open map to show location");

        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("EXTRA_LAT", this.lastLocation.getLatitude());
        intent.putExtra("EXTRA_LNG", this.lastLocation.getLongitude());
        startActivity(intent);
    }

    private void doReverseGeocoding(){
        Log.d(TAG, "onClick: Perform reverse geocoding to get coordinates from address.");

        if (this.locationHelper.locationPermissionGranted){
            String givenAddress = this.binding.editAddress.getText().toString();
            LatLng obtainedCoords = this.locationHelper.performReverseGeocoding(this, givenAddress);

            if (obtainedCoords != null){
                this.binding.tvLocationCoordinates.setText("Lat : " + obtainedCoords.latitude + "\nLng : " + obtainedCoords.longitude);
                this.lastLocation = new Location(obtainedCoords.toString());
//                        (obtainedCoords.latitude, obtainedCoords.longitude);
            }else{
                this.binding.tvLocationCoordinates.setText("No coordinates obtained");
            }
        }else{
            this.binding.tvLocationCoordinates.setText("Couldn't get coordinates from address");
        }
    }

    private void initiateLocationListener(){
        this.locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                for (Location loc : locationResult.getLocations()){
                    lastLocation = loc;

                    Log.e(TAG, "onLocationResult: updated location : " + lastLocation.toString() );

                    Address obtainedAddress = locationHelper.performForwardGeocoding(getApplicationContext(), lastLocation);

                    if (obtainedAddress != null){
                        binding.tvLocationAddress.setText(obtainedAddress.getAddressLine(0));
                    }else{
                        binding.tvLocationAddress.setText(lastLocation.toString());
                    }
                }
            }
        };

        this.locationHelper.getLocationUpdates(this, locationCallback);
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.locationHelper.stopLocationUpdates(this, this.locationCallback);
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.locationHelper.stopLocationUpdates(this, this.locationCallback);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.locationHelper.getLocationUpdates(this, this.locationCallback);
    }
}