package com.akin.newstagview;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycleview);
        Bitmap[] bitmap = getBitmaps();
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(bitmap);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private Bitmap[] getBitmaps() {
            Bitmap[] getbitmap = new Bitmap[10];
            getbitmap[0] = BitmapFactory.decodeResource(getResources(),R.drawable.images);
        getbitmap[1] = BitmapFactory.decodeResource(getResources(),R.drawable.autumn);
        getbitmap[2] = BitmapFactory.decodeResource(getResources(),R.drawable.images3);
        getbitmap[3] = BitmapFactory.decodeResource(getResources(),R.drawable.bitcoin);
        getbitmap[4] = BitmapFactory.decodeResource(getResources(),R.drawable.images1);
        getbitmap[5] = BitmapFactory.decodeResource(getResources(),R.drawable.images4);
        getbitmap[6] = BitmapFactory.decodeResource(getResources(),R.drawable.images7);
        getbitmap[7] = BitmapFactory.decodeResource(getResources(),R.drawable.bluebackground);
        getbitmap[8] = BitmapFactory.decodeResource(getResources(),R.drawable.images6);
        getbitmap[9] = BitmapFactory.decodeResource(getResources(),R.drawable.background);


        return getbitmap;
    }

    private class RecyclerViewAdapter extends RecyclerView.Adapter<Gridholder>{
        Bitmap[] bitmaps;

        public RecyclerViewAdapter(Bitmap[] bitmaps) {
            this.bitmaps = bitmaps;
        }

        @Override
        public Gridholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.gridview,parent,false);
            return new Gridholder(view);
        }

        @Override
        public void onBindViewHolder(Gridholder holder, int position) {
            holder.imgview.setImageBitmap(bitmaps[position]);

        }

        @Override
        public int getItemCount() {
            return bitmaps.length;
        }
    }
    private class Gridholder extends RecyclerView.ViewHolder{

        ImageView imgview;
        
        public Gridholder(View itemView) {
            super(itemView);
            imgview = itemView.findViewById(R.id.imgview);

        }
    }
}
