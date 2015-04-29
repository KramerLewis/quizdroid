package edu.washington.lewis253.quizdroid;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;
import android.content.Intent;



public class Answer extends ActionBarActivity {

    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        int qnum = getIntent().getExtras().getInt("qnum");
        Log.i("answer", "" + qnum);

        int correct = getIntent().getExtras().getInt("correct");
        int answer = getIntent().getExtras().getInt("ans");

        String answerText = getIntent().getExtras().getString("answer");
        String corrText = getIntent().getExtras().getString("corr");



        int numcorrect = getIntent().getExtras().getInt("numcorr");
        if(correct == answer) {
            numcorrect++;
        }
        intent = new Intent(this, Question.class);
        intent.putExtra("numcorr", numcorrect);
        intent.putExtra("qnum", qnum + 1);
        String topic = getIntent().getExtras().getString("topic");
        intent.putExtra("topic", topic);

        TextView anslabel = (TextView) findViewById(R.id.answer);
        anslabel.setText((CharSequence)answerText);
        TextView corrlabel = (TextView) findViewById(R.id.correct);
        corrlabel.setText((CharSequence)corrText);
        TextView numcorr = (TextView) findViewById(R.id.numcorr);
        numcorr.setText((CharSequence)(""+numcorrect+" out of " + qnum));

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_answer, menu);
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
