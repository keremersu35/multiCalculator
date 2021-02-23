package com.example.multicalculator.binaryhexa.ui.main;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
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
import com.example.multicalculator.ui.main.PageViewModel;
import com.example.multicalculator.ui.main.binaryToDecimalFragment;

public class hexadecimalToBinaryFragment extends Fragment {

    PageViewModel pageViewModel;

    public static hexadecimalToBinaryFragment newInstance() {
        return new hexadecimalToBinaryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_hexadecimal_to_binary, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText hexadecimalInputText = view.findViewById(R.id.hexadecimalInputText);
        TextView binaryOutputText = view.findViewById(R.id.binaryOutputText2);
        Button convertButton = view.findViewById(R.id.convertButton4);
        Button clearButton = view.findViewById(R.id.clearButton4);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (hexadecimalInputText.getText().toString().matches("")) {
                    Toast.makeText(getActivity(), "Please Enter a Number", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int binaryFromHex = Integer.parseInt(hexadecimalInputText.getText().toString(), 16);
                        binaryOutputText.setText(Integer.toBinaryString(binaryFromHex));

                    } catch (Exception e) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
                        alert.setTitle("INVALID");
                        alert.setMessage("Hexadecimal numbers can include letters A to F, Try Again?");
                        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                hexadecimalToBinaryFragment.newInstance();
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

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hexadecimalInputText.setText("");
                binaryOutputText.setText("");
            }
        });
    }
}