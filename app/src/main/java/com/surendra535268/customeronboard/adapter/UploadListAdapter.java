package com.surendra535268.customeronboard.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.surendra535268.customeronboard.R;

import java.util.List;

/**
 * Created by DELL on 15-01-2016.
 */
public class UploadListAdapter extends RecyclerView.Adapter<UploadListAdapter.RecyclerViewHolders> {

    private List<String> itemList;
    private Context context;
    OnItemClickListener mItemClickListener;

    public UploadListAdapter(Context context, List<String> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.upload_list_row, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, final int position) {
        holder.uploadtxt.setText(itemList.get(position).toString());
        //holder.videoIcon.setImageResource(itemList.get(position).getVideoId());

        holder.deleteIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemList.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(View view , int position);
    }

    public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }

    public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView uploadtxt;
        public ImageView deleteIcon;

        public RecyclerViewHolders(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            uploadtxt = (TextView)itemView.findViewById(R.id.upload_file_name);
            deleteIcon = (ImageView)itemView.findViewById(R.id.delete_icon);
        }
        @Override
        public void onClick(View view) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(view, getAdapterPosition());
            }
        }
    }
}
