package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int score = 0; // Use this variable to monitor the overall score

    boolean name = false; // Use this to check if user has entered their name

    boolean q1lock = false;
    boolean q2lock = false;
    boolean q5lock = false;
    boolean checkLock = false;
    boolean textAnswerLock = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //checkCheckBoxAnswer();

        EditText userName = (EditText) findViewById(R.id.nameText);

        userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) { // make sure the user has entered a name

                // returns true if user has enter name or
                // some text in the name edit text view
                name = s.length() > 0;

            }
        });


        EditText q3_TextBox = (EditText) findViewById(R.id.q3_answer);


        final String rightAnswer = getString(R.string.rightAnswer);

        /**
         * use this to check what the user has entered into
         * the third question edit text view
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

                // Change the "type" of the value of edit text view
                // to "String" so we compare it to the "rightAnswer"
                String userAnswer = String.valueOf(s);


                if (s.length() > 0) { //has the user enter a value, if yes go into the if loop

                    if (userAnswer.equals(rightAnswer)) { // Is it the right answer, if so enter ans add 20 points

                        if (!textAnswerLock) {

                            score += 20;
                            textAnswerLock = true;
                        }


                    } else {
                        if (textAnswerLock) {
                            score -= 20;
                            textAnswerLock = false;
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

        // Check which radio button is clicked
        switch (view.getId()) {
            case R.id.q1_option1:
                if (checked)
                    score = score + 20;
                q1lock = true;
                break;
            case R.id.q1_option2:
            case R.id.q1_option3:
                if (checked) {
                    if (q1lock) {
                        if (score > 0) {
                            score -= 20;
                            q1lock = false;
                        }
                    }

                }

            default:
                break;
        }
    }

    /**
     * @param view
     */
    public void q2_OnRadioButtonClicked(View view) {

        // Is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button is clicked
        switch (view.getId()) {
            case R.id.q2_option2:
                if (checked)
                    score = score + 20;
                q2lock = true;
                break;
            case R.id.q2_option1:
            case R.id.q2_option3:
                if (checked) {
                    if (q2lock) {
                        if (score > 0) {
                            score -= 20;
                            q2lock = false;
                        }
                    }

                }

            default:
                break;
        }
    }

    /**
     * @param view
     */
    public void q5_OnRadioButtonClicked(View view) {

        // Is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button is clicked
        switch (view.getId()) {
            case R.id.q5_option3:
                if (checked)
                    score = score + 20;
                q5lock = true;
                break;
            case R.id.q5_option2:
            case R.id.q5_option1:
                if (checked) {
                    if (q5lock) {
                        if (score > 0) {
                            score -= 20;
                            q5lock = false;
                        }
                    }

                }

            default:
                break;
        }
    }

    /**
     * @param view
     */
    public void subtmitButtonClicked(View view) {

        EditText username = (EditText) findViewById(R.id.nameText);

        // get the value of the user's name and "cast" to primitive type "String"
        String theUser = (username.getText()).toString();

        //if(name){ // if user entered a name print name and score of user

        Toast.makeText(MainActivity.this, theUser + " Your total score was " + score, Toast.LENGTH_LONG).show();

        //}else { // If no user name was entered then notify user and wait for their respond

        //Toast.makeText(MainActivity.this, "Please kindly enter a name at the top of the app", Toast.LENGTH_LONG).show();

        // }


    }

    public void checkBoxClicked(View view) {

        //Get the ids of all the right checkbox
        //correct answers
        final CheckBox scrollViewCheckbox = (CheckBox) findViewById(R.id.q4_option4);
        final CheckBox checkboxViewCheckbox = (CheckBox) findViewById(R.id.q4_option3);
        final CheckBox textViewCheckbox = (CheckBox) findViewById(R.id.q4_option1);
        final CheckBox textClassViewCheckbox = (CheckBox) findViewById(R.id.q4_option2);


        if (scrollViewCheckbox.isChecked() && checkboxViewCheckbox.isChecked() && textViewCheckbox.isChecked() && !textClassViewCheckbox.isChecked()) {

            score += 20;
            checkLock = true;

        } else {
            if (checkLock) {
                if (score > 0) {
                    score -= 20;
                    checkLock = false;
                }
            }

        }
    }


}
