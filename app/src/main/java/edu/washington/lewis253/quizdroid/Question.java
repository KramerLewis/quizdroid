package edu.washington.lewis253.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;


public class Question extends ActionBarActivity {

    Intent intent;
    int correct;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;

    String[] answers;
    String question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        intent = new Intent(this, Answer.class);

        String topic = getIntent().getExtras().getString("topic");
        intent.putExtra("topic", topic);
        int qnum = getIntent().getExtras().getInt("qnum");
        intent.putExtra("qnum", qnum);
        Log.i("questions", "" + qnum);
        Log.i("questions", "" + intent.getExtras().getInt("qnum"));
        intent.putExtra("numcorr", getIntent().getExtras().getInt("numcorr"));
        switch (qnum) {
            case 1:
                switch (topic) {
                    case "Math":
                        question = "What is 1 + 1?";
                        answers = new String[]{"1", "11", "0", "2"};
                        correct = 4;
                        break;
                    case "Physics":
                        question = "If you drop a baseball from the standing position, which direction does it go?";
                        answers = new String[]{"up", "down", "left", "right"};
                        correct = 2;
                        break;
                    case "Marvel Super Heroes":
                        question = "Who is the superhero that can run super fast?";
                        answers = new String[]{"Batman", "Spiderman", "Flash", "The Green Lantern"};
                        correct = 3;
                        break;

                }
                break;
            case 2:
                switch (topic) {
                    case "Math":
                        question = "What is 2 + 2?";
                        answers = new String[]{"2", "22", "0", "4"};
                        correct = 4;
                        break;
                    case "Physics":
                        question = "If you throw a baseball from the standing position, which direction does it go?";
                        answers = new String[]{"up", "down", "horizontal", "nowhere"};
                        correct = 3;
                        break;
                    case "Marvel Super Heroes":
                        question = "Who is the superhero that can fly?";
                        answers = new String[]{"Batman", "Spiderman", "Flash", "Superman"};
                        correct = 4;
                        break;

                }
                break;

        }

        TextView questionLabel = (TextView) findViewById(R.id.question);
        questionLabel.setText((CharSequence)question);


        intent.putExtra("correct", correct);
        intent.putExtra("corr", answers[correct - 1]);



        r1 = (RadioButton) findViewById(R.id.ans1);
        r2 = (RadioButton) findViewById(R.id.ans2);
        r3 = (RadioButton) findViewById(R.id.ans3);
        r4 = (RadioButton) findViewById(R.id.ans4);

        r1.setText((CharSequence)answers[0]);
        r2.setText((CharSequence)answers[1]);
        r3.setText((CharSequence)answers[2]);
        r4.setText((CharSequence)answers[3]);



        Button submit = (Button) findViewById(R.id.submit);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (r1.isChecked()) {
                    intent.putExtra("ans", 1);
                    intent.putExtra("answer", answers[0]);
                    startActivity(intent);
                } else if (r2.isChecked()) {
                    intent.putExtra("ans", 2);
                    intent.putExtra("answer", answers[1]);
                    startActivity(intent);
                } else if(r3.isChecked()) {
                    intent.putExtra("ans", 3);
                    intent.putExtra("answer", answers[2]);
                    startActivity(intent);
                } else if(r4.isChecked()) {
                    intent.putExtra("ans", 4);
                    intent.putExtra("answer", answers[3]);
                    startActivity(intent);
                }
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_question, menu);
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
