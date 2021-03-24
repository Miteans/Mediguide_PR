package com.example.trial1;
import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link med_add_second_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class med_add_second_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public med_add_second_fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment med_add_second_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static med_add_second_fragment newInstance(String param1, String param2) {
        med_add_second_fragment fragment = new med_add_second_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View  view = inflater.inflate(R.layout.med_add_page_two, container, false);
        TextInputEditText number = (TextInputEditText) view.findViewById(R.id.freq_intake);

        TextWatcher watcher= new TextWatcher() {
            public void afterTextChanged(Editable s) {
                if (!(number.getText().toString().equals(""))) {
                    try {
                        int value = Integer.parseInt(number.getText().toString());
                        addFormFields(value,view);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                }

            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Do something or nothing.
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //Do something or nothing
            }
        };

        number.addTextChangedListener(watcher);

        return view;
    }

    public void addFormFields(int number, View view){
        System.out.println(number);
        LinearLayout time_addView = (LinearLayout) view.findViewById(R.id.time_add);

        if(time_addView.getChildCount() > 0){
            time_addView.removeAllViews();
        }

        for(int i=1;i<=number;i++){
            TextInputLayout timeTextInputLayout = new TextInputLayout(view.getContext());
            timeTextInputLayout.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            if(i == 1)
                timeTextInputLayout.setHint("Set Your 1st dose timing");
            else if(i == 2)
                timeTextInputLayout.setHint("Set Your 2nd dose timing");
            else if(i == 3)
                timeTextInputLayout.setHint("Set Your 3rd dose timing");
            else
                timeTextInputLayout.setHint("Set Your "+ i +"th dose timing");

            timeTextInputLayout.setBoxBackgroundMode(TextInputLayout.BOX_BACKGROUND_OUTLINE);
            timeTextInputLayout.setBoxStrokeColor(getResources().getColor(R.color.primary));
            timeTextInputLayout.setHintTextColor(ColorStateList.valueOf(getResources().getColor(R.color.primary)));
            timeTextInputLayout.setBoxBackgroundColor(getResources().getColor(R.color.transparent));
            timeTextInputLayout.setBoxCornerRadii(5, 5, 5, 5);
            timeTextInputLayout.setPadding(10, 0, 10, 10);
            TextInputEditText edtTime = new TextInputEditText(timeTextInputLayout.getContext());
            timeTextInputLayout.addView(edtTime);
            time_addView.addView(timeTextInputLayout);
        }
    }
}