package com.aries.crudwithretrofit.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.aries.crudwithretrofit.R;
import com.aries.crudwithretrofit.modul.Record;
import com.aries.crudwithretrofit.view.activity.AddActivity;

import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<Record> moviesList;
    private Activity activity;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView keterangan, tanggal;
        public LinearLayout ll_layout_utama;

        public MyViewHolder(View view) {
            super(view);
            keterangan = view.findViewById(R.id.keterangan);
            tanggal = view.findViewById(R.id.tanggal);
            ll_layout_utama = view.findViewById(R.id.ll_layout_utama);
        }
    }

    public CategoryAdapter(List<Record> moviesList, Activity activity) {
        this.moviesList = moviesList;
        this.activity = activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_category, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final Record movie = moviesList.get(position);

        holder.keterangan.setText(movie.getKETERANGANMASUK());
        holder.tanggal.setText(movie.getTGL());

        holder.ll_layout_utama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent goDetail = new Intent(activity, AddActivity.class);
                goDetail.putExtra("intent_id", movie.getID());
                goDetail.putExtra("intent_tgl", movie.getTGL());
                goDetail.putExtra("intent_masuk", movie.getMASUK());
                goDetail.putExtra("intent_keluar", movie.getKELUAR());
                goDetail.putExtra("intent_ketmasuk", movie.getKETERANGANMASUK());
                goDetail.putExtra("intent_ketkeluar", movie.getKETERANGANKELUAR());
                goDetail.putExtra("intent_action", "edit");
                activity.startActivity(goDetail);

            }

        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}
