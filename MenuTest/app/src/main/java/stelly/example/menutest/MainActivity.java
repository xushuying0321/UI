package stelly.example.menutest;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    //private ActionBar actionBar;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_test);
        textView=(TextView)findViewById(R.id.analyse_tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.normal_menu_item:
                Toast.makeText(MainActivity.this,"普通菜单项",Toast.LENGTH_LONG).show();
                break;
            case R.id.text_size:
                break;
            case R.id.text_color:
                break;

            case R.id.text_color_black:
                textView.setTextColor(getResources().getColor(R.color.black));
                break;
            case R.id.text_color_red:
                textView.setTextColor(getResources().getColor(R.color.red));
                break;

            case R.id.text_size_10sp:
                textView.setTextSize(10);
                break;
            case R.id.text_size_16sp:
                textView.setTextSize(16);
                break;
            case R.id.text_size_20sp:
                textView.setTextSize(20);
                break;
            default: break;
        }
        return super.onOptionsItemSelected(item);
    }
}
