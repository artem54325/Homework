package artem.homework.datStatActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import artem.homework.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DatStatisticActivity extends AppCompatActivity {
    @BindView(R.id.sum)
    TextView sumText;
    private int int1 = 0;
    private int int2 = 0;
    private int int3 = 0;
    private int int4 = 0;
    private int int5 = 0;
    private int int6 = 0;
    private int int7 = 0;
    private int int8 = 0;
    private int int9 = 0;
    private int int0 = 0;

    private void clickSum() {
        sumText.setText(String.valueOf(int0 + int1 + int2 + int3 + int4 + int5 + int6 + int7 + int8 + int9));
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dat_statistic, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.refresh:
                int1 = 0;
                int2 = 0;
                int3 = 0;
                int4 = 0;
                int5 = 0;
                int6 = 0;
                int7 = 0;
                int8 = 0;
                int9 = 0;
                int0 = 0;
                clickSum();
                viewsText();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dat_statistic);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @OnClick({R.id.but_7, R.id.but_8, R.id.but_9, R.id.but_4, R.id.but_5, R.id.but_6, R.id.but_1, R.id.but_2, R.id.but_3, R.id.but_0})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.but_7:++int7;
                break;
            case R.id.but_8:++int8;
                break;
            case R.id.but_9:++int9;
                break;
            case R.id.but_4:++int4;
                break;
            case R.id.but_5:++int5;
                break;
            case R.id.but_6:++int6;
                break;
            case R.id.but_1:++int1;
                break;
            case R.id.but_2:++int2;
                break;
            case R.id.but_3:++int3;
                break;
            case R.id.but_0:++int0;
                break;
        }
        clickSum();
        viewsText();
    }

    private void viewsText(){
        ((TextView) findViewById(R.id.text_9)).setText(String.valueOf(int9));
        ((TextView) findViewById(R.id.text_8)).setText(String.valueOf(int8));
        ((TextView) findViewById(R.id.text_7)).setText(String.valueOf(int7));
        ((TextView) findViewById(R.id.text_6)).setText(String.valueOf(int6));
        ((TextView) findViewById(R.id.text_5)).setText(String.valueOf(int5));
        ((TextView) findViewById(R.id.text_4)).setText(String.valueOf(int4));
        ((TextView) findViewById(R.id.text_3)).setText(String.valueOf(int3));
        ((TextView) findViewById(R.id.text_2)).setText(String.valueOf(int2));
        ((TextView) findViewById(R.id.text_1)).setText(String.valueOf(int1));
        ((TextView) findViewById(R.id.text_0)).setText(String.valueOf(int0));

    }
}
