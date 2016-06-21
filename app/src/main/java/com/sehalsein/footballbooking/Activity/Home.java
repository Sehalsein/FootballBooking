package com.sehalsein.footballbooking.Activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.sehalsein.footballbooking.Fragments.GroundList;
import com.sehalsein.footballbooking.Fragments.Profile;
import com.sehalsein.footballbooking.R;

public class Home extends AppCompatActivity {

    private BottomBar mBottomBar;
    private FragmentManager manager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        manager = getSupportFragmentManager();

        mBottomBar = BottomBar.attach(this, savedInstanceState);
        mBottomBar.setItems(R.menu.bottombar_menu);
        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {
                switch (menuItemId) {
                    case R.id.bottomBarItemOne:
                        toolbar.setTitle("Ground List");
                        Toast.makeText(Home.this, "BUTTON 1 SELECTED", Toast.LENGTH_SHORT).show();
                        FragmentTransaction transaction = manager.beginTransaction();
                        GroundList groundList = new GroundList();
                        transaction.replace(R.id.blankFragment, groundList, "GROUNDLIST");
                        //transaction.addToBackStack(null);
                        transaction.commit();
                        break;
                    case R.id.bottomBarItemTwo:
                        toolbar.setTitle("Profile");
                        Toast.makeText(Home.this, "BUTTON 2 SELECTED", Toast.LENGTH_SHORT).show();
                        FragmentTransaction profileTransaction = manager.beginTransaction();
                        Profile profile = new Profile();
                        profileTransaction.replace(R.id.blankFragment, profile, "PROFILE");
                        //profileTransaction.addToBackStack(null);
                        profileTransaction.commit();
                        break;
                    /*case R.id.bottomBarItemThree:
                        Toast.makeText(Home.this, "BUTTON 3 RESELECTED", Toast.LENGTH_SHORT).show();
                        break;*/
                }
            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                // The user reselected item number one, scroll your content to top.
                switch (menuItemId) {
                    case R.id.bottomBarItemOne:
                        Toast.makeText(Home.this, "BUTTON 1 RESELECTED", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.bottomBarItemTwo:
                        Toast.makeText(Home.this, "BUTTON 2 RESELECTED", Toast.LENGTH_SHORT).show();
                        break;
                    /*case R.id.bottomBarItemThree:
                        Toast.makeText(Home.this, "BUTTON 3 RESELECTED", Toast.LENGTH_SHORT).show();
                        break;*/
                }
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, "#44ff55");
        // mBottomBar.mapColorForTab(2, "#7B1FA2");

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }


}
