package edu.washington.lewis253.quizdroid;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.util.Log;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link QuestionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link QuestionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class QuestionFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "topic";
    private static final String ARG_PARAM2 = "qnum";

    // TODO: Rename and change types of parameters
    private String topic;
    private int qnum;

    Activity hostActivity;

    private OnFragmentInteractionListener mListener;


    String question;
    String[] answers;
    int correct;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioButton r4;

    public static QuestionFragment newInstance(String topic, int qnum) {
        QuestionFragment fragment = new QuestionFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, topic);
        args.putInt(ARG_PARAM2, qnum);
        fragment.setArguments(args);
        return fragment;
    }

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            topic = getArguments().getString(ARG_PARAM1);
            qnum = getArguments().getInt(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_question, container, false);


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

        TextView questionLabel = (TextView) v.findViewById(R.id.question);
        questionLabel.setText((CharSequence)question);

        r1 = (RadioButton) v.findViewById(R.id.ans1);
        r2 = (RadioButton) v.findViewById(R.id.ans2);
        r3 = (RadioButton) v.findViewById(R.id.ans3);
        r4 = (RadioButton) v.findViewById(R.id.ans4);


        r1.setText((CharSequence)answers[0]);
        r2.setText((CharSequence)answers[1]);
        r3.setText((CharSequence)answers[2]);
        r4.setText((CharSequence)answers[3]);

        Button submit = (Button) v.findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hostActivity instanceof Quiz) {
                    if (r1.isChecked()) {
                        ((Quiz)hostActivity).loadAnswer(1, correct, answers[0], answers[correct - 1]);
                    } else if (r2.isChecked()) {
                        ((Quiz)hostActivity).loadAnswer(2, correct, answers[1], answers[correct - 1]);
                    } else if(r3.isChecked()) {
                        ((Quiz)hostActivity).loadAnswer(3, correct, answers[2], answers[correct - 1]);
                    } else if(r4.isChecked()) {
                        ((Quiz)hostActivity).loadAnswer(4, correct, answers[3], answers[correct - 1]);
                    }
                }
            }
        });

        return v;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        hostActivity = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }

}
