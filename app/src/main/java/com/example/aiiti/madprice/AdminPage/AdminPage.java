package com.example.aiiti.madprice.AdminPage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.aiiti.madprice.AddDevicePage.AddDevicePage;
import com.example.aiiti.madprice.MD.MainActivity;
import com.example.aiiti.madprice.R;



public class AdminPage extends AppCompatActivity {
    TextView v_id;
    Button v_Adb,v_ed;
    int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_page);
        v_Adb= (Button) findViewById(R.id.adbtn);
        v_ed= (Button) findViewById(R.id.edbtn);
        Intent intent = getIntent();

        id = intent.getIntExtra("ID", 0);
        v_id = (TextView) findViewById(R.id.idtv);
        v_id.setText("Welcome " + String.valueOf(id));

        v_Adb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminPage.this,AddDevicePage.class);
                startActivity(intent);
            }
        });

        v_ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminPage.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
