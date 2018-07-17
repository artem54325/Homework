package artem.homework.mineSurveyingActivity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import artem.homework.R;

public class MineSurveyingActivity extends AppCompatActivity {
    LinearLayout layout;
    TextView textView;
    private List<MineSurveyingLayout> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine_surveying);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        layout = (LinearLayout) findViewById(R.id.layout);
        list.add(new MineSurveyingLayout(this));
        layout.addView(list.get(0));
        textView = (TextView) findViewById(R.id.summText);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_mine_surveing, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.summ:
                float sum=0;
                for (MineSurveyingLayout lat:list) sum += lat.getSumm();
                textView.setText("Всего градусов: " + MineSurveyingLayout.convertingDoubleToString(sum));
                break;
            case R.id.save:

                break;
            case R.id.add:
                MineSurveyingLayout mine = new MineSurveyingLayout(this);;
                layout.addView(mine);
                list.add(mine);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
