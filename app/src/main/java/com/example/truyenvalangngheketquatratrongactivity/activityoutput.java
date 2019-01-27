package com.example.truyenvalangngheketquatratrongactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class activityoutput extends AppCompatActivity {
    TextView tv_numberA, tv_numberB;
    Button btn_Result;
    int numbera;
    int  numberb;
    public static final String Result="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityoutput);
        getwiget();
        getData();
        event();
    }

    public void getData() {
         Intent intent = getIntent();
        //ten activity truyen sang va gia tri mac dinh neu truyen sang bi null thi se lay gia mac dinh
         numbera = intent.getIntExtra(MainActivity.NumberA, 0);
         numberb = intent.getIntExtra(MainActivity.NumberB, 0);
         tv_numberA.setText(numbera+"");
         tv_numberB.setText(numberb+"");
    }
       public void getwiget(){
        tv_numberA= (TextView) findViewById(R.id.tv_numberA);
        tv_numberB= (TextView) findViewById(R.id.tv_numberB);
        btn_Result= (Button) findViewById(R.id.btn_Result);
       }

     public void event(){
         btn_Result.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                int result=numbera+numberb;
                Intent intent=new Intent();
                intent.putExtra(Result,result);
                //tra du lieu ve Mainactivy -activy da goi no
                setResult(RESULT_OK,intent);
                //xoa cai activy nay
                 finish();
             }
         });
     }
}
