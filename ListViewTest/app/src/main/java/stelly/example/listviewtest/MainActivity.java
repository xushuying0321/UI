package stelly.example.listviewtest;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private int []imgs;
    private String []names;

    private List<Map<String,Object>> mData;

    private int deleteItem=-1;
    private boolean deleteItemBoolean=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_adapter);
        imgs=new int[]{R.mipmap.cat,R.mipmap.dog,R.mipmap.elephant,R.mipmap.lion,R.mipmap.monkey,R.mipmap.tiger};
        names=new String[]{"Cat","Dog","Elephant","Lion","Monkey","Tiger"};

        String from[]={"name","img"};
        int to[]={R.id.item_name_tv,R.id.item_img_iv};

        listView=(ListView)findViewById(R.id.listview);
        mData= new ArrayList<Map<String,Object>>();

        for (int i=0;i<names.length;i++){
            Map<String,Object> item = new HashMap<String,Object>();
            item.put("name",names[i]);
            item.put("img",imgs[i]);
            mData.add(item);
        }

        final SimpleAdapter simpleAdapter=new SimpleAdapter(this,mData,R.layout.simple_adapter_item,from,to);
        simpleAdapter.notifyDataSetChanged();


        listView.setAdapter(simpleAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,mData.get(i).get("name").toString(),Toast.LENGTH_LONG).show();
            }
        });

    }
}
