package artem.homework.mineSurveyingActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import artem.homework.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MineSurveyingLayout extends LinearLayout {
    @BindView(R.id.L1)
    EditText gradL1;
    @BindView(R.id.L2)
    EditText gradL2;
    @BindView(R.id.R1)
    EditText gradR1;
    @BindView(R.id.R2)
    EditText gradR2;

    @BindView(R.id.check)
    CheckBox check;

    @BindView(R.id.error1)
    TextView error1;
    @BindView(R.id.error2)
    TextView error2;

    @BindView(R.id.SR1)
    TextView sr1;
    @BindView(R.id.SR2)
    TextView sr2;

    @BindView(R.id.answer)
    TextView answer;
    @BindView(R.id.layout)
    LinearLayout layout;

    private float answeDoubl = 0;

    public MineSurveyingLayout(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.mine_layout, this, true);
        ButterKnife.bind(this);

        gradL1.setOnFocusChangeListener(changeListener);
        gradL2.setOnFocusChangeListener(changeListener);
        gradR1.setOnFocusChangeListener(changeListener);
        gradR2.setOnFocusChangeListener(changeListener);
        layout.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                consider();
            }
        });//changeListener;
    }


    public static String convertingDoubleToString(float d) {
        int qu = (int) (d / (60 * 60));
        String ass = qu + " ";

        d = (d - qu * 60 * 60);
        qu = (int) (d / 60);
        ass += qu + "' ";

        d = (d - qu * 60);
        ass += d + "''";
        return ass;
    }

    public float getSumm() {
        if (check.isChecked())
            return answeDoubl;
        return 0;
    }

    OnFocusChangeListener changeListener = new OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            consider();
        }
    };

    private void consider(){
        if ((!gradL1.getText().toString().equals("") && gradL1.getText().toString().split(" ").length == 3) &&
                (!gradL2.getText().toString().equals("") && gradL2.getText().toString().split(" ").length == 3) &&
                (!gradR1.getText().toString().equals("") && gradR1.getText().toString().split(" ").length == 3) &&
                (!gradR2.getText().toString().equals("") && gradR2.getText().toString().split(" ").length == 3)) {
            Gradus l1 = null;
            Gradus r1 = null;
            Gradus l2 = null;
            Gradus r2 = null;
            try {
                l1 = new Gradus().setSecond(gradL1.getText().toString());
                l2 = new Gradus().setSecond(gradL2.getText().toString());
                r1 = new Gradus().setSecond(gradR1.getText().toString());
                r2 = new Gradus().setSecond(gradR2.getText().toString());
            } catch (Exception e) {
                Toast.makeText(getContext(), "Проверь правильность написания данных точек, где-то есть ошибка", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            error1.setText(convertingDoubleToString(l1.errorLayout(r1.getSecond())));
            error2.setText(convertingDoubleToString(l2.errorLayout(r2.getSecond())));

            Float a1 = l1.KLKV(r1.getSecond());
            Float a2 = l2.KLKV(r2.getSecond());
            sr1.setText(convertingDoubleToString(a1));
            sr2.setText(convertingDoubleToString(a2));

//                if (a1>a2) {
//                    answer.setText(convertingDoubleToString((Float) a1 - a2));
//                    answeDoubl=(Float) a1 - a2;
//                }else {
            answer.setText(convertingDoubleToString((Float) a2 - a1));
            answeDoubl = (Float) a2 - a1;
//                }

        }
    }

}

class Gradus {
    private float second = 0;

    float KLKV(float sec) {
        return (sec + second + 180 * 60 * 60) / 2;
    }

    float errorLayout(float sec) {
        if (sec > second)
            return sec - second - 180 * 60 * 60;
        else
            return second - sec - 180 * 60 * 60;
    }

    Gradus setSecond(String text) throws Exception {
        String[] array = text.split(" ");
        second = Float.valueOf(array[0]) * 60 * 60 + Float.valueOf(array[1]) * 60 + Float.valueOf(array[2]);
        return this;
    }


    public Float getSecond() {
        return second;
    }

    public void setSecond(Float second) {
        this.second = second;
    }
}
