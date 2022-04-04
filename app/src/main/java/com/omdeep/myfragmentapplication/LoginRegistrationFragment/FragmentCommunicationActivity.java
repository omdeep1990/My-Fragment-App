package com.omdeep.myfragmentapplication.LoginRegistrationFragment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.omdeep.myfragmentapplication.Interfaces.OnInputListener;
import com.omdeep.myfragmentapplication.R;
import com.omdeep.myfragmentapplication.databinding.ActivityFragmentCommunicationBinding;


public class FragmentCommunicationActivity extends AppCompatActivity implements OnInputListener {
    private ActivityFragmentCommunicationBinding binding;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentCommunicationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //TODO: Adding a fragment in activity
       addFragment();

        binding.signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.loginUp.setVisibility(View.VISIBLE);
                binding.signUp.setVisibility(View.INVISIBLE);
                Fragment fragment = new RegistrationFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container1, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        binding.loginUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.loginUp.setVisibility(View.INVISIBLE);
                binding.signUp.setVisibility(View.VISIBLE);
                Fragment fragment = new LoginSenderFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container1, fragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
//
            }
        });
    }
    public void addFragment() {
        binding.loginUp.setVisibility(View.INVISIBLE);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container1, new LoginSenderFragment());
        fragmentTransaction.commit();
    }


    @Override
    public void input(String inputString) {
        binding.signUp.setVisibility(View.INVISIBLE);
        DisplayDataFragment fragment = new DisplayDataFragment();
        Bundle bundle = new Bundle();
        bundle.putString("input", inputString);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container1, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Alert Dialogue");
        dialog.setMessage("Do you want to exit?");
        dialog.setCancelable(false);
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finishAffinity();

            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
            }
        });
        dialog.create().show();
    }
}