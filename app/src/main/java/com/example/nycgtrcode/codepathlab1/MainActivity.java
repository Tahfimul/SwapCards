package com.example.nycgtrcode.codepathlab1;

import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button ans1, ans2, ans3;
    ImageView visibility;
    Boolean visible = true, choicePicked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);
        visibility = (ImageView) findViewById(R.id.visibility);
        initializeListeners();
    }

    private void initializeListeners() {
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choicePicked)
                    resetChoiceBackground();
                else
                    choicePicked = true;
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
                    ans1.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_incorrect) );
                    ans2.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_correct));
                } else {
                    ans1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_incorrect));
                    ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_correct));
                }
            }
        });

        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choicePicked)
                    resetChoiceBackground();
                else
                    choicePicked = true;
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                    ans2.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_correct));
                else
                    ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_correct));

            }
        });

        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choicePicked)
                    resetChoiceBackground();
                else
                    choicePicked = true;
                if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN){
                    ans2.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_correct));
                    ans3.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_incorrect));
                }
                else {
                    ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_correct));
                    ans3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_incorrect));
                }
            }
        });

        visibility.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (visible)
                {
                    visible = false;
                    if (choicePicked)
                        resetChoiceBackground();
                    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                        visibility.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_visibility_off_black_24dp));
                    else
                        visibility.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_visibility_off_black_24dp));
                    hideAnsChoices();
                }
                else
                {
                    visible = true;
                    if(Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                        visibility.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_visibility_black_24dp));
                    else
                        visibility.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_visibility_black_24dp));
                    showAnsChoices();
                }

            }
        });
    }

    private void resetChoiceBackground() {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN){
            ans1.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_default));
            ans2.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_default));
            ans3.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_default));
        }
        else
        {
            ans1.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_default));
            ans2.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_default));
            ans3.setBackground(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ans_default));
        }
    }

    private void hideAnsChoices() {
        ans1.setVisibility(View.INVISIBLE);
        ans2.setVisibility(View.INVISIBLE);
        ans3.setVisibility(View.INVISIBLE);
    }

    private void showAnsChoices() {
        ans1.setVisibility(View.VISIBLE);
        ans2.setVisibility(View.VISIBLE);
        ans3.setVisibility(View.VISIBLE);
    }

}
