package com.example.dj.gyanmatrix;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DJ on 11-03-2017.
 */

public class BastmenRecyclerAdapter extends RecyclerView.Adapter<BastmenRecyclerAdapter.ViewHolder>  {
    Context mContext;
    List<BatsmenModel> mBatsmen;
    BatsmenModel mCurrentBatsman;

    public BastmenRecyclerAdapter(Context context,List<BatsmenModel> Batsmen) {
        this.mContext       =   context;
        this.mBatsmen       =   Batsmen;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.batsmen_list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if(mBatsmen!=null){
            mCurrentBatsman=mBatsmen.get(position);
            initCardViewWithCurrentItem(holder);
        }
    }

    private void initCardViewWithCurrentItem(final BastmenRecyclerAdapter.ViewHolder currentHolder)
    {

        if(null != mCurrentBatsman.mImageURL)
        {
            ImageUtils.setCircularImage(mContext,mCurrentBatsman.mImageURL,currentHolder.vBatsmenImage,R.drawable.icon_placeholder);
        }



    }//end initCardViewWithCurrentItem

    @Override
    public int getItemCount() {
        return mBatsmen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView vBatsmenImage,vStar,vArrow;
        public TextView vBatsmenName,uBatsmenCountry;

        public ViewHolder(View itemView) {
            super(itemView);
            vBatsmenImage=(ImageView)itemView.findViewById(R.id.user_profile_pic);
            vStar=(ImageView)itemView.findViewById(R.id.star);
            vArrow=(ImageView)itemView.findViewById(R.id.arrow);
            vBatsmenName=(TextView) itemView.findViewById(R.id.user_name);
            uBatsmenCountry=(TextView) itemView.findViewById(R.id.user_location);

        }
    }
}
