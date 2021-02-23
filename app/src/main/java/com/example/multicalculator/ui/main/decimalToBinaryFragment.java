package com.example.multicalculator.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multicalculator.R;


public class decimalToBinaryFragment extends Fragment {

    PageViewModel pageViewModel;

    public static decimalToBinaryFragment newInstance(){
        return  new decimalToBinaryFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_decimal_to_binary,container,false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText decimalInputText = view.findViewById(R.id.decimalInputText);
        TextView binaryOutputText = view.findViewById(R.id.binaryOutputText);
        Button convertButton2 = view.findViewById(R.id.convertButton2);
        Button clearButton2 = view.findViewById(R.id.clearButton2);

        convertButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (decimalInputText.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Please Enter a Number", Toast.LENGTH_SHORT).show();

                } else {
                    String number = decimalInputText.getText().toString();
                    int number2 = Integer.parseInt(number);
                    binaryOutputText.setText(Integer.toBinaryString(number2));
                }
            }
            });

        clearButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimalInputText.setText("");
                binaryOutputText.setText("");
            }
        });
    }
}