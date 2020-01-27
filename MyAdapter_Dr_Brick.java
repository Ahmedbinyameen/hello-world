package com.example.bluecloudmedicalclinic.Tabbed_Activity;


import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * Created by HP on 1/1/2020.
 */

public class MyAdapter_Dr_Brick extends FragmentPagerAdapter {

    Context context;
    int totalTabs;
    Tab1_dr_brick tab1_dr_brick;
    Tab2_dr_brick tab2_dr_brick;

    public MyAdapter_Dr_Brick(FragmentManager fm, Context c, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                tab1_dr_brick = new Tab1_dr_brick();
                return  tab1_dr_brick;
            case 1:
                tab2_dr_brick = new Tab2_dr_brick();
                return  tab2_dr_brick;
            default:
                return  null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
