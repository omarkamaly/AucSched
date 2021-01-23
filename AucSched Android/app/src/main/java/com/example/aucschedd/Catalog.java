package com.example.aucschedd;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;

public class Catalog extends AppCompatDialogFragment {
    public String Major_select="";


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.activity_catalog, null);
        builder.setView(view).setTitle("Go To Catalog")
                .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDialog().dismiss();
                    }
                })
                .setPositiveButton("Find Catalog", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(Major_select.equals("Computer Engineering")){
                            String ce = "http://catalog.aucegypt.edu/preview_program.php?catoid=20&poid=2942&returnto=839";
                            Uri webaddr = Uri.parse(ce);
                            Intent goToCE = new Intent(Intent.ACTION_VIEW, webaddr);

                            startActivity(goToCE);
                        }else {
                            String cs = "http://catalog.aucegypt.edu/preview_program.php?catoid=20&poid=2943";
                            Uri webaddr = Uri.parse(cs);
                            Intent goToCs = new Intent(Intent.ACTION_VIEW, webaddr);

                            startActivity(goToCs);
                        }
                    }
                });

        Spinner spinnerCat = (Spinner) view.findViewById(R.id.spinnerCat);
        //Create an Array Adapter
        ArrayAdapter<CharSequence> adapterCat = ArrayAdapter.createFromResource(getActivity(),
                R.array.Majors,
                android.R.layout.simple_spinner_item);
        //Specify layout used when chpoices appear
        adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Apply adapter to spinner
        spinnerCat.setAdapter(adapterCat);
        //spinnerCat.setOnItemSelectedListener(this);
        spinnerCat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Major_select = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return builder.create();
    }


}
