package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * Created by HP on 1/1/2020.
 */


public class MyAdapter_Dr_Hunter extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    Tab1_dr_hunter tab1_dr_hunter;
    Tab2_dr_hunter tab2_dr_hunter;

    MyAdapter_Dr_Hunter(FragmentManager fm, Context c, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
               tab1_dr_hunter = new Tab1_dr_hunter();
                return  tab1_dr_hunter;
            case 1:
               tab2_dr_hunter = new Tab2_dr_hunter();
                return  tab2_dr_hunter;
            default:
                return  null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
