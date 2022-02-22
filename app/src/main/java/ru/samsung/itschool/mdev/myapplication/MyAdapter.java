package ru.samsung.itschool.mdev.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewRow> {

    private ArrayList<MainActivity.Block> arrayList;

    public void addNewItem() {
        arrayList.add(new MainActivity.Block("New item","https://supertechman.com.au/wp-content/uploads/2021/08/chrome-flags.png"));
        this.notifyItemInserted(arrayList.size());
    }

    @NonNull
    @Override
    public ViewRow onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout,parent,false);
        return new ViewRow(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewRow holder, int position) {
        Picasso.get().load(arrayList.get(position).getUrl()).into(holder.imageView);
        holder.textView.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    // inner class
    class ViewRow extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewRow(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
