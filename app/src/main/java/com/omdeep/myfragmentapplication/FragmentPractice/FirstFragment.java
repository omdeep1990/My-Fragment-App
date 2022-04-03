package com.omdeep.myfragmentapplication.FragmentPractice;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omdeep.myfragmentapplication.Interfaces.OnInputListener;
import com.omdeep.myfragmentapplication.Utility.Utility;
import com.omdeep.myfragmentapplication.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    private FragmentFirstBinding binding;
    private OnInputListener listener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(getLayoutInflater());

        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null){
                    listener.input(binding.tilInput.getEditText().getText().toString());
                }else {
                    Utility.showLongToast(getActivity(), "Something went wrong.");
                }
            }
        });
        return binding.getRoot();
    }

//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        Activity activity = (Activity) context;
//        listener = (OnInputListener) activity;
//    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        listener = (OnInputListener) activity;
    }
}