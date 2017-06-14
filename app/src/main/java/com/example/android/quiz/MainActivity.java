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

    int score = 0; // Use this variable to monitor the overall score

    boolean name = false; // Use this to check if user has entered their name




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
        final CheckBox textClassViewCheckbox = (CheckBox) findViewById(R.id.q4_option2);

        // Use if statement to maek sure
        // all are checked before adding 20 points to the
        // score variable
        textViewCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textViewCheckbox.isChecked() && !(textClassViewCheckbox.isChecked())) {
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

        boolean checker = false;

        // Is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button is clicked
        switch (view.getId()) {
            case R.id.q1_option1:
                if (checked)
                    score = score + 20;
                    //checker = true;
                break;
            case R.id.q1_option2:
            case R.id.q1_option3:
                if(checked){
                    if(score > 0){
                        score -= 20;
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

        // create a group variable using group id
        RadioGroup q2Button = (RadioGroup) findViewById(R.id.radio_q2);

        //Is the button now clicked, then which member of the group
        // was clicked
        int checked = q2Button.getCheckedRadioButtonId();

        // Use the group is to identify if the clicked radio button
        // was for the correct answer
        RadioButton checkedRadioButton = (RadioButton) findViewById(checked);

        // if the right was selected add 20 points to the score variable
        if (checkedRadioButton.isChecked()) {
            score = score + 20;
        }
    }

    /**
     * @param view
     */
    public void q5_OnRadioButtonClicked(View view) {

        boolean checker = false;

        // Is the button now checked
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button is clicked
        switch (view.getId()) {
            case R.id.q5_option3:
                if (checked)
                    score = score + 20;
                    //checker = true;
                break;
            case R.id.q1_option2:
            case R.id.q1_option3:
                if(checked){

                    score = score - 20;

                }
            default:
                break;
        }
    }

    /**
     *
     * @param view
     */
    public void subtmitButtonClicked(View view) {

        EditText username = (EditText)findViewById(R.id.nameText);

        // get the value of the user's name and "cast" to primitive type "String"
        String theUser = (username.getText()).toString();

        //if(name){ // if user entered a name print name and score of user

            Toast.makeText(MainActivity.this, theUser + " Your total score was " + score, Toast.LENGTH_LONG).show();

        //}else { // If no user name was entered then notify user and wait for their respond

            //Toast.makeText(MainActivity.this, "Please kindly enter a name at the top of the app", Toast.LENGTH_LONG).show();

       // }


    }
}
