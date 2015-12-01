package com.sora.desktop;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Map<String,Object>> datalist;
    private int[] icon = {R.drawable.address_book,R.drawable.calendar,R.drawable.camera,
            R.drawable.clock,R.drawable.games_control,R.drawable.messenger,
            R.drawable.ringtone,R.drawable.settings,R.drawable.speech_balloon,R.drawable.weather,
            R.drawable.world,R.drawable.youtube};
    private String[] iconName = {"联系人", "日历", "照相机", "时钟", "游戏", "短信", "铃声",
     "设置","语音", "天气","浏览器","Youtube"};
    private SimpleAdapter simpleAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        gridView = (GridView) findViewById(R.id.gridView);
        //准备数据源
        //新建适配器
        //GridView加载适配器
        //GridView配置事件监听器
        datalist = new ArrayList<Map<String, Object>>();
        simpleAdapter = new SimpleAdapter(this,getData(),R.layout.item,new String[]{"image","text"},new int[]{R.id.item_image,R.id.item_text});
        gridView.setAdapter(simpleAdapter);
    }

    private List<Map<String,Object>> getData() {

        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            datalist.add(map);
        }
            return datalist;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
