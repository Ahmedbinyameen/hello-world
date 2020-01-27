package com.example.bluecloudmedicalclinic.Tabbed_Activity;


import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.bluecloudmedicalclinic.R;
import com.google.android.material.tabs.TabLayout;


public class Dr_Alex_Tabbed_Activity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dr__alex__tabbed_);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout_dr_alex);
        viewPager = (ViewPager) findViewById(R.id.viewPager_dr_alex);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1 Dr Alex"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2 Dr Alex"));


        final  MyAdapter_Dr_Alex myAdapter_dr_alex = new MyAdapter_Dr_Alex(getSupportFragmentManager(), Dr_Alex_Tabbed_Activity.this, tabLayout.getTabCount());
        viewPager.setAdapter(myAdapter_dr_alex);
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
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dr__alex__tabbed_, menu);
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
            Toast.makeText(getApplicationContext(), "Close Clicked", Toast.LENGTH_LONG).show();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
//    public static class PlaceholderFragment extends Fragment {
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private static final String ARG_SECTION_NUMBER = "section_number";
//
//        public PlaceholderFragment() {
//        }
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        public static PlaceholderFragment newInstance(int sectionNumber) {
//            PlaceholderFragment fragment = new PlaceholderFragment();
//            Bundle args = new Bundle();
//            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
//            fragment.setArguments(args);
//            return fragment;
//        }
//
//        @Override
//        public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                 Bundle savedInstanceState) {
//            View rootView = inflater.inflate(R.layout.tab1_dr__alex, container, false);
//            TextView textView = (TextView) rootView.findViewById(R.id.action_settings);
//            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
//            return rootView;
//        }
//    }
//
//    /**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     */
//    private class SectionsPagerAdapter extends FragmentPagerAdapter {
//
//        SectionsPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            // getItem is called to instantiate the fragment for the given page.
//            // Return a PlaceholderFragment (defined as a static inner class below).
//            switch (position) {
//                case 0:
//                   tab1_dr_alex = new Tab1_dr_alex();
//                    return tab1_dr_alex;
//                case 1:
//                    tab2_dr_alex = new Tab2_dr_alex();
//                    return tab2_dr_alex;
//
//            }
//            return null;
//        }
//
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
