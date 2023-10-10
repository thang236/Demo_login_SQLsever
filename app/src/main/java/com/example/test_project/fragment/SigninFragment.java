package com.example.test_project.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.test_project.Controller.EmployeesDao;
import com.example.test_project.databinding.FragmentSigninBinding;


public class SigninFragment extends Fragment {
    FragmentSigninBinding binding;
    String username, password, phoneNumber, lastName, fistName;
    boolean isAdmin = false;
    EmployeesDao dao;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSigninBinding.inflate(inflater, container, false);
        dao = new EmployeesDao();
        listener();

        return binding.getRoot();
    }
    private void listener() {
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        username = binding.edUsername.getText().toString().trim();
        password = binding.edPassword.getText().toString().trim();
        lastName = binding.edLastname.getText().toString().trim();
        fistName = binding.edFistName.getText().toString().trim();
        phoneNumber = binding.edPhone.getText().toString().trim();

        boolean check = dao.checkIfUserExists(username);

        isAdmin= binding.rdoAdmin.isChecked();

        if (username.isEmpty() || password.isEmpty() || lastName.isEmpty() || fistName.isEmpty() || phoneNumber.isEmpty()) {
            Toast.makeText(getContext(), "Hãy điền tất cả các trường", Toast.LENGTH_SHORT).show();
        }else if (check){
            binding.edUsername.setError("Username đã tồn tài");
        }else {
            dao.register(username,password,fistName,lastName,phoneNumber,isAdmin);
            Toast.makeText(getContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
        }


    }
}