package com.example.lilmimemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText memoEdit = null;
    TextFileManager mTextFileManager = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memoEdit = (EditText) findViewById(R.id.memo_edit);
    }



    public void onClick(View v){
    	switch(v.getId()){
            case R.id.load_btn:{
                String memoData = mTextFileManager.load();
                mMemoEdit.setText(memoData);
                Toast.makeText(this,"불러오기 완료",Toast.LENGTH_LONG).show();
                break;
            }
        }
       
            
    }

}
