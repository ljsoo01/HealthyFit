package com.example.healthyfit;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class exAdapter2 extends RecyclerView.Adapter<exAdapter2.ViewHolder> {
    private ArrayList<exItem> mList;
    ImageView imageView;
    private Intent intent;
    //private Activity context= null;


/*    public exAdapter(Activity context, ArrayList<exItem> list){
        this.context = context;
        this.mList = list;
    }

    class exViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;

        public exViewHolder(View view) {
            super(view);
            this.name = (TextView)view.findViewById(R.id.list_text);
        }
    }*/

    @NonNull
    @Override
    public exAdapter2.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.liv2, parent, false);
        //ViewHolder viewHolder = new exViewHolder(view);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull exAdapter2.ViewHolder holder, int position) {
        holder.exImg.setImageResource(mList.get(position).getResourceId());
        holder.name.setText(mList.get(position).getName());

        holder.exImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(view.getContext(), detail_list2.class);
                intent.putExtra("number", position);
                intent.putExtra("name", mList.get(position).getName());
                intent.putExtra("exImg", mList.get(position).getResourceId());
                view.getContext().startActivity(intent);
            }
        });
    }

    public void setmList(ArrayList<exItem> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView exImg;
        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            exImg = itemView.findViewById(R.id.iv_title2);
            name = itemView.findViewById(R.id.iv_name2);
        }

        void onBind(exItem item) {
            exImg.setImageResource(item.getResourceId());
            name.setText(item.getName());
        }
    }
}