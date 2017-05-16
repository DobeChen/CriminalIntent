package com.dobe.zer0.entity;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by dobezer0 on 2017/5/15.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;

    private List<Crime> mCrimes;

    private CrimeLab(Context context){
        mCrimes = new ArrayList<Crime>();

        //init Crime List
        for(int i=0; i<100; i++){
            Crime crime = new Crime();

            crime.setTitle("Crime Title " + i);
            crime.setSolved(i%2 == 0);

            mCrimes.add(crime);
        }
    }

    public static CrimeLab get(Context context){
        if(sCrimeLab == null){
            sCrimeLab = new CrimeLab(context);
        }

        return sCrimeLab;
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes) {
            if((crime != null) && (id.equals(crime.getId()))){
                return crime;
            }
        }

        return null;
    }
}
