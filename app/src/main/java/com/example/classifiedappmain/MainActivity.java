package com.example.classifiedappmain;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
 import androidx.appcompat.widget.Toolbar;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.classifiedappmain.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    ActivityMainBinding binding;


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new HomeFragment());


        binding.bottomnavigationview.setOnItemSelectedListener(item -> {

            switch (item.getItemId()) {
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.fav:
                    replaceFragment(new FavouriteFragment());
                    break;
                case R.id.user:
                    replaceFragment(new UserFragment());
                    break;
            }

            return true;
        });

        mAuth=FirebaseAuth.getInstance();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigationView);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_Open,R.string.close_menu);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId()){
                    case R.id.nav_home:
                        replaceFragment(new HomeFragment());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_postbusiness:
                        replaceFragment(new fragment_postbusiness());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                    case R.id.nav_categories:
                        replaceFragment(new cataegoryFragments());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_aboutus:
                        replaceFragment(new fragment_aboutus());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_language:
                        replaceFragment(new fragment_language());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_logout:
                        logoutFunction();
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;
                    case R.id.nav_getSupport:
                        replaceFragment(new fragment_contactus());
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;




                }

                return true;
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }
    public void logoutFunction(){
        FirebaseAuth.getInstance().signOut();
        Toast.makeText(this, "logout successful", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this,login.class);
        startActivity(i);
        finish();
    }

}