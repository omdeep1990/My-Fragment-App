package com.omdeep.myfragmentapplication.FragmentPractice;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.omdeep.myfragmentapplication.databinding.FragmentDisplayBinding;


public class DisplayFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentDisplayBinding binding = FragmentDisplayBinding.inflate(getLayoutInflater());
        Bundle bundle = getArguments();
        binding.tvDisplay.setText(bundle.getString("input"));
        return binding.getRoot();
    }
}