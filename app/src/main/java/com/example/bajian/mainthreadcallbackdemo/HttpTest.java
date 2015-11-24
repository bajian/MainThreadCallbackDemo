package com.example.bajian.mainthreadcallbackdemo;

import android.os.Handler;
import android.os.Looper;


/**
 * Created by bajian on 2015/11/24.
 * email 313066164@qq.com
 */
public class HttpTest {
    private Handler mHandler;
    public HttpTest(){
        mHandler= new Handler(Looper.getMainLooper());

    }

    public void run(final Callback mCallback){
        try {
            Thread.sleep(5000);//模拟http延迟
        } catch (Exception e) {

        }

//        mCallback.onSuccess(Math.random() + "");//子线程中，会报Only the original thread that created a view hierarchy can touch its views
       mHandler.post(new Runnable() {
            @Override
            public void run() {
                mCallback.onSuccess(Math.random()+"");//主线程中
            }
        });

    }


    interface Callback{
        void onSuccess(String str);
    }
}
