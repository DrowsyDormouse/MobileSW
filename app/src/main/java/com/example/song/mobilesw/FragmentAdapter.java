package com.example.song.mobilesw;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Song on 2017-10-25.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    /*
    public Fragment getPosition(MenuItem item)
    {
        int itmeId = item.getItemId();
        int position;

        switch (itmeId)
        {
            case R.id.nav_profile:
                position = 0;
                return getItem(position);
            case R.id.nav_timeline:
                position = 1;
                return getItem(position);
            case R.id.nav_info:
                position = 2;
                return getItem(position);
        }
        return null;
    }
    */

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Profile();
            case 1:
                return new Timeline();
            case 2:
                return new Profile();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            //
            //  탭 이름
            //
            case 0:return "Profile";
            case 1:return "Timeline";
            case 2: return "Info";
            default:return null;
        }
    }
}