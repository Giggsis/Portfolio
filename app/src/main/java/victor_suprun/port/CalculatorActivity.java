package victor_suprun.port;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by QLon on 03.10.2017.
 */

public class CalculatorActivity extends AppCompatActivity {
    @BindViews({R.id.n0, R.id.n1, R.id.n2, R.id.n3, R.id.n4, R.id.n5, R.id.n6, R.id.n7, R.id.n8, R.id.n9, R.id.sRes, R.id.sAdd, R.id.sDiv, R.id.sDot, R.id.sMul, R.id.sSub, R.id.cleanO})
    List<Button> viewButtons;
    @BindViews({R.id.result,R.id.math})
    List<TextView> viewText;
    Queue<String> resultMath = new PriorityQueue();
    String operands="", operand2="", operator="";
    boolean checkForSign = false, checkForDot = false;
    List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    List<String> operators = Arrays.asList("+", "-", "*", "/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        ButterKnife.bind(this);

        resultMath.add("");
    }



    //-------------------Trash ! ! !
    //                         V V V
    private String operator1 = "", operand = "", operator2 = "";
    private void toStack(String math)
    {
//         math
//  s
    }
    private void cleanQueue()
    {
        operands = "";
        resultMath.clear();
        resultMath.add("");
        viewText.get(1).setText(operands);
    }
    private void makeResoult()
    {



        ///////////////////////////////             FIX THIS!!!!!!!!!!!!!!!!!!
        resultMath.poll();
        String operator1 = "", operand = "", operator2 = "";
        double dOperator1, dOperator2;
        boolean ch = false;
        for(int i = 0; i < resultMath.size(); i++) {

            try {

                Double.parseDouble(resultMath.poll());
                operator1 += resultMath.poll().toString();

            }
            catch (NumberFormatException e)
            {
                operand = resultMath.poll();

            }


            Log.d("RESOULT",operator1 + " _ " + operand + " _ " +operator2);
        }
    }
    @OnClick({R.id.n0, R.id.n1, R.id.n2, R.id.n3, R.id.n4, R.id.n5, R.id.n6, R.id.n7, R.id.n8, R.id.n9, R.id.sRes, R.id.sAdd, R.id.sDiv, R.id.sDot, R.id.sMul, R.id.sSub, R.id.cleanO})
    void onSaveClick(Button view) {
        String n1, n2;
        switch (view.getId()) {
            case R.id.cleanO:
                cleanQueue();
                break;
            case R.id.n0:
                toStack(numbers.get(0).toString());
                break;
            case R.id.n1:
                toStack(numbers.get(1).toString());
                break;
            case R.id.n2:
                toStack(numbers.get(2).toString());
                break;
            case R.id.n3:
                toStack(numbers.get(3).toString());
                break;
            case R.id.n4:
                toStack(numbers.get(4).toString());
                break;
            case R.id.n5:
                toStack(numbers.get(5).toString());
                break;
            case R.id.n6:
                toStack(numbers.get(6).toString());
                break;
            case R.id.n7:
                toStack(numbers.get(7).toString());
                break;
            case R.id.n8:
                toStack(numbers.get(8).toString());
                break;
            case R.id.n9:
                toStack(numbers.get(9).toString());
                break;
            case R.id.sAdd:
                viewButtons.get(13).setEnabled(true);
                toStack(operators.get(0));
                break;
            case R.id.sSub:
                viewButtons.get(13).setEnabled(true);
                toStack(operators.get(1));
                break;
            case R.id.sMul:
                viewButtons.get(13).setEnabled(true);
                toStack(operators.get(2));
                break;
            case R.id.sDiv:
                viewButtons.get(13).setEnabled(true);
                toStack(operators.get(3));
                break;
            case R.id.sDot:
                viewButtons.get(13).setEnabled(false);
                toStack(".");
                break;
            case R.id.sRes:
                makeResoult();
                viewButtons.get(13).setEnabled(true);
                break;
        }
    }
}
