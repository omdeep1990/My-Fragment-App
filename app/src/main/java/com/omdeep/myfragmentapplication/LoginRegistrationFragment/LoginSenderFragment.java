package com.omdeep.myfragmentapplication.LoginRegistrationFragment;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omdeep.myfragmentapplication.Interfaces.OnInputListener;
import com.omdeep.myfragmentapplication.Utility.Keys;
import com.omdeep.myfragmentapplication.Utility.Utility;
import com.omdeep.myfragmentapplication.databinding.ActivityFragmentCommunicationBinding;
import com.omdeep.myfragmentapplication.databinding.FragmentLoginSenderBinding;

public class LoginSenderFragment extends Fragment {
    private FragmentLoginSenderBinding binding;
    private OnInputListener listener;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //TODO: Inflate the layout for this fragment
        binding = FragmentLoginSenderBinding.inflate(inflater, container, false);

        sharedPreferences = getContext().getSharedPreferences("user_info", MODE_PRIVATE);
        editor = sharedPreferences.edit();


        binding.login.setOnClickListener(view -> {


           String userName1 =  binding.username.getText().toString();
           String password1 = binding.password.getText().toString();
//            editor.putString(Keys.USER_NAME, binding.username.getEditText().toString());
//            editor.putString(Keys.PASS_WORD, binding.password.getEditText().toString());

//            String fname = sharedPreferences.getString(Keys.FIRST_NAME, "");
            String userName = sharedPreferences.getString(Keys.USER_NAME, "null");
            String passWord = sharedPreferences.getString(Keys.PASS_WORD, "null");

//            binding.name.setText(userName+ " " +passWord);

            if (userName1.equals(userName) && password1.equals(passWord)) {
                Utility.showLongToast(getContext(), "Login Successfull....");
                listener.input("Welcome" + " " +userName);
            } else if (userName1.isEmpty() && password1.isEmpty()) {
                Utility.showShortToast(getContext(), "Please enter details correctly");
            } else {
                    Utility.showShortToast(getContext(), "Please Register first");
                }

        });

        return binding.getRoot();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);
        Activity activity = (Activity) context;
        listener = (OnInputListener) activity;


    }
}