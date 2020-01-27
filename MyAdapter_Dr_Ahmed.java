package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by HP on 1/1/2020.
 */

public class MyAdapter_Dr_Ahmed extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    Tab1_dr_ahmed tab1_dr_ahmed;
    Tab2_dr_ahmed tab2_dr_ahmed;


    MyAdapter_Dr_Ahmed(FragmentManager fm, Context c, int total_Tabs) {
        super(fm);
        context = c;
        this.totalTabs = total_Tabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                 tab1_dr_ahmed = new Tab1_dr_ahmed();
                return  tab1_dr_ahmed;
            case 1:
                tab2_dr_ahmed = new Tab2_dr_ahmed();
                return tab2_dr_ahmed;
            default:
                return  null;

        }

    }

    @Override
    public int getCount()
    {
        return totalTabs;
    }
}
