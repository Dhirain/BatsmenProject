package com.example.dj.gyanmatrix;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by DJ on 11-03-2017.
 */

public class BatsmenModel implements Serializable {
    public final int        mId;
    public final String     mName;
    public final String     mImageURL;
    public final int        mTotalScore;
    public final String     mDescription;
    public final int        mMatchPlayed;
    public final String     mCountry;

    public BatsmenModel(JSONObject batsmen) throws JSONException
    {
        mId=batsmen.getInt("id");
        mName=batsmen.optString("name");
        mImageURL=batsmen.optString("image");
        mTotalScore=batsmen.optInt("total_score");
        mDescription=batsmen.optString("description");
        mMatchPlayed=batsmen.optInt("matches_played");
        mCountry=batsmen.optString("country");
    }

}
