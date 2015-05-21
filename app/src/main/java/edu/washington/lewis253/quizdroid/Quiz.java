package edu.washington.lewis253.quizdroid;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Quiz extends ActionBarActivity {

    Topic topic;
    int numCorrect;
    int qnum;
    QuizApp app;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        app = (QuizApp) getApplication();


        String chosen = getIntent().getExtras().getString("topic");
        for(Topic t : app.topics) {
            if(t.title.equals(chosen)) {
                topic = t;
                break;
            }
        }
        numCorrect = 0;
        qnum = 1;
        String desc = topic.desc;
        int numQues = topic.questions.size();
        //String desc = getIntent().getExtras().getString("desc");
        //int numQues = getIntent().getExtras().getInt("num");



        if (savedInstanceState == null) {

            FragmentManager m = getFragmentManager();
            FragmentTransaction t = m.beginTransaction();

            Bundle b = new Bundle();
            b.putString("chosen", chosen);

            TopicDescription d = new TopicDescription();
            d.setArguments(b);

            t.add(R.id.container, d);
            t.setTransition(1);
            t.commit();


        }


    }

    public void loadQuestion() {
        FragmentManager m = getFragmentManager();
        FragmentTransaction t = m.beginTransaction();

        Bundle b = new Bundle();
        b.putString("topic", topic.title);
        b.putInt("qnum", qnum);

        QuestionFragment q = new QuestionFragment();
        q.setArguments(b);

        t.replace(R.id.container, q);
        t.setTransition(6);
        t.commit();

    }

    public void loadAnswer(Question question, int guess) {

        if(guess == question.answer) {
            numCorrect++;
        }
        FragmentManager m = getFragmentManager();
        FragmentTransaction t = m.beginTransaction();

        Bundle b = new Bundle();
        b.putString("ans", question.ans.get(guess - 1));
        b.putString("corr", question.ans.get(question.answer - 1));
        b.putInt("qnum", qnum);
        b.putInt("numCorr", numCorrect);

        AnswerFragment q = new AnswerFragment();
        q.setArguments(b);

        t.replace(R.id.container, q);
        t.setTransition(6);
        t.commit();
        qnum++;
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
