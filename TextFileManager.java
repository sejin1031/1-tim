package com.example.lilmimemo;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class TextFileManager {//메모 파일을 관리해주는 객체
    private static final String FILE_NAME = "LilmeMemo.txt"; //LilmeMemo.txt파일을 선언
    Context mContext = null;
    
    public TextFileManager(Context context) {
        mContext = context;
    }
    
    public void save(String strData){//메모파일을 저장해주는 함수
        if(strData == null || strData.equals("")){
            return;
        }
        FileOutputStream fosMemo = null;
        
        try{
            //파일에 데이터를 쓰기 위해서 output 스트림 생성
            fosMemo = mContext.openFileOutput(FILE_NAME,Context,MODE_PRIVATE);
            //파일에 메모적기
            fosMemo.write(strData.getBytes());
            fosMemo.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public String load(){ //메포파일을 불러오는 함수
        try{
            //produce FileInputStream that named fisMemo
            FileInputStream fisMemo = mContext.openFileInput(FILE_NAME);
            
            byte[] memoData = new byte[fisMemo.available()];
           while(fisMemo.read(memoData) != -1){}
            
            return new String(memoData);
        }catch(IOException e){}//예외처리
        return "";
    }
    //File delete method
    public void delete(){ //삭제 기능
        mContext.deleteFile(FILE_NAME);
    }
}
    
}
