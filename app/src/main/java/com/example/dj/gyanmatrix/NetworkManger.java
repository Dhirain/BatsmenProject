package com.example.dj.gyanmatrix;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DJ on 11-03-2017.
 */

public class NetworkManger {


    public interface  BatsmenManger
    {
        public void onRequestCompleted(List<BatsmenModel> batmenList);
    }

    public static void sendRequest(String JSON_URL, final Context context, BatsmenManger batsmenManger){
        final BatsmenManger _baBatsmenManger=batsmenManger;
        StringRequest stringRequest = new StringRequest(JSON_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                List<BatsmenModel> mBatsmen=new ArrayList<>();
                Log.d("record",response);
                JsonParser jsonParser=new JsonParser();
                try {

                    mBatsmen=jsonParser.getJsonObject(response);
                    _baBatsmenManger.onRequestCompleted(mBatsmen);
                    Log.d("record",mBatsmen.toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(context.getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        requestQueue.add(stringRequest);
    }
}
