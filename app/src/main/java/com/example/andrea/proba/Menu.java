package com.example.andrea.proba;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.example.andrea.proba.Fragments.ChangeLanguageFragment;
import com.example.andrea.proba.Fragments.Location10Fragment;
import com.example.andrea.proba.Fragments.Location11Fragment;
import com.example.andrea.proba.Fragments.Location12Fragment;
import com.example.andrea.proba.Fragments.Location13Fragment;
import com.example.andrea.proba.Fragments.Location14Fragment;
import com.example.andrea.proba.Fragments.Location15Fragment;
import com.example.andrea.proba.Fragments.Location16Fragment;
import com.example.andrea.proba.Fragments.Location17Fragment;
import com.example.andrea.proba.Fragments.Location18Fragment;
import com.example.andrea.proba.Fragments.Location19Fragment;
import com.example.andrea.proba.Fragments.Location3Fragment;
import com.example.andrea.proba.Fragments.Location4Fragment;
import com.example.andrea.proba.Fragments.Location5Fragment;
import com.example.andrea.proba.Fragments.Location6Fragment;
import com.example.andrea.proba.Fragments.Location7Fragment;
import com.example.andrea.proba.Fragments.Location8Fragment;
import com.example.andrea.proba.Fragments.Location9Fragment;
import com.example.andrea.proba.Fragments.LocationOneFragment;
import com.example.andrea.proba.Fragments.LocationTwoFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Menu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,OnMapReadyCallback {
    SupportMapFragment sMapFragment;
    GoogleMap mMap;
    FragmentManager sFM;
    ImageButton menuBtn;
    android.support.v4.app.Fragment fragmentLoc1;
    android.support.v4.app.Fragment fragmentLoc2;
    android.support.v4.app.Fragment fragmentLoc3;
    android.support.v4.app.Fragment fragmentLoc4;
    android.support.v4.app.Fragment fragmentLoc5;
    android.support.v4.app.Fragment fragmentLoc6;
    android.support.v4.app.Fragment fragmentLoc7;
    android.support.v4.app.Fragment fragmentLoc8;
    android.support.v4.app.Fragment fragmentLoc9;
    android.support.v4.app.Fragment fragmentLoc10;
    android.support.v4.app.Fragment fragmentLoc11;
    android.support.v4.app.Fragment fragmentLoc12;
    android.support.v4.app.Fragment fragmentLoc13;
    android.support.v4.app.Fragment fragmentLoc14;
    android.support.v4.app.Fragment fragmentLoc15;
    android.support.v4.app.Fragment fragmentLoc16;
    android.support.v4.app.Fragment fragmentLoc17;
    android.support.v4.app.Fragment fragmentLoc18;
    android.support.v4.app.Fragment fragmentLoc19;
    android.support.v4.app.Fragment changeLanFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        fragmentLoc1 = new LocationOneFragment();
        fragmentLoc2 = new LocationTwoFragment();
        fragmentLoc3 = new Location3Fragment();
        fragmentLoc4 = new Location4Fragment();
        fragmentLoc5 = new Location5Fragment();
        fragmentLoc6 = new Location6Fragment();
        fragmentLoc7 = new Location7Fragment();
        fragmentLoc8 = new Location8Fragment();
        fragmentLoc9 = new Location9Fragment();
        fragmentLoc10 = new Location10Fragment();
        fragmentLoc11 = new Location11Fragment();
        fragmentLoc12 = new Location12Fragment();
        fragmentLoc13 = new Location13Fragment();
        fragmentLoc14 = new Location14Fragment();
        fragmentLoc15 = new Location15Fragment();
        fragmentLoc16 = new Location16Fragment();
        fragmentLoc17 = new Location17Fragment();
        fragmentLoc18 = new Location18Fragment();
        fragmentLoc19 = new Location19Fragment();
        changeLanFragment = new ChangeLanguageFragment();


        sMapFragment = SupportMapFragment.newInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, sMapFragment);
        ft.commit();
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        menuBtn = (ImageButton) findViewById(R.id.btnDrawer);
        menuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(Gravity.LEFT);
            }
        });


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        sMapFragment.getMapAsync(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, (android.view.Menu) menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        sFM = getSupportFragmentManager();

        if(sMapFragment.isAdded())
            sFM.beginTransaction().hide(sMapFragment).commit();
        if(id == R.id.changeLanguage)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, changeLanFragment);
            ft.commit();
        }
        else if (id == R.id.location_1)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc1);
            ft.commit();

        }
        else if (id == R.id.location_2)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc2);
            ft.commit();
        }
        else if (id == R.id.location_3)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc3);
            ft.commit();
        }
        else if (id == R.id.location_4)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc4);
            ft.commit();
        }
        else if (id == R.id.location_5)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc5);
            ft.commit();

        }
        else if (id == R.id.location_6)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc6);
            ft.commit();

        }
        else if (id == R.id.location_7)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc7);
            ft.commit();

        }
        else if (id == R.id.location_8)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc8);
            ft.commit();

        }
        else if (id == R.id.location_9)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc9);
            ft.commit();

        }
        else if (id == R.id.location_10)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc10);
            ft.commit();

        }
        else if (id == R.id.location_11)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc11);
            ft.commit();

        }
        else if (id == R.id.location_12)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc12);
            ft.commit();

        }
        else if (id == R.id.location_13)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc13);
            ft.commit();

        }
        else if (id == R.id.location_14)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc14);
            ft.commit();

        }
        else if (id == R.id.location_15)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc15);
            ft.commit();

        }
        else if (id == R.id.location_16)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc16);
            ft.commit();

        }
        else if (id == R.id.location_17)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc17);
            ft.commit();

        }
        else if (id == R.id.location_18)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc18);
            ft.commit();

        }
        else if (id == R.id.location_19)
        {
            if(sMapFragment.isAdded())
                sFM.beginTransaction().hide(sMapFragment).commit();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragmentLoc19);
            ft.commit();

        }
        else if (id == R.id.google_map)
        {
            if(changeLanFragment.isAdded())
                sFM.beginTransaction().hide(changeLanFragment).commit();
            else if(fragmentLoc1.isAdded())
                sFM.beginTransaction().hide(fragmentLoc1).commit();
            else if(fragmentLoc2.isAdded())
                sFM.beginTransaction().hide(fragmentLoc2).commit();
            else if(fragmentLoc3.isAdded())
                sFM.beginTransaction().hide(fragmentLoc3).commit();
            else if(fragmentLoc4.isAdded())
                sFM.beginTransaction().hide(fragmentLoc4).commit();
            else if(fragmentLoc5.isAdded())
                sFM.beginTransaction().hide(fragmentLoc5).commit();
            else if(fragmentLoc6.isAdded())
                sFM.beginTransaction().hide(fragmentLoc6).commit();
            else if(fragmentLoc7.isAdded())
                sFM.beginTransaction().hide(fragmentLoc7).commit();
            else if(fragmentLoc8.isAdded())
                sFM.beginTransaction().hide(fragmentLoc8).commit();
            else if(fragmentLoc9.isAdded())
                sFM.beginTransaction().hide(fragmentLoc9).commit();
            else if(fragmentLoc10.isAdded())
                sFM.beginTransaction().hide(fragmentLoc10).commit();
            else if(fragmentLoc11.isAdded())
                sFM.beginTransaction().hide(fragmentLoc11).commit();
            else if(fragmentLoc12.isAdded())
                sFM.beginTransaction().hide(fragmentLoc12).commit();
            else if(fragmentLoc13.isAdded())
                sFM.beginTransaction().hide(fragmentLoc13).commit();
            else if(fragmentLoc14.isAdded())
                sFM.beginTransaction().hide(fragmentLoc14).commit();
            else if(fragmentLoc15.isAdded())
                sFM.beginTransaction().hide(fragmentLoc15).commit();
            else if(fragmentLoc16.isAdded())
                sFM.beginTransaction().hide(fragmentLoc16).commit();
            else if(fragmentLoc17.isAdded())
                sFM.beginTransaction().hide(fragmentLoc17).commit();
            else if(fragmentLoc18.isAdded())
                sFM.beginTransaction().hide(fragmentLoc18).commit();
            else if(fragmentLoc19.isAdded())
                sFM.beginTransaction().hide(fragmentLoc19).commit();
            if (!sMapFragment.isAdded()) {
                {
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.content_frame,sMapFragment);
                    ft.commit();
                    sMapFragment.getMapAsync(this);
                }
//                sFM.beginTransaction().add(R.id.map, sMapFragment).commit();
            }
            else if(sMapFragment.isAdded())
            {
                /*FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.content_frame,sMapFragment);
                ft.commit();
                sMapFragment.getMapAsync(this);*/
                sFM.beginTransaction().show(sMapFragment).commit();
                sMapFragment.getMapAsync(this);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        final Marker m1 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.112406,20.790928))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_1m1)));

        final Marker marker2 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 41.115026,20.794766))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_1m2)));

        final Marker marker3 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.114851,20.791027))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m3)));

        final Marker marker4 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.114369,20.795098))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m4)));

        final Marker marker5 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 41.114154,20.795518))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m5)));

        final Marker marker6 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.113949,20.796250))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m6)));

        final Marker marker7 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.113558,20.796705))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m7)));

        final Marker marker8 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(  41.112539,  20.796875))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m8)));

        final Marker marker9 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.112226,  20.797293))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m9)));

        final Marker marker10 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.112181,20.797474))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m10)));

        final Marker marker11 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.112076,20.794189))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m11)));

        final Marker marker12 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 41.111101,20.789318))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m12)));

        final Marker marker13 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.139034,20.836167))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m13)));

        final Marker marker14 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 41.082848, 20.828286))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m14)));

        final Marker marker15 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(41.001087,20.803470))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m15)));

        final Marker marker16 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.948865,20.774643))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m16)));

        final Marker marker17 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng(40.913986,20.740982))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m17)));

        final Marker marker18 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 41.144569,20.650064))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_m18)));

        final Marker marker19 = mMap.addMarker(new MarkerOptions()
                .position(new LatLng( 41.104558,20.631910))
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.rsz_1num_19)));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(m1.getPosition(),10));
       mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
           @Override
           public boolean onMarkerClick(Marker marker) {
               if(marker.equals(m1))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc1 = new LocationOneFragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.add(R.id.map, fragmentLoc1);
                   ft.commit();
               }
               else if(marker.equals(marker2))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc2 = new LocationTwoFragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc2);
                   ft.commit();
               }
               else if(marker.equals(marker3))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc3 = new Location3Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc3);
                   ft.commit();
               }
               else if(marker.equals(marker4))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc4 = new Location4Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc4);
                   ft.commit();
               }
               else if(marker.equals(marker5))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc5 = new Location5Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc5);
                   ft.commit();
               } else if(marker.equals(marker6))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc6 = new Location6Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc6);
                   ft.commit();
               } else if(marker.equals(marker7))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc7 = new Location7Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc7);
                   ft.commit();
               } else if(marker.equals(marker8))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc8 = new Location8Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc8);
                   ft.commit();
               } else if(marker.equals(marker9))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc9 = new Location9Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc9);
                   ft.commit();
               } else if(marker.equals(marker10))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc10 = new Location10Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc10);
                   ft.commit();
               } else if(marker.equals(marker11))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc11 = new Location11Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc11);
                   ft.commit();
               } else if(marker.equals(marker12))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc12 = new Location12Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc12);
                   ft.commit();
               } else if(marker.equals(marker13))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc13 = new Location13Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc13);
                   ft.commit();
               } else if(marker.equals(marker14))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc14 = new Location14Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc14);
                   ft.commit();
               } else if(marker.equals(marker15))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc15 = new Location15Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc15);
                   ft.commit();
               } else if(marker.equals(marker16))
               {
                   if(sMapFragment.isVisible())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc16 = new Location16Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc16);
                   ft.commit();
               } else if(marker.equals(marker17))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc17 = new Location17Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc17);
                   ft.commit();
               } else if(marker.equals(marker18))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc18 = new Location18Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc18);
                   ft.commit();
               }
               else if(marker.equals(marker19))
               {
                   if(sMapFragment.isAdded())
                       sFM.beginTransaction().hide(sMapFragment).commit();
                   fragmentLoc19 = new Location19Fragment();
                   FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                   ft.replace(R.id.content_frame, fragmentLoc19);
                   ft.commit();
               }

               return true;
           }
       });
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            super.setContentView(R.layout.activity_menu);
        }
        else if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            super.setContentView(R.layout.activity_menu);
        }
    }
}

