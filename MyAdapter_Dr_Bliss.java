package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * Created by HP on 1/1/2020.
 */

public class MyAdapter_Dr_Bliss extends FragmentPagerAdapter {

    Context context;
    int totalTabs;
    Tab1_dr_bliss tab1_dr_bliss;
    Tab2_dr_bliss tab2_dr_bliss;

    public MyAdapter_Dr_Bliss(FragmentManager fm, Context c, int totalTabs) {
        super(fm);
        context =c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position)
        {
            case 0:
                tab1_dr_bliss = new Tab1_dr_bliss();
                return tab1_dr_bliss;
            case 1:
               tab2_dr_bliss = new Tab2_dr_bliss();
                return tab2_dr_bliss;
            default:
                return  null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
