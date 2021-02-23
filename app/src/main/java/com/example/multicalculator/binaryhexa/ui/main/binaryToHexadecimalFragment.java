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

public class binaryToHexadecimalFragment extends Fragment {

    PageViewModel pageViewModel;

    public static binaryToHexadecimalFragment newInstance(){
        return new binaryToHexadecimalFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = new ViewModelProvider(requireActivity()).get(PageViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_binary_to_hexadecimal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        EditText binaryInputText = view.findViewById(R.id.binaryInputText2);
        TextView hexadecimalOutputText = view.findViewById(R.id.hexadecimalOutputText);
        Button convertButton = view.findViewById(R.id.convertButton3);
        Button clearButton = view.findViewById(R.id.clearButton3);

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(binaryInputText.getText().toString().matches(""))
                {
                    Toast.makeText(getActivity(),"Please Enter Number",Toast.LENGTH_SHORT).show();
                }
                else
                {
                try {
                    int decimal= Integer.parseInt(binaryInputText.getText().toString(),2);
                    hexadecimalOutputText.setText(Integer.toHexString(decimal).toUpperCase());
                }
                catch (Exception e)
                {

                    AlertDialog.Builder alert = new AlertDialog.Builder(getContext());
                    alert.setTitle("INVALID");
                    alert.setMessage("Only Binary, Try Again?");
                    alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            binaryToHexadecimalFragment.newInstance();
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
                binaryInputText.setText("");
                hexadecimalOutputText.setText("");
            }
        });
    }
}