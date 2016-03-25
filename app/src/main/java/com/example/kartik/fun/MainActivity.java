package com.example.kartik.fun;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String KEY_FACT = "KEY_FACT";
    private static final String KEY_COLOR = "KEY_COLOR";
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    //Declare our view variables
    private TextView mFactTextView;
    private Button mShowFactButton;
    private RelativeLayout mRelativeLayout;
    private String mFact;
    private int mColor;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
            super.onSaveInstanceState(outState);
        
            outState.putString(KEY_FACT, mFact);
            outState.putInt(KEY_COLOR,mColor);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFactTextView = (TextView) findViewById(R.id.funTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mRelativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //the button was clicked , so update factTextView with a new Fact
                mFact = mFactBook.getFact();
                mColor = mColorWheel.getColor();
                mFactTextView.setText(mFact);
                mRelativeLayout.setBackgroundColor(mColor);
                mShowFactButton.setTextColor(mColor);
            }
        };
        mShowFactButton.setOnClickListener(listener);

    }
}
