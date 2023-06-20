package com.arman.tugassensor_2023_akb_if2_10120061;

// 10120061
// Achmad Juliarman - IF-2

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;



import com.arman.tugassensor_2023_akb_if2_10120061.adapter.AdapterViewPager;
import com.arman.tugassensor_2023_akb_if2_10120061.fragment.FragmentHome;
import com.arman.tugassensor_2023_akb_if2_10120061.fragment.FragmentInfo;
import com.arman.tugassensor_2023_akb_if2_10120061.fragment.FragmentLocation;
import com.arman.tugassensor_2023_akb_if2_10120061.fragment.FragmentMaps;
import com.arman.tugassensor_2023_akb_if2_10120061.fragment.FragmentMyLocation;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnv;
    ViewPager2 vp;
    ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = findViewById(R.id.view_pager);
        bnv = findViewById(R.id.b_nav);

        fragmentArrayList.add(new FragmentHome());
        fragmentArrayList.add(new FragmentMaps());
        fragmentArrayList.add(new FragmentMyLocation());
        fragmentArrayList.add(new FragmentInfo());

        AdapterViewPager adapterViewPager = new AdapterViewPager(this, fragmentArrayList);
        // set adapter 
        
        vp.setAdapter(adapterViewPager);
        vp.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                switch(position){
                    case 0:
                        bnv.setSelectedItemId(R.id.home);
                        break;
                    case 1:
                        bnv.setSelectedItemId(R.id.maps);
                        break;
                    case 2:
                        bnv.setSelectedItemId(R.id.location);
                        break;
                    case 3:
                        bnv.setSelectedItemId(R.id.info);
                        break;
                }
                super.onPageSelected(position);
            }
        });

        bnv.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int itemId = item.getItemId();
                if (itemId == R.id.home) {
                    vp.setCurrentItem(0);
                } else if (itemId == R.id.maps) {
                    vp.setCurrentItem(1);
                } else if (itemId == R.id.location) {
                    vp.setCurrentItem(2);
                } else if (itemId == R.id.info) {
                    vp.setCurrentItem(3);
                }
                return true;
            }
        });

    }

}