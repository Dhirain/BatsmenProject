package com.example.dj.gyanmatrix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static final String JSON_URL = "http://hackerearth.0x10.info/api/gyanmatrix?type=json&query=list_player";
    NetworkManger networkManger;
    public List<BatsmenModel> mBatsmen;
    BastmenRecyclerAdapter mAdapter;

    RecyclerView mMainList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariables();
        getDataFromNetwork();
        initView();
    }

    private void initView() {
        mMainList=(RecyclerView) findViewById(R.id.batsmen_ll);
    }

    private void initVariables() {
        mBatsmen=new ArrayList<>();
        networkManger=new NetworkManger();
    }

    private void getDataFromNetwork() {

        NetworkManger.sendRequest(JSON_URL,getApplicationContext(), new NetworkManger.BatsmenManger() {
            @Override
            public void onRequestCompleted(List<BatsmenModel> batmenList) {
                mBatsmen=batmenList;
                Log.d("list",mBatsmen.toString());
                mAdapter=new BastmenRecyclerAdapter(getApplicationContext(),mBatsmen);
            }
        });
    }


}
