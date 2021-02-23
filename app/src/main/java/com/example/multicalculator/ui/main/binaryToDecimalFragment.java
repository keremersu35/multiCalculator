package com.example.multicalculator.ui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.multicalculator.MainActivity;
import com.example.multicalculator.R;

public class binaryToDecimalFragment extends Fragment {

    PageViewModel pageViewModel;

    public static binaryToDecimalFragment newInstance(){
        return new binaryToDecimalFragment();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_binary_to_decimal,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText binaryInputText = view.findViewById(R.id.binaryInputText);
        TextView decimalOutputText = view.findViewById(R.id.decimalOutputText);
        Button convertButton = view.findViewById(R.id.convertButton);
        Button clearButton = view.findViewById(R.id.clearButton);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binaryInputText.setText("");
                decimalOutputText.setText("");
            }
        });

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (binaryInputText.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Please Enter a Number", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int decimal = Integer.parseInt(binaryInputText.getText().toString(), 2);
                        String decimalResult = String.valueOf(decimal);
                        decimalOutputText.setText(decimalResult);
                    } catch (Exception e) {

                        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                        alert.setTitle("INVALID");
                        alert.setMessage("Only Binary, Try Again?");
                        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                binaryToDecimalFragment.newInstance();
                            }
                        });
                        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(getActivity(), "Back To Menu", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                startActivity(intent);
                            }
                        });
                        alert.show();
                    }
                }
            }
        });
}}