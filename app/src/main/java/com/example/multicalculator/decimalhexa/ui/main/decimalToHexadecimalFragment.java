package com.example.multicalculator.decimalhexa.ui.main;

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

public class decimalToHexadecimalFragment extends Fragment {

    PageViewModel pageViewModel;

    public static decimalToHexadecimalFragment newInstance() {
        return new decimalToHexadecimalFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(requireActivity()).get(com.example.multicalculator.decimalhexa.ui.main.PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_decimal_to_hexadecimal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText decimalInputText = view.findViewById(R.id.decimalInputText2);
        TextView hexadecimalOutputText = view.findViewById(R.id.hexadecimalOutputText2);
        Button convertButton = view.findViewById(R.id.convertButton5);
        Button clearButton = view.findViewById(R.id.clearButton5);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(decimalInputText.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Please Enter a Number", Toast.LENGTH_SHORT).show();

                } else {

                    String number = decimalInputText.getText().toString();
                    int number2 = Integer.parseInt(number);
                    hexadecimalOutputText.setText(Integer.toHexString(number2).toUpperCase());
                }
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decimalInputText.setText("");
                hexadecimalOutputText.setText("");
            }
        });
    }
}