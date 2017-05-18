package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0;

    boolean name = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkCheckBoxAnswer();

        EditText userName = (EditText) findViewById(R.id.nameText);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                name = s.length() > 0;

            }
        });

        EditText q3_TextBox = (EditText) findViewById(R.id.q3_answer);

        final String rightAnswer = getString(R.string.rightAnswer);

        /**
         *
         */
        q3_TextBox.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                String userAnswer = String.valueOf(s);

                if (s.length() > 0) {

                    if (userAnswer.equals(rightAnswer)) {

                        score = score + 20;

                    }


                }


            }
        });
    }

    /**
     *
     */
    private void checkCheckBoxAnswer() {

        //Get the ids of all the right checkbox
        //correct answers

        final CheckBox scrollViewCheckbox = (CheckBox) findViewById(R.id.q4_option4);
        final CheckBox checkboxViewCheckbox = (CheckBox) findViewById(R.id.q4_option3);

        final CheckBox textViewCheckbox = (CheckBox) findViewById(R.id.q4_option1);

        textViewCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textViewCheckbox.isChecked()) {
                    if (scrollViewCheckbox.isChecked()) {
                        if (checkboxViewCheckbox.isChecked()) {
                            score = score + 20;
                        }
                    }
                }

            }
        });
    }

    /**
     * @param view
     */
    public void q1_OnRadioButtonClicked(View view) {

        // Is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // CHeck which radio button is clicked
        switch (view.getId()) {
            case R.id.q1_option1:
                if (checked)
                    score = score + 20;
                break;
            default:
                break;
        }
    }

    /**
     * @param view
     */
    public void q2_OnRadioButtonClicked(View view) {

        RadioGroup q2Button = (RadioGroup) findViewById(R.id.radio_q2);

        //Is the button now clicked
        int checked = q2Button.getCheckedRadioButtonId();

        RadioButton checkedRadioButton = (RadioButton) findViewById(checked);

        if (checkedRadioButton.isChecked()) {
            score = score + 20;
        }
    }

    /**
     * @param view
     */
    public void q5_OnRadioButtonClicked(View view) {

        // Iss the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button is clicked
        switch (view.getId()) {
            case R.id.q5_option3:
                if (checked)
                    score = score + 20;
                break;
            default:
                break;
        }
    }

    public void subtmitButtonClicked(View view) {

        EditText username = (EditText)findViewById(R.id.nameText);
        String theUser = (username.getText()).toString();
        if(name){

            Toast.makeText(MainActivity.this, theUser + " Your total score was " + score, Toast.LENGTH_LONG).show();

        }else {

            Toast.makeText(MainActivity.this, "Please kindly enter a name at the top of the app", Toast.LENGTH_LONG).show();

        }


    }
}
