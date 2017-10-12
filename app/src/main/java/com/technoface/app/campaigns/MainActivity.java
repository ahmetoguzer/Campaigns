package com.technoface.app.campaigns;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.BottomNavigationView;
import android.support.design.internal.BottomNavigationMenuView;

import android.view.MenuItem;

import android.support.v7.widget.Toolbar;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.loader.fresco.FrescoImageLoader;
import com.github.piasy.biv.loader.glide.GlideImageLoader;
import com.technoface.app.campaigns.fragments.AnaMenuFragment;
import com.technoface.app.campaigns.fragments.Hesapfragment;
import com.technoface.app.campaigns.fragments.MontajlarFragment;
import com.technoface.app.campaigns.fragments.PuanlarFragment;

public class MainActivity extends AppCompatActivity {


    Boolean isOpenMontaj=false;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BigImageViewer.initialize(FrescoImageLoader.with(MainActivity.this));

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                selectedFragment = AnaMenuFragment.newInstance();
                                break;
                            case R.id.action_item2:
                                selectedFragment = PuanlarFragment.newInstance();
                                break;
                            case R.id.action_item3:
                                selectedFragment = MontajlarFragment.newInstance();
                                break;
                            case R.id.action_item4:
                                selectedFragment = Hesapfragment.newInstance();
                                break;
                        }

                        if(!isOpenMontaj){
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.frame_layout, selectedFragment);
                            transaction.commit();

                        }
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, AnaMenuFragment.newInstance());
        transaction.commit();

        BottomNavigationMenuView menuView = (BottomNavigationMenuView) bottomNavigationView.getChildAt(0);


//        final View iconView = menuView.getChildAt(2).findViewById(android.support.design.R.id.icon);
//            final ViewGroup.LayoutParams layoutParams = iconView.getLayoutParams();
//            final DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
//            layoutParams.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, displayMetrics);
//            layoutParams.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40, displayMetrics);
//            iconView.setLayoutParams(layoutParams);

    }
}
