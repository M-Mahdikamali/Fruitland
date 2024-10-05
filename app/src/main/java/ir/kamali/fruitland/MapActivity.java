package ir.kamali.fruitland;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.single.PermissionListener;

import org.neshan.core.LngLat;
import org.neshan.core.Range;
import org.neshan.layers.VectorElementLayer;
import org.neshan.services.NeshanMapStyle;
import org.neshan.services.NeshanServices;
import org.neshan.styles.MarkerStyle;
import org.neshan.styles.MarkerStyleCreator;
import org.neshan.ui.ClickData;
import org.neshan.ui.ClickType;
import org.neshan.ui.MapEventListener;
import org.neshan.ui.MapView;
import org.neshan.utils.BitmapUtils;
import org.neshan.vectorelements.Marker;

import java.text.DateFormat;
import java.util.Date;


public class MapActivity extends AppCompatActivity {
    private MapView map;
    final int REQUEST_CODE = 123;
    private FusedLocationProviderClient fusedlocationproviderclient;
    private static final long UPDATE_INTERVAL_IN_MILLISECONDS = 1000;
    private static final long FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS = 1000;
    private Location userLocation;
    private FusedLocationProviderClient fusedLocationClient;
    private SettingsClient settingsClient;
    private LocationRequest locationRequest;
    private LocationCallback locationCallback;
    private String lastUpdateTime;
    private LocationSettingsRequest locationSettingsRequest;
    private Boolean mRequestingLocationUpdates;
    private final int BASE_MAP_INDEX = 0;
    private final int POI_INDEX = 1;
    VectorElementLayer markerLayer;
    ImageView image_co;
    ImageView information;
    TextView comment_info;
    TextView safheye_asli;
    ImageView next_page;
    private String lastname;
    private String firstname;
    private String Pass;
    private String Email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.mapactivity);

        lastname=getIntent().getStringExtra("lastname");
        firstname=getIntent().getStringExtra("firstname");
        Pass=getIntent().getStringExtra("pass");
        Email=getIntent().getStringExtra("email");

        information=findViewById(R.id.information1);
        image_co=findViewById(R.id.ImageCo);
        image_co.setVisibility(View.GONE);
        comment_info=findViewById(R.id.comment_information);
        comment_info.setVisibility(View.GONE);
        safheye_asli = findViewById(R.id.text_map);
        safheye_asli.setVisibility(View.GONE);
        next_page=findViewById(R.id.textNextmap);
        next_page.setVisibility(View.GONE);

    }

    @Override
    protected void onStart() {
        super.onStart();
        initLayoutReferences();
        initLocation();
        startReceivingLocationUpdates();
    }

    @Override
    protected void onResume() {
        super.onResume();
        startLocationUpdates();
        G.mCurrentActivity=this;
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopLocationUpdates();
    }

    private void initLocation() {
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        settingsClient = LocationServices.getSettingsClient(this);
        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                super.onLocationResult(locationResult);
                // location is received
                userLocation = locationResult.getLastLocation();
                lastUpdateTime = DateFormat.getTimeInstance().format(new Date());
                onLocationChange();
            }
        };
        mRequestingLocationUpdates = false;
        locationRequest = new LocationRequest();
        locationRequest.setInterval(UPDATE_INTERVAL_IN_MILLISECONDS);
        locationRequest.setFastestInterval(FASTEST_UPDATE_INTERVAL_IN_MILLISECONDS);
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder();
        builder.addLocationRequest(locationRequest);
        locationSettingsRequest = builder.build();
    }

    private void startLocationUpdates() {
        settingsClient
                .checkLocationSettings(locationSettingsRequest)
                .addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
                    @SuppressLint("MissingPermission")
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {

                        //noinspection MissingPermission
                        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper());

//                        onLocationChange();
                    }
                })
                .addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        int statusCode = ((ApiException) e).getStatusCode();
                        switch (statusCode) {
                            case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                                try {
                                    // Show the dialog by calling startResolutionForResult(), and check the
                                    // result in onActivityResult().
                                    ResolvableApiException rae = (ResolvableApiException) e;
                                    rae.startResolutionForResult(MapActivity.this, REQUEST_CODE);
                                } catch (IntentSender.SendIntentException sie) {
                                }
                                break;
                            case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                                String errorMessage = "Location settings are inadequate, and cannot be " +
                                        "fixed here. Fix in Settings.";

                                Toast.makeText(MapActivity.this, errorMessage, Toast.LENGTH_LONG).show();
                        }

