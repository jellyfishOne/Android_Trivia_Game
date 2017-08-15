package com.trivia_game.android.triviagame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Extra_Message is my key and a public constatnt
    public static final String EXTRA_MESSAGE = "com.trivia_game.android.triviagame.MESSAGE";

    ArrayList<Integer> randomNumTracker = new ArrayList<>();
    int n = 0;
    int count = 0;
    int score = 0;
    Questions q = new Questions();
    Random rand = new Random();

    String[] questions = q.getQuestions();
    String[][] choices = q.getChoices();
    String[] correctAnswer = q.getAnsewers();
    String[] correctMessage = q.getCorrect();
    String[] wrongMessage = q.getWrong();

    RadioGroup answersRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getQuestion();
    }

    /**
     * Generates a new question and displays it the user
     */
    private void getQuestion(){
        String a = "";
        String b = "";
        String c = "";
        String d = "";

        //Generate random number for question
        int randomNum = rand.nextInt(questions.length);
        //check if tracker is empty add new radom number to tracker
        if(randomNumTracker.isEmpty()){
            n = randomNum;
            randomNumTracker.add(randomNum);

        }else{
            //if not empty check if random num has already been used
            while(randomNumTracker.contains(randomNum)){
                randomNum = rand.nextInt(questions.length);
            }
            n = randomNum;
            randomNumTracker.add(randomNum);
        }

        //Display questions and choices to user
        TextView textView = (TextView) findViewById(R.id.question_text_view);
        textView.setText(questions[n]);

        for(int j = 0; j < 4; j++){
            a = choices[n][j];
            j++;
            b = choices[n][j];
            j++;
            c = choices[n][j];
            j++;
            d = choices[n][j];

        }

        TextView textViewA = (TextView) findViewById(R.id.radio_a);
        textViewA.setText(a);

        TextView textViewB = (TextView) findViewById(R.id.radio_b);
        textViewB.setText(b);

        TextView textViewC = (TextView) findViewById(R.id.radio_c);
        textViewC.setText(c);

        TextView textViewD = (TextView) findViewById(R.id.radio_d);
        textViewD.setText(d);

        //update counter
        count += 1;
        TextView tracker = (TextView)  findViewById(R.id.tracker_text_view);
        tracker.setText(count + "/10");
    }


    /**
     * Checks the answer
     */
    public void onSubmit(View view){
        answersRadioGroup = (RadioGroup) findViewById(R.id.answers_radioGroup);
        RadioButton radio_a = (RadioButton) findViewById(R.id.radio_a);
        RadioButton radio_b = (RadioButton) findViewById(R.id.radio_b);
        RadioButton radio_c = (RadioButton) findViewById(R.id.radio_c);
        RadioButton radio_d = (RadioButton) findViewById(R.id.radio_d);

        int randNum = rand.nextInt(correctMessage.length);
        int duration = Toast.LENGTH_SHORT;
        Toast correctToast = Toast.makeText(this, correctMessage[randNum], duration);
        String wrong = wrongMessage[randNum]+ ". Correct answer: " + correctAnswer[n];
        Toast wrongToast = Toast.makeText(this, wrong, duration);

        if(radio_a.isChecked() && radio_a.getText().equals(correctAnswer[n])){
            score += 1;
            correctToast.show();
        }else if(radio_b.isChecked() && radio_b.getText().equals(correctAnswer[n])){
            score += 1;
            correctToast.show();
        }else if(radio_c.isChecked() && radio_c.getText().equals(correctAnswer[n])){
            score += 1;
            correctToast.show();
        }else if(radio_d.isChecked() && radio_d.getText().equals(correctAnswer[n])){
            score += 1;
            correctToast.show();
        }else{
            wrongToast.show();
        }

        //Clear checked radio button
        answersRadioGroup.clearCheck();

        //Start next Activity if user has answered 10 questions
        if(count == questions.length){
            String message ="";
            if(score > 7){
                message += "You got " + score + "/10 correct!";
                message += "\nYou're the smartest cat in the planet!";
            }else if(score < 7){
                message += "You got " + score + "/10 correct!";
                message += "\nYou need to brush up on your cat facts!";
            }

            Intent intent = new Intent(this, ShowResults.class);
            intent.putExtra(EXTRA_MESSAGE,message);
            startActivity(intent);

        }else {
            getQuestion();
        }
    }
}
