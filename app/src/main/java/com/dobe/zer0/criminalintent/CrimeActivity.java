package com.dobe.zer0.criminalintent;

import android.support.v4.app.Fragment;

import com.dobe.zer0.activity.BaseFragmentActivity;
import com.dobe.zer0.fragment.CrimeFragment;

public class CrimeActivity extends BaseFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
