package com.example.harsh.fetch.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.harsh.fetch.R;
import com.example.harsh.fetch.model.itemModel;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.MyViewHolder>{
    private Context context;
    private List<itemModel> list_objects;

    public itemAdapter(Context context, List<itemModel> list_objects) {
        this.context = context;
        this.list_objects = list_objects;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull itemAdapter.MyViewHolder holder, int position) {
        itemModel object = list_objects.get(position);
        holder.tv_listID.setText(String.valueOf(object.getListId()));
        holder.tv_ID.setText(String.valueOf(object.getId()));
        holder.tv_name.setText(this.list_objects.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return list_objects.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv_listID, tv_ID, tv_name;
        public MyViewHolder(@NonNull View view) {
            super(view);
            tv_listID = view.findViewById(R.id.fetch_listid);
            tv_ID = view.findViewById(R.id.fetch_id);
            tv_name = view.findViewById(R.id.fetch_name);

        }
    }
}
