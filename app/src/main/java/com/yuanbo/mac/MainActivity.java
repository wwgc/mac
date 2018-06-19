package com.yuanbo.mac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<Fruit>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*if (CheckNet.getNetState(this) == CheckNet.NET_NONE) {
            Log.d("MWEATHER", "network disconnect");
            Toast.makeText(MainActivity.this, "network disconnect", Toast.LENGTH_LONG).show();
        }else{
            getWeatherDatafromNet("101010100");
        }*/

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

    private void getWeatherDatafromNet(String cityCode) {
        final String address = "http://wthrcdn.etouch.cn/WeatherApi?citykey=" + cityCode;
        Log.d("Address:", address);
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection urlConnection = null;
                try {
                    URL url = new URL(address);
                    urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.setConnectTimeout(8000);
                    urlConnection.setReadTimeout(8000);
                    InputStream in = urlConnection.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                    StringBuffer sb = new StringBuffer();
                    String str;
                    while ((str = reader.readLine()) != null) {
                        sb.append(str);
                        Log.d("date from url", str);
                    }
                    String response = sb.toString();
                    Log.d("response", response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
