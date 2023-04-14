package com.example.androidqimo234.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.androidqimo234.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView=findViewById(R.id.nav_view);
      appBarConfiguration=new AppBarConfiguration.Builder(
                R.id.navigation_home,R.id.navigation_chart,R.id.navigation_video,
                R.id.navigation_me).build();
         navController = Navigation.findNavController(this,
                 R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,
                appBarConfiguration);
        NavigationUI.setupWithNavController(navView,navController);
    }

    //Python导航返回控制

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration);
    }
}
