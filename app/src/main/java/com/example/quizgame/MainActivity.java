package com.example.quizgame;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.quizgame.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, new HomeFragment());
        transaction.commit();

        binding.bottomNav.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                if (id == R.id.home_nav) {
                    transaction.replace(R.id.content, new HomeFragment());
                    transaction.commit();
                }
                else if (id == R.id.profile_nav) {
                    transaction.replace(R.id.content, new ProfileFragment());
                    transaction.commit();
                }
                else if (id == R.id.wallet_nav) {
                    transaction.replace(R.id.content, new WalletFragment());
                    transaction.commit();
                }
                else if (id == R.id.rank_nav){
                    transaction.replace(R.id.content, new LeaderboardsFragment());
                    transaction.commit();

                }
                return true;
            }
        });
    }

}