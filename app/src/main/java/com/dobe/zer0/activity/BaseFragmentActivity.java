package com.dobe.zer0.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import com.dobe.zer0.criminalintent.R;
import com.dobe.zer0.fragment.CrimeFragment;

public abstract class BaseFragmentActivity extends FragmentActivity {
    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        Log.d(">>>> FragmentActivity: ", this.getClass().toString());

//        FragmentManager fm = getFragmentManager();
        FragmentManager fm = getSupportFragmentManager();

        //get Fragment by id
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = createFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }
    }
}
