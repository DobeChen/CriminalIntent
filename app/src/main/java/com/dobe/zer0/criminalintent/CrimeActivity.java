package com.dobe.zer0.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.dobe.zer0.activity.BaseFragmentActivity;
import com.dobe.zer0.fragment.CrimeFragment;

import java.util.UUID;

public class CrimeActivity extends BaseFragmentActivity {
    private static final String CRIME_ID = "com.dobe.zer0.entity.crime_id";

    @Override
    protected Fragment createFragment() {
        CrimeFragment crimeFragment = CrimeFragment.newInstance((UUID) this.getIntent().getSerializableExtra(CRIME_ID));

        return crimeFragment;
    }

    public static Intent newIntent(Context context, UUID crimeId) {
        Intent intent = new Intent(context, CrimeActivity.class);
        intent.putExtra(CRIME_ID, crimeId);

        return intent;
    }
}
