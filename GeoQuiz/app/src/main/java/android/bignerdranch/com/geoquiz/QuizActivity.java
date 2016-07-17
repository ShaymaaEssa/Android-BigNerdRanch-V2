package android.bignerdranch.com.geoquiz;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class QuizActivity extends ActionBarActivity {
    Button trueButton;
    Button falseButton;
    Button nextButton;
    Button prevButton;
    TextView questionText;

    List<Question> questionData = new ArrayList<Question>();
    int questionNum =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        //initialize questions data
        questionData.add(new Question(1, "Does Harrypotter consists of 7 parts?", true));
        questionData.add(new Question(2, "The name of Harrypotter's mom is Suzan.", false));
        questionData.add(new Question(3,"Java is oop language",true));
        questionData.add(new Question(4,"The Harrypotter's god father is named Serious",true));
        questionData.add(new Question(5,"Harrypotter is married Hermione at the end",false));


        trueButton = (Button) findViewById(R.id.btn_quizactivity_true);
        falseButton = (Button)findViewById(R.id.btn_quizactivity_false);
        questionText = (TextView) findViewById(R.id.txt_quizactivity_questiontxt);
        nextButton = (Button) findViewById(R.id.btn_quizactivity_next);
        prevButton = (Button)findViewById(R.id.btn_quizactivity_prev);
        prevButton.setEnabled(false);

        questionText.setText(questionData.get(questionNum).getQuestion());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionData.get(questionNum).isAnswer() == true)
                    Toast.makeText(QuizActivity.this, R.string.toast_correct, Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizActivity.this, R.string.toast_wrong, Toast.LENGTH_SHORT).show();


            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (questionData.get(questionNum).isAnswer() == false)
                    Toast.makeText(QuizActivity.this,R.string.toast_correct,Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(QuizActivity.this,R.string.toast_wrong,Toast.LENGTH_SHORT).show();

            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prevButton.setEnabled(true);
                questionNum ++;
                questionText.setText(questionData.get(questionNum).getQuestion());
                if(questionNum>=4)
                    nextButton.setEnabled(false);

            }
        });
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextButton.setEnabled(true);
                questionNum--;
                questionText.setText(questionData.get(questionNum).getQuestion());
                if (questionNum == 1)   prevButton.setEnabled(false);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
