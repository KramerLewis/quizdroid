package edu.washington.lewis253.quizdroid;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AnswerFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AnswerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnswerFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "ans";
    private static final String ARG_PARAM2 = "corr";
    private static final String ARG_PARAM3 = "qnum";
    private static final String ARG_PARAM4 = "numCorr";

    // TODO: Rename and change types of parameters
    private String ans;
    private String corr;
    private int qnum;
    private int numCorr;

    Activity hostActivity;

    private OnFragmentInteractionListener mListener;


    public static AnswerFragment newInstance(String ans, String corr, int qnum, int numCorr) {
        AnswerFragment fragment = new AnswerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, ans);
        args.putString(ARG_PARAM2, corr);
        args.putInt(ARG_PARAM3, qnum);
        args.putInt(ARG_PARAM4, numCorr);
        fragment.setArguments(args);
        return fragment;
    }

    public AnswerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            ans = getArguments().getString(ARG_PARAM1);
            corr = getArguments().getString(ARG_PARAM2);
            qnum = getArguments().getInt(ARG_PARAM3);
            numCorr = getArguments().getInt(ARG_PARAM4);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_answer, container, false);

        TextView anslabel = (TextView) v.findViewById(R.id.answer);
        anslabel.setText((CharSequence)ans);
        TextView corrlabel = (TextView) v.findViewById(R.id.correct);
        corrlabel.setText((CharSequence)corr);
        TextView numcorr = (TextView) v.findViewById(R.id.numcorr);
        numcorr.setText((CharSequence)(""+numCorr+" out of " + qnum));

        Button next = (Button) v.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(hostActivity instanceof Quiz) {
                    ((Quiz)hostActivity).loadQuestion();
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
