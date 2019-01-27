package com.example.truyenvalangngheketquatratrongactivity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
  EditText ed_number_a,ed_number_b;
  Button btn_start;
  public  static final  String NumberA="NumberA";
  public  static final  String NumberB="NumberB";
  public  static int   RequestCode=2018;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getwiget();
        setEvent();
    }
    public void  getwiget(){
        ed_number_a= (EditText) findViewById(R.id.edit_number_a);
        ed_number_b= (EditText) findViewById(R.id.edit_number_b);
        btn_start= (Button) findViewById(R.id.btn_start);

    }
    public void setEvent(){

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(ed_number_a.getText().toString()) && !TextUtils.isEmpty(ed_number_b.getText().toString())) {
                    int numberA = Integer.parseInt(ed_number_a.getText().toString());
                    int numberB = Integer.parseInt(ed_number_b.getText().toString());

                    Intent intent =new Intent(MainActivity.this,activityoutput.class);
                    intent.putExtra(NumberA,numberA);
                    intent.putExtra(NumberB,numberB);
                    //truyen du lieu va lang nghe ket qua tra ve
                    startActivityForResult(intent,RequestCode);
                }
                else{
                    Toast.makeText(MainActivity.this, "variable not have", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //resultCode kiem tra xem cai setResult cua activity nao tra ve
        if(RequestCode==RequestCode){
              switch (resultCode){
                  case activityoutput.RESULT_OK:
                  int result=data.getIntExtra(activityoutput.Result,0);
                      Toast.makeText(this, result+"", Toast.LENGTH_SHORT).show();
                      break;
                  default:
                      break;
              }
        }
    }
}
