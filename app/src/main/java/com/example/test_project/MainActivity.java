package com.example.test_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.test_project.database.DbSqlSever;
import com.example.test_project.databinding.ActivityMainBinding;
import com.example.test_project.fragment.WelcomFragment;

import java.sql.Connection;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.fram_layout, new WelcomFragment()).commit();

//        Test connect
//        DbSqlSever dbSqlServer = new DbSqlSever();
//        Connection conn = dbSqlServer.openConnect();

    }
}