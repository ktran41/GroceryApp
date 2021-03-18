package com.example.groceryapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.groceryapp.fragments.BarcodeFragment;
import com.example.groceryapp.fragments.GroceryListFragment;
import com.example.groceryapp.fragments.InventoryFragment;
import com.example.groceryapp.fragments.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fragmentManager = getSupportFragmentManager();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = new InventoryFragment();
                switch (item.getItemId()) {
                    case R.id.action_scanner:
                        fragment = new BarcodeFragment();
                        Toast.makeText(MainActivity.this, "Scanner!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_groceryList:
                        fragment = new GroceryListFragment();
                        Toast.makeText(MainActivity.this, "List!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_inventory:
                        fragment = new InventoryFragment();
                        Toast.makeText(MainActivity.this, "Inventory!", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        fragment = new SettingsFragment();
                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }

        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_inventory);

    }
}