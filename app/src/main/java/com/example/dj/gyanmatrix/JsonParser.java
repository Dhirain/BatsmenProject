package com.example.dj.gyanmatrix;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 11-03-2017.
 */

public class JsonParser {
    public static final String JSON_ARRAY = "records";

    List<BatsmenModel> getJsonObject(String response) throws JSONException {
        List<BatsmenModel> batsmen=new ArrayList<BatsmenModel>();
        JSONObject jsonObject=new JSONObject(response);
        JSONArray record=null;
        try {
            record=new JSONArray();
            record= (JSONArray) jsonObject.get(JSON_ARRAY);

            for (int i = 0; i<record.length(); i++)
            {
                JSONObject men = record.getJSONObject(i);
                BatsmenModel batsmenModel = new BatsmenModel(men);
                batsmen.add(batsmenModel);
            }

            Log.d("record",response);
            return batsmen;
        }catch (JSONException e)
        {
            e.printStackTrace();
        }
        return null;

    }
}
