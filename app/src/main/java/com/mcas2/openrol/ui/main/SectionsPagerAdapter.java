package com.mcas2.openrol.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.mcas2.openrol.DnDCharClasses.DnDCharacter;
import com.mcas2.openrol.DnDCharFragments.DnDCharFragment1;
import com.mcas2.openrol.DnDCharFragments.DnDCharFragment2;
import com.mcas2.openrol.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
    // character we are building
    private DnDCharacter character;

    @StringRes
    private static final int[] TAB_TITLES = new int[]{
            R.string.tab_text_1,
            R.string.tab_text_2
    };

    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm, DnDCharacter character) {
        super(fm);
        mContext = context;
        this.character = character;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position){
            case 0:
                fragment = new DnDCharFragment1(character);
                return fragment;
            case 1:
                fragment = new DnDCharFragment2(character);
                return fragment;
        }
        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}