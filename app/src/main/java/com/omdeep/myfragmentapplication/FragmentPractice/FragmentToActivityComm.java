package com.omdeep.myfragmentapplication.FragmentPractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.omdeep.myfragmentapplication.Interfaces.OnInputListener;
import com.omdeep.myfragmentapplication.R;
import com.omdeep.myfragmentapplication.databinding.ActivityFragmentToCommBinding;


public class FragmentToActivityComm extends AppCompatActivity implements OnInputListener {
    private ActivityFragmentToCommBinding binding;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragmentToCommBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new FirstFragment());
        fragmentTransaction.commit();

    }

    @Override
    public void input(String inputString) {
        binding.tvDisplay.setText(inputString);
    }
}