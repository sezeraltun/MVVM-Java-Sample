package com.mvvmsample.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.mvvmsample.R;
import com.mvvmsample.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.UserViewHolder> {

    private List<UserModel> dataList = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context con, List<UserModel> data ){
        this.mContext=con;
        this.dataList=data;
    }

    @NonNull
    @Override
    public RecyclerAdapter.UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_user_item, parent, false);

        return new UserViewHolder(view);
    }
    public class UserViewHolder extends RecyclerView.ViewHolder  {

        TextView textId;
        TextView textAge;
        TextView textName;


        UserViewHolder(@NonNull View view) {
            super(view);
            textId=view.findViewById(R.id.textId);
            textName=view.findViewById(R.id.textName);
            textAge=view.findViewById(R.id.textAge);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
            holder.textId.setText(dataList.get(position).getId());
            holder.textName.setText(dataList.get(position).getName());
            holder.textAge.setText(""+dataList.get(position).getAge());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
