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
 * {@link TopicDescription.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TopicDescription#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TopicDescription extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "topic";
    private static final String ARG_PARAM2 = "desc";
    private static final String ARG_PARAM3 = "num";


    private String topic;
    private String desc;
    private int numQues;

    Activity hostActivity;

    private OnFragmentInteractionListener mListener;



    public static TopicDescription newInstance(String topic, String desc, int numQues) {
        TopicDescription fragment = new TopicDescription();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, topic);
        args.putString(ARG_PARAM2, desc);
        args.putInt(ARG_PARAM3, numQues);
        fragment.setArguments(args);
        return fragment;
    }

    public TopicDescription() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            topic = getArguments().getString(ARG_PARAM1);
            desc = getArguments().getString(ARG_PARAM2);
            numQues = getArguments().getInt(ARG_PARAM3);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_topic_description, container, false);

        TextView text = (TextView)v.findViewById(R.id.topic);
        text.setText((CharSequence)topic);
        TextView description = (TextView)v.findViewById(R.id.desc);
        description.setText((CharSequence)desc);
        TextView n = (TextView)v.findViewById(R.id.num);
        n.setText((CharSequence)("This quiz has " + "" + numQues + " questions"));



        Button begin = (Button)v.findViewById(R.id.begin);
        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //load question fragment
                //set args
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
        this.hostActivity = activity;
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
