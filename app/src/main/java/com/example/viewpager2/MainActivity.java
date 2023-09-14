package com.example.viewpager2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    ViewPager2 viewPager;
    MyViewPagerAdapter viewPagerAdapter;
    TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);


        viewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(),
                getLifecycle());
        viewPagerAdapter.addFragment(new FragmentOne());
        viewPagerAdapter.addFragment(new FragmentTwo());
        viewPagerAdapter.addFragment(new FragmentThree());
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(viewPagerAdapter);

        new TabLayoutMediator(tabLayout,
                viewPager,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        tab.setText("Fragment " + (position+1));
                    }
                }).attach();
    }
}