package ru.payts.cycleactivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SomeFragment extends Fragment {
    private String TAG = "[SomeFragment]";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SomeFragment newInstance(String param1, String param2) {
        SomeFragment fragment = new SomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        makeMessage("onCreate()");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        makeMessage("onCreateView()");
        return inflater.inflate(R.layout.fragment_some, container, false);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        makeMessage("onAttach()");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        makeMessage("onActivityCreated()");
    }

    @Override
    public void onStart() {
        super.onStart();
        makeMessage("onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        makeMessage("onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        makeMessage("onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        makeMessage("onStop()");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        makeMessage("onDestroyView()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        makeMessage("onDestroy()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        makeMessage("onDetach()");
    }

    private void makeMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        Log.i(TAG, message);
    }
}
