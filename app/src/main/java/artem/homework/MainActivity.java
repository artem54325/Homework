package artem.homework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import artem.homework.datStatActivity.DatStatisticActivity;
import artem.homework.mineSurveyingActivity.MineSurveyingActivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mine_surveing, R.id.dat_stat})
    public void onViewClicked(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.mine_surveing:
                intent = new Intent(this, MineSurveyingActivity.class);
                break;
            case R.id.dat_stat:
                intent = new Intent(this, DatStatisticActivity.class);
                break;
        }
        if (intent!=null) startActivity(intent);

    }
}
