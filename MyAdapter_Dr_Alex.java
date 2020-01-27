package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by HP on 1/1/2020.
 */

public class MyAdapter_Dr_Alex extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    Tab1_dr_alex tab1_dr_alex;
    Tab2_dr_alex tab2_dr_alex;

    public MyAdapter_Dr_Alex(FragmentManager fm, Context c, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                tab1_dr_alex = new Tab1_dr_alex();
                return  tab1_dr_alex;
            case 1:
                tab2_dr_alex = new Tab2_dr_alex();
                return tab2_dr_alex;
            default:
                return  null;

        }
    }


    @Override
    public int getCount() {
        return totalTabs;
    }
}
