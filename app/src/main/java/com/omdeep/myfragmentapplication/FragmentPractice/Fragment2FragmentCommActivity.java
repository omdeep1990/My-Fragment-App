package com.omdeep.myfragmentapplication.FragmentPractice;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.omdeep.myfragmentapplication.Interfaces.OnInputListener;
import com.omdeep.myfragmentapplication.R;
import com.omdeep.myfragmentapplication.databinding.ActivityFragment2FragmentCommBinding;

public class Fragment2FragmentCommActivity extends AppCompatActivity  implements OnInputListener {
    private ActivityFragment2FragmentCommBinding binding;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFragment2FragmentCommBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, new FragmentSender());
        fragmentTransaction.commit();
    }

    @Override
    public void input(String inputString) {
        DisplayFragment fragment = new DisplayFragment();
        Bundle bundle = new Bundle();
        bundle.putString("input", inputString);
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}