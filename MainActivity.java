package com.example.lilmimemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {  //어플리케이션을 돌아가게하는 객체

    EditText memoEdit = null;
    TextFileManager mTextFileManager = new TextFileManager(this);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        memoEdit = (EditText) findViewById(R.id.memo_edit);
    }



    public void onClick(View v){   //load,save,delete 버튼이 눌려지면 이 함수를 작동한다.
    	switch(v.getId()){
            case R.id.load_btn:{        //메모 불러오기
                String memoData = mTextFileManager.load(); //메모를 관리하는 TextFileManager객체에서 load함수를 불러옴
                mMemoEdit.setText(memoData);
                Toast.makeText(this,"불러오기 완료",Toast.LENGTH_LONG).show();  //불러오기가 끝나면 불러오기 완료를 창에띄움
                break;
            }

            case R.id.save_btn:{    //메모 저장하기
                String memoData = mMemoEdit.getText().toString();
                mTextFileManager.save(memoData);//메모를 관리하는 TextFileManager객체에서 save함수를 불러오고 메모내용을 파라미터로전달
                mMemoEdit.setText("");
                Toast.makeText(this,"저장 완료", Toast.LENGTH_LONG).show(); //저장이 끝나면 저장 완료를 창에띄움
                break;
            
            }
                
            case R.id.delete_btn:{    //메모 삭제하기
                mTextFileManager.delete();
                mMemoEdit.setText("");
                
                Toast.makeText(this,"삭제 완료",Toast.LENGTH_LONG).show(); //삭제가 끝나면 삭제 완료를 창에띄움
              }
            }
       
            
    }


}
