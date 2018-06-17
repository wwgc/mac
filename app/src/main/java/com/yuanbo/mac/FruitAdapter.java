package com.yuanbo.mac;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends ArrayAdapter {
    private int resourceId;

    public FruitAdapter(Context context, int textViewResourcId, List<Fruit> objescts){
        super(context, textViewResourcId, objescts);

        resourceId = textViewResourcId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Fruit fruit = (Fruit) getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        ImageView fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
        TextView fruitName = (TextView) view.findViewById(R.id.fruit_name);
        // 设置图片
        fruitImage.setImageResource(fruit.getImageId());
        // 设置文本
        fruitName.setText(fruit.getName());

        return view;
    }
}
