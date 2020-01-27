package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by HP on 1/1/2020.
 */

public class MyAdapter_Dr_Mistry extends FragmentPagerAdapter {

    Context context;
    int totalTabs;
    Tab1_dr_mistry tab1_dr_mistry;
    Tab2_dr_mistry tab2_dr_mistry;
    public MyAdapter_Dr_Mistry(FragmentManager fm, Context c, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
               tab1_dr_mistry = new Tab1_dr_mistry();
                return  tab1_dr_mistry;
            case 1:
                tab2_dr_mistry = new Tab2_dr_mistry();
                return  tab2_dr_mistry;
            default:
                return  null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
