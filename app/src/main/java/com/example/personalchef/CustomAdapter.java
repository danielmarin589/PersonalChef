package com.example.personalchef;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    Context context;
    String mTitle[];
    int images[];
    LayoutInflater inflter;

    public CustomAdapter(Context applicationContext, String[] mTitle, int[] images) {
        this.context = context;
        this.mTitle = mTitle;
        this.images = images;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return mTitle.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_listview, null);
        TextView title = (TextView) view.findViewById(R.id.textView1);
        ImageView image = (ImageView) view.findViewById(R.id.listIcon);
        title.setText(mTitle[i]);
        image.setImageResource(images[i]);
        return view;
    }
}
