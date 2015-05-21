package edu.washington.lewis253.quizdroid;
import android.content.SharedPreferences;
import android.util.Log;

import org.json.*;

import java.util.*;
import java.io.*;
import android.content.SharedPreferences;


/**
 * Created by kray on 5/20/15.
 */

class Question {

    String ques;
    int answer;
    List<String> ans;

    public Question(){}

}

class Topic {
    String title;
    String sDesc;
    String desc;
    List<Question> questions;

    public Topic() {}

}

interface TopicRepository {

    public List<Topic> getAllTopics();
    public List<Topic> getAllTopicsByKeyword(String keyword);

}


public class QuizApp extends android.app.Application implements TopicRepository {

    private static QuizApp myApp = null;
    List<Question> questions;
    List<Topic> topics;
    SharedPreferences prefs;


    public QuizApp() {

        if(myApp == null) {
            myApp = this;
        } else {
            Log.e("QuizApp", "Cannot create two instances of QuizApp");
        }
    }

    @Override
    public void onCreate() {

        super.onCreate();
        Log.i("QuizApp", "onCreate() fired, quizapp");

        prefs = getSharedPreferences("prefs.xml", 0);
        //set background task based on preferences.
        FetchQuiz fetch = new FetchQuiz();
        fetch.onStartComman

        questions = new ArrayList<Question>();
        topics = new ArrayList<Topic>();

        String json = null;
        try {
            InputStream input = getAssets().open("questions.json");
            json = readJSONFile(input);
            JSONArray jsonData = new JSONArray(json);
            for(int i = 0; i < jsonData.length(); i++) {
                Topic topic = new Topic();
                JSONObject t = jsonData.getJSONObject(i);
                topic.title = t.getString("title");
                topic.sDesc = t.getString("desc");
                topic.desc = t.getString("desc");
                topic.questions = new ArrayList<Question>();

                JSONArray qs = t.getJSONArray("questions");

                for(int j = 0; j < qs.length(); j++) {

                    Question q = new Question();
                    JSONObject ques = qs.getJSONObject(j);
                    q.ques = ques.getString("text");
                    q.answer = ques.getInt("answer");

                    List<String> listAnswers = new ArrayList<String>();
                    JSONArray answers = ques.getJSONArray("answers");
                    for(int k = 0; k < answers.length(); k++) {
                        listAnswers.add(answers.getString(k));
                    }
                    q.ans = listAnswers;
                    topic.questions.add(q);
                }


                topics.add(topic);
            }


        } catch(IOException e) {
            e.printStackTrace();
        } catch(JSONException e) {
            e.printStackTrace();
        }

    }

    public String readJSONFile(InputStream input) throws IOException {

        int size = input.available();
        byte[] buffer = new byte[size];
        input.read(buffer);
        input.close();

        return new String(buffer, "UTF-8");
    }

    @Override
    public List<Topic> getAllTopics() {
        return topics;
    }

    @Override
    public List<Topic> getAllTopicsByKeyword(String keyword) {
        List<Topic> results = new ArrayList<Topic>();
        for(Topic topic : topics) {
            if(topic.title.equalsIgnoreCase("keyword")) {
                results.add(topic);
            }
        }
        return results;
    }
}
