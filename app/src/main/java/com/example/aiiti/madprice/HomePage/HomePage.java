package com.example.aiiti.madprice.HomePage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.aiiti.madprice.AddDevicePage.AddDevicePage;
import com.example.aiiti.madprice.LoginPage.LoginPage;
import com.example.aiiti.madprice.R;
import com.example.aiiti.madprice.RegPage.RegPage;
import com.example.aiiti.madprice.SearchPage.SearchPage;

public class HomePage extends AppCompatActivity {
    Button v_reg,v_search,v_login,v_Adb;
    EditText v_dvedt;
    String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        v_dvedt= (EditText) findViewById(R.id.dnedt);
        v_reg=(Button)findViewById(R.id.regbtn);
        v_login=(Button)findViewById(R.id.loginbtn);
        v_search= (Button) findViewById(R.id.searchbtn);
        v_Adb= (Button) findViewById(R.id.adbtn);

        v_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=v_dvedt.getText().toString();
                Intent intent=new Intent(HomePage.this, SearchPage.class);
                startActivity(intent);
            }
        });

        v_Adb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this, AddDevicePage.class);
                startActivity(intent);
            }
        });

        v_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this, LoginPage.class);
                startActivity(intent);
            }
        });

        v_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HomePage.this, RegPage.class);
                startActivity(intent);
            }
        });
    }
}