package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bluecloudmedicalclinic.R;
import com.google.android.material.tabs.TabLayout;

public class Dr_Bliss_Tabbed_Activity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr__bliss__tabbed_);


        tabLayout = (TabLayout) findViewById(R.id.tabLayout_dr_bliss);
        viewPager = (ViewPager) findViewById(R.id.viewPager_dr_bliss);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1 Dr Bliss"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2 Dr Bliss"));


        final MyAdapter_Dr_Bliss myAdapter_dr_bliss = new MyAdapter_Dr_Bliss(getSupportFragmentManager(), Dr_Bliss_Tabbed_Activity.this, tabLayout.getTabCount());
        viewPager.setAdapter(myAdapter_dr_bliss);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });




//        try {
//
//        }
//        catch (NullPointerException ignored)
//        {
//
//        }
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        // Create the adapter that will return a fragment for each of the three
//        // primary sections of the activity.
//        /*
//      The {@link android.support.v4.view.PagerAdapter} that will provide
//      fragments for each of the sections. We use a
//      {@link FragmentPagerAdapter} derivative, which will keep every
//      loaded fragment in memory. If this becomes too memory intensive, it
//      may be best to switch to a
//      {@link android.support.v4.app.FragmentStatePagerAdapter}.
//     */
//        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
//
//        // Set up the ViewPager with the sections adapter.
//        /*
//      The {@link ViewPager} that will host the section contents.
//     */
//        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
//        mViewPager.setAdapter(mSectionsPagerAdapter);
//
//
////        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
////        fab.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
////                        .setAction("Action", null).show();
////            }
////        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dr__bliss__tabbed_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_settings:
                Toast.makeText(getApplicationContext(), "Close Clicked", Toast.LENGTH_LONG).show();
//                Intent Tabbed_Screen = new Intent(Dr_Bliss_Tabbed_Activity.this, Dr_Bliss_Tabbed_Activity.class);
//                startActivity(Tabbed_Screen);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }



//
//    private class SectionsPagerAdapter extends FragmentPagerAdapter
//    {
//
//        private   SectionsPagerAdapter(FragmentManager fm)
//        {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//
////            if (position == 0)
////            {
////                Tab1_dr_bliss tab1_dr_bliss = new Tab1_dr_bliss();
////                return tab1_dr_bliss;
////            }
////
////            else if (position == 2)
////            {
////                Tab2_dr_bliss tab2_dr_bliss = new Tab2_dr_bliss();
////                return tab2_dr_bliss;
////            }
//
//            switch (position) {
//                case 0:
//                   tab1_dr_bliss = new Tab1_dr_bliss();
//                    return tab1_dr_bliss;
//                case 1:
//                    tab2_dr_bliss = new Tab2_dr_bliss();
//                    return tab2_dr_bliss;
//                default:
//                    return null;
//            }
//
//
//        }
//
//        @Override
//        public int getCount() {
//            // Show 3 total pages.
//            return 3;
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            switch (position) {
//                case 0:
//                    return "SECTION 1";
//                case 1:
//                    return "SECTION 2";
//                case 2:
//                    return "SECTION 3";
//            }
//            return null;
//        }
//    }
}
