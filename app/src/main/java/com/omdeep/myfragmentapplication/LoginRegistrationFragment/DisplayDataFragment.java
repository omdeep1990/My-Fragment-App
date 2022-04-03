package com.omdeep.myfragmentapplication.LoginRegistrationFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omdeep.myfragmentapplication.R;
import com.omdeep.myfragmentapplication.databinding.FragmentDisplayBinding;
import com.omdeep.myfragmentapplication.databinding.FragmentDisplayDataBinding;


public class DisplayDataFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentDisplayDataBinding binding = FragmentDisplayDataBinding.inflate(getLayoutInflater());
        Bundle bundle = getArguments();
        binding.displayWelcome.setText(bundle.getString("input"));
        return binding.getRoot();
    }
}