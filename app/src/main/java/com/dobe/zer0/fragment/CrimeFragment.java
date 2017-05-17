package com.dobe.zer0.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.dobe.zer0.criminalintent.R;
import com.dobe.zer0.entity.Crime;
import com.dobe.zer0.entity.CrimeLab;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnTextChanged;

/**
 * Created by dobezer0 on 2017/5/10.
 */

public class CrimeFragment extends Fragment {
    private static final String CRIME_ID = "crime_id";

    private Crime mCrime;

    @BindView(R.id.crime_title)EditText mTextTitle;
    @BindView(R.id.date_button)Button mDateButton;
    @BindView(R.id.crime_solved)CheckBox mSolvedBox;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //get a Crime instance
//        UUID crimeId = (UUID) getActivity().getIntent().getSerializableExtra(CrimeActivity.CRIME_ID);
        UUID crimeId = (UUID) getArguments().getSerializable(CRIME_ID);
        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_crime, container, false);

        ButterKnife.bind(this, view);

        //init Date Button and pros
        Date currentDate = mCrime.getDate();
        DateFormat format = DateFormat.getDateInstance(DateFormat.FULL, Locale.CHINA);
        mDateButton.setText(format.format(currentDate));
        mDateButton.setEnabled(false);

        //init Title and Solved data
        mTextTitle.setText(mCrime.getTitle());
        mSolvedBox.setChecked(mCrime.isSolved());

        return view;
    }

    public static CrimeFragment newInstance(UUID crimeId){
        //bind data to CrimeFragment
        Bundle args = new Bundle();
        args.putSerializable(CRIME_ID, crimeId);

        //get a CrimeFragment instance
        CrimeFragment crimeFragment = new CrimeFragment();
        crimeFragment.setArguments(args);

        return crimeFragment;
    }

    @OnTextChanged(value = R.id.crime_title, callback = OnTextChanged.Callback.BEFORE_TEXT_CHANGED)
    void beforeTextChanged(CharSequence s, int start, int count, int after){

    }

    @OnTextChanged(value = R.id.crime_title, callback = OnTextChanged.Callback.TEXT_CHANGED)
    void onTextChanged(CharSequence s, int start, int before, int count) {
        mCrime.setTitle(s.toString());
    }

    @OnTextChanged(value = R.id.crime_title, callback = OnTextChanged.Callback.AFTER_TEXT_CHANGED)
    void afterTextChanged(Editable s) {

    }

    @OnCheckedChanged(R.id.crime_solved)
    void onCheckChanged(CompoundButton buttonView, boolean isChecked){
        mCrime.setSolved(isChecked);
    }
}
