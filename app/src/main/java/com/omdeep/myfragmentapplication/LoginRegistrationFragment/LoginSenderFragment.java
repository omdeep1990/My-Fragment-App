package com.omdeep.myfragmentapplication.LoginRegistrationFragment;

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
import com.omdeep.myfragmentapplication.databinding.FragmentLoginSenderBinding;

public class LoginSenderFragment extends Fragment {
    private FragmentLoginSenderBinding binding;
    private OnInputListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        binding = FragmentLoginSenderBinding.inflate(inflater, container, false);

        binding.login.setOnClickListener(view -> {
            if (listener != null) {
                listener.input("Welcome" + " " +binding.username.getEditText().getText().toString());
//                    listener.input("Welcome" + " " +binding.username.getEditText().getText().toString()+ " "+binding.password.getEditText().getText().toString());
            } else {
                Utility.showLongToast(getActivity(), "Something went wrong.");
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        listener = (OnInputListener) activity;
    }
}