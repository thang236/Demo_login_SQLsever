package com.example.test_project.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.test_project.Controller.EmployeesDao;
import com.example.test_project.R;
import com.example.test_project.databinding.FragmentLoginBinding;


public class LoginFragment extends Fragment {
    FragmentLoginBinding binding;
    String username, password;
    EmployeesDao dao;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container,false);
        dao = new EmployeesDao();
        listtener();


        return binding.getRoot();

    }
    private void listtener() {
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    private void validate() {
        username = binding.edUsername.getText().toString().trim();
        password = binding.edPassword.getText().toString().trim();

        if (username.isEmpty() || password.isEmpty()) {
            Toast.makeText(getContext(), "Vui lòng không để trống các trường", Toast.LENGTH_SHORT).show();
        }else
        {
            dangNhap();
        }
    }


    private void dangNhap() {
       boolean check = dao.login(username,password);
       if (check){
           Toast.makeText(getContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
       }else {
           Toast.makeText(getContext(), "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
       }
    }

}