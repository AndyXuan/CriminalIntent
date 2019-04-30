package me.xdd.self.criminalintent;

import android.app.Application;
import android.util.Log;

import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

public class BaseApplication extends Application {
    private static final String TAG = BaseApplication.class.getName();
    @Override
    public void onCreate() {
        super.onCreate();
        UMConfigure.init(this,"5cc7c75c570df312de00063b","Umeng",UMConfigure.DEVICE_TYPE_PHONE,"a12325691d8c84d778487e2443032af8");
        //获取消息推送代理示例
        PushAgent mPushAgent = PushAgent.getInstance(this);

        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.i(TAG,"注册成功：deviceToken：-------->  " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.e(TAG,"注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });

    }
}
