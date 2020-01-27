package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * Created by HP on 1/1/2020.
 */

public class MyAdapter_Dr_Rash extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    Tab1_dr_rash tab1_dr_rash;
    Tab2_dr_rash tab2_dr_rash;
    public MyAdapter_Dr_Rash(FragmentManager fm, Context c, int totalTabs) {

        super(fm);
        context = c;
        this.totalTabs = totalTabs;

    }


    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
               tab1_dr_rash = new Tab1_dr_rash();
                return  tab1_dr_rash;
            case 1:
               tab2_dr_rash = new Tab2_dr_rash();
                return  tab2_dr_rash;
            default:
                return  null;

        }
    }

    @Override
    public int getCount() {

        return totalTabs;
    }
}