//                        onLocationChange();
                    }
                });
    }

    public void stopLocationUpdates() {
        // Removing location updates
        fusedLocationClient
                .removeLocationUpdates(locationCallback)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                    }
                });
    }

    public void startReceivingLocationUpdates() {
        // Requesting ACCESS_FINE_LOCATION using Dexter library
        Dexter.withActivity(this)
                .withPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        mRequestingLocationUpdates = true;
                        startLocationUpdates();
                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        if (response.isPermanentlyDenied()) {
                            // open device settings when the permission is
                            // denied permanently
                            openSettings();
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(com.karumi.dexter.listener.PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }

                }).check();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            // Check for the integer request code originally supplied to startResolutionForResult().
            case REQUEST_CODE:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        break;
                    case Activity.RESULT_CANCELED:
                        mRequestingLocationUpdates = false;
                        break;
                }
                break;
        }
    }

    private void openSettings() {
        Intent intent = new Intent();
        intent.setAction(
                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",
                BuildConfig.APPLICATION_ID, null);
        intent.setData(uri);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void onLocationChange() {
        if (userLocation != null) {
            addUserMarker(new LngLat(userLocation.getLongitude(), userLocation.getLatitude()));
        }
    }

    private void addUserMarker(LngLat loc) {
        // Creating marker style. We should use an object of type MarkerStyleCreator, set all features on it
        // and then call buildStyle method on it. This method returns an object of type MarkerStyle
        final VectorElementLayer userMarkerLayer = NeshanServices.createVectorElementLayer();
        map.getLayers().add(userMarkerLayer);
        MarkerStyleCreator markStCr = new MarkerStyleCreator();
        markStCr.setSize(30f);
        markStCr.setBitmap(BitmapUtils.createBitmapFromAndroidBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_marker)));
        MarkerStyle markSt = markStCr.buildStyle();
        // Creating user marker
        Marker marker = new Marker(loc, markSt);
        userMarkerLayer.clear();
        // Clearing userMarkerLayer
        G.handler.post(new Runnable() {
            @Override
            public void run() {
                userMarkerLayer.removeAll(userMarkerLayer.getAll());
//                userMarkerLayer.delete();
            }
        });
        // Adding user marker to userMarkerLayer, or showing marker on map!
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        userMarkerLayer.add(marker);

    }

    public void focusOnUserLocation(View view) {
        if (userLocation != null) {
            map.setFocalPointPosition(
                    new LngLat(userLocation.getLongitude(), userLocation.getLatitude()), 0.25f);
            map.setZoom(15, 0.25f);
            safheye_asli.setVisibility(View.VISIBLE);
            next_page.setVisibility(View.VISIBLE);

        }
    }

    private void initLayoutReferences() {
        // Initializing views
        initViews();
        // Initializing mapView element
        initMap();
        // when long clicked on map, a marker is added in clicked location
        // MapEventListener gets all events on map, including single tap, double tap, long press, etc
        // we should check event type by calling getClickType() on mapClickInfo (from ClickData class)
        map.setMapEventListener(new MapEventListener(){
            @Override
            public void onMapClicked(ClickData mapClickInfo) {
                if (mapClickInfo.getClickType() == ClickType.CLICK_TYPE_LONG) {
                    // by calling getClickPos(), we can get position of clicking (or tapping)
                    LngLat clickedLocation = mapClickInfo.getClickPos();
                    // addMarker adds a marker (pretty self explanatory :D) to the clicked location
                    addUserMarker(clickedLocation);

                    G.handler.post(new Runnable() {
                        @Override
                        public void run() {
                            safheye_asli.setVisibility(View.VISIBLE);
                            next_page.setVisibility(View.VISIBLE);
                        }
                    });
                }
            }
            public void unMapClicked(ClickData mapClickInfoo){
                if (mapClickInfoo.getClickType()==ClickType.CLICK_TYPE_SINGLE){
                }
            }
        });
    }
    private void initViews(){
        map = findViewById(R.id.map);
    }
    protected void initMap() {
        markerLayer = NeshanServices.createVectorElementLayer();
        map.getLayers().add(markerLayer);

        // add Standard_day map to layer BASE_MAP_INDEX
        map.getOptions().setZoomRange(new Range(4.5f, 18f));
        map.getLayers().insert(BASE_MAP_INDEX, NeshanServices.createBaseMap(NeshanMapStyle.STANDARD_DAY));

        // Setting map focal position to a fixed position and setting camera zoom
        map.setFocalPointPosition(new LngLat(51.330743, 35.767234),0 );
        map.setZoom(15,0);

    }
//    private void addMarker(LngLat loc){
//        // First, we should clear every marker that is currently located on map
//        markerLayer.clear();
//
//        // Creating animation for marker. We should use an object of type AnimationStyleBuilder, set
//        // all animation features on it and then call buildStyle() method that returns an object of type
//        // AnimationStyle
//        AnimationStyleBuilder animStBl = new AnimationStyleBuilder();
//        animStBl.setFadeAnimationType(AnimationType.ANIMATION_TYPE_SMOOTHSTEP);
//        animStBl.setSizeAnimationType(AnimationType.ANIMATION_TYPE_SPRING);
//        animStBl.setPhaseInDuration(0.5f);
//        animStBl.setPhaseOutDuration(0.5f);
//        AnimationStyle animSt = animStBl.buildStyle();
//
//        // Creating marker style. We should use an object of type MarkerStyleCreator, set all features on it
//        // and then call buildStyle method on it. This method returns an object of type MarkerStyle
//        MarkerStyleCreator markStCr = new MarkerStyleCreator();
//        markStCr.setSize(30f);
//        markStCr.setBitmap(BitmapUtils.createBitmapFromAndroidBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.ic_marker)));
//        // AnimationStyle object - that was created before - is used here
//        markStCr.setAnimationStyle(animSt);
//        MarkerStyle markSt = markStCr.buildStyle();
//
//        // Creating marker
//        Marker marker = new Marker(loc, markSt);
//
//        // Adding marker to markerLayer, or showing marker on map!
//        markerLayer.add(marker);
//
//    }
    public void SelectionFVActivity(View view)
    {
        Intent intent=new Intent(this, Bottombar.class);
        intent.putExtra("lastname",lastname);
        intent.putExtra("pass",Pass);
        intent.putExtra("email",Email);
        intent.putExtra("firstname",firstname);
        startActivity(intent);
    }
    public void information(View v)
    {
        image_co.setVisibility(View.VISIBLE);
        comment_info.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable(){
            public void run() {
                image_co.setVisibility(View.GONE);
                comment_info.setVisibility(View.GONE);
            }
        }, 8000);
    }
}