package com.ist402.jdm5908.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mNumberDisplay;
    private SimpleExpression mExpression;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mNumberDisplay = (TextView) findViewById(R.id.textView1);
        mExpression = new SimpleExpression();
    }

    public void goAC(View view) {
        mExpression.clearOperands();
        mNumberDisplay.setText(0);
    }

    public void goOperand(View view) {
        String val = (String) mNumberDisplay.getText();
        String digit = (String) view.getContentDescription();
        if (val.charAt(0) == 0)
            mNumberDisplay.setText(digit);
        else
            mNumberDisplay.setText((String) mNumberDisplay.getText() + digit.charAt(0));
    }

    public void goOperator(View view) {
        String operator = (String) mNumberDisplay.getText();
        try {
            String val = (String) mNumberDisplay.getText();
            mExpression.setmOperand1(Integer.parseInt(val));
        }
        catch (NumberFormatException e) {
            mExpression.setmOperand1(0);
        }
        mNumberDisplay.setText(0);
        mExpression.setOperator(operator);
    }

    public void goCompute(View view) {
        try {
            String val = (String) mNumberDisplay.getText();
            mExpression.setmOperand2(Integer.parseInt(val));
        }
        catch (NumberFormatException e) {
            mExpression.setmOperand2(0);
        }
        mNumberDisplay.setText(mExpression.getValue().toString());
    }
}
