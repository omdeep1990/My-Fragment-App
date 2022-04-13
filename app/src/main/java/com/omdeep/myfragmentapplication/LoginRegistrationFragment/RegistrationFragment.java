package com.omdeep.myfragmentapplication.LoginRegistrationFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.omdeep.myfragmentapplication.R;
import com.omdeep.myfragmentapplication.Utility.Keys;
import com.omdeep.myfragmentapplication.Utility.Utility;
import com.omdeep.myfragmentapplication.databinding.FragmentRegistrationBinding;

public class RegistrationFragment extends Fragment {
    private FragmentRegistrationBinding binding;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onAttach(Context context) {
        sharedPreferences = context.getSharedPreferences( "user_info",
                Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        super.onAttach(context);

    }

//    @Override
//    public void onAttach(Context context) {
//        sharedPreferences = context.getSharedPreferences( "usersFile",
//                Context.MODE_PRIVATE);
//        editor = sharedPreferences.edit();
//        super.onAttach(context);
//
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater, container, false);

        binding.register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username2 = binding.username.getText().toString();
                String password2 = binding.password.getText().toString();
                if (username2.isEmpty() && password2.isEmpty()) {
                    Utility.showLongToast(getContext(), "Please enter the details completely.");
                } else {
                    editor.putString(Keys.USER_NAME, username2);
                    editor.putString(Keys.PASS_WORD, password2);
                    editor.commit();
                    Utility.showLongToast(getContext(), "Registered Successfully...");
                    replaceRegisFragToLoginFrag(new LoginSenderFragment());


                }

            }
        });
        return binding.getRoot();
    }

    private void replaceRegisFragToLoginFrag(LoginSenderFragment loginFragment) {


        // create a FragmentManager
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragTransaction = fragmentManager.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragTransaction.replace(R.id.fragment_container1, loginFragment);
        // save the changes
        fragTransaction.commit();
    }
}