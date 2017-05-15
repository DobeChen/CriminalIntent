package com.dobe.zer0.criminalintent;

import android.support.v4.app.Fragment;

import com.dobe.zer0.activity.BaseFragmentActivity;
import com.dobe.zer0.fragment.CrimeListFragment;

/**
 * Created by dobezer0 on 2017/5/15.
 */

public class CrimeListActivity extends BaseFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
