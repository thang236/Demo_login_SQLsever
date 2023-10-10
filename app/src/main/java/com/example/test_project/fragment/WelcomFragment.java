package com.example.test_project.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.test_project.R;
import com.example.test_project.databinding.FragmentWelcomBinding;


public class WelcomFragment extends Fragment {
    FragmentWelcomBinding binding;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentWelcomBinding.inflate(inflater, container , false);
        listener();

        return binding.getRoot();
    }

    private void listener() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout, new LoginFragment()).addToBackStack(null).commit();

            }
        });
        binding.btnTaotk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout, new SigninFragment()).addToBackStack(null).commit();
            }
        });
    }
}