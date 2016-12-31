package com.example.aiiti.madprice.MD;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.aiiti.madprice.Edevice.EdeviceDatum;
import com.example.aiiti.madprice.Fragment.FragmentA;
import com.example.aiiti.madprice.R;

public class MainActivity extends  AppCompatActivity implements FragmentA.ListItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentA fragmentA=new FragmentA();
        android.app.FragmentManager fragmentManager=getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.activity_main,fragmentA);
        fragmentTransaction.commit();
    }

    @Override
    public void ItemSelected(EdeviceDatum employee) {

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("employee",employee);
        startActivity(intent);
    }
}