package com.yuanbo.mac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();

        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView lv = (ListView) findViewById(R.id.list_view);
        lv.setAdapter(adapter);
    }

    private void initFruits() {

        Fruit apple = new Fruit("Apple", R.drawable.apple_pic);
        fruitList.add(apple);

        Fruit banana = new Fruit("Banana", R.drawable.banana_pic);
        fruitList.add(banana);

        Fruit orange = new Fruit("Orange", R.drawable.orange_pic);
        fruitList.add(orange);

        Fruit pear = new Fruit("Pear", R.drawable.pear_pic);
        fruitList.add(pear);

    }
}
