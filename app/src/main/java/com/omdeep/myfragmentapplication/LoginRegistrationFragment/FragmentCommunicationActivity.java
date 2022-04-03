package com.omdeep.myfragmentapplication.LoginRegistrationFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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

        binding.loginUp.setVisibility(View.INVISIBLE);
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container1, new LoginSenderFragment());
        fragmentTransaction.commit();

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
    }



    @Override
    public void input(String inputString) {
        DisplayDataFragment fragment = new DisplayDataFragment();
        Bundle bundle = new Bundle();
        bundle.putString("input", inputString);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container1, fragment);
        fragmentTransaction.commit();
    }
}