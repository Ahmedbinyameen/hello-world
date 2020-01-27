package com.example.bluecloudmedicalclinic.Tabbed_Activity;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


/**
 * Created by HP on 1/1/2020.
 */

public class MyAdapter_Dr_Spot extends FragmentPagerAdapter {
    Context context;
    int totalTabs;
    Tab1_dr_spot tab1_dr_spot;
    Tab2_dr_spot tab2_dr_spot;
    public MyAdapter_Dr_Spot(FragmentManager fm, Context c, int totalTabs) {
        super(fm);
        context = c;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
              tab1_dr_spot = new Tab1_dr_spot();
                return  tab1_dr_spot;
            case 1:
                tab2_dr_spot = new Tab2_dr_spot();
                return  tab2_dr_spot;
            default:
                return  null;

        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
