package com.example.zoomviewstemp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.zoomviewstemp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ZoomLayoutRecyclerViewAdapter extends RecyclerView.Adapter<ZoomLayoutRecyclerViewAdapter.RecyclerViewHolder> {

    private List<Integer> list;

    public ZoomLayoutRecyclerViewAdapter(List<Integer> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.bind(list.get(position), position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class RecyclerViewHolder extends RecyclerView.ViewHolder {

//        private ZoomImageView zoomImageView;
        private ImageView imageView;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
//            zoomImageView = itemView.findViewById(R.id.zoom_image_view);
            imageView = itemView.findViewById(R.id.imageView);
        }

        void bind(int image, int position) {
//            Picasso.get().load(image).into(zoomImageView);
            Picasso.get().load(image).into(imageView);
        }
    }
}
