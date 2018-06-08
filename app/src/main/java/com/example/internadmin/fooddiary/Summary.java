package com.example.internadmin.fooddiary;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Summary extends Fragment {
    LinearLayout ll;
    public Summary() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null)
            return;

        ll = new LinearLayout(getContext());
        ll.setOrientation(LinearLayout.VERTICAL);
        TextView t = new TextView(getContext());
        t.setText("this");
        ll.addView(t);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        return ll;
    }

}
