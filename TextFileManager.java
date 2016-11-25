package com.example.lilmimemo;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.*;

public class TextFileManager {
    private static final String FILE_NAME = "LilmeMemo.txt";
    Context mContext = null;

    public TextFileManager(Context context) {
        mContext = context;
    }
    
    public void save(String strData){
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
    public String load(){
        try{
            //
            FileInputStream fisMemo = mContext.openFileInput(FILE_NAME);
            
            byte[] memoData = new byte[fisMemo.available()];
           while(fisMemo.read(memoData) != -1){}
            
            return new String(memoData);
        }catch(IOException e){}
        return "";
    }
    
    public void delete(){
        mContext.deleteFile(FILE_NAME);
    }
}
    
}
