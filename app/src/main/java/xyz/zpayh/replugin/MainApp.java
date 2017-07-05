package xyz.zpayh.replugin;

import android.util.Log;

import com.qihoo360.replugin.RePluginApplication;
import com.qihoo360.replugin.RePluginConfig;
import com.qihoo360.replugin.RePluginEventCallbacks;
import com.qihoo360.replugin.model.PluginInfo;

/**
 * 文 件 名: MainApp
 * 创 建 人: 陈志鹏
 * 创建日期: 2017/7/6 00:27
 * 邮   箱: ch_zh_p@qq.com
 * 修改时间:
 * 修改备注:
 */

public class MainApp extends RePluginApplication {
    private static final String TAG = "MainApp";
    @Override
    protected RePluginConfig createConfig() {
        RePluginConfig config = new RePluginConfig();

        config.setVerifySign(false);
        config.setMoveFileWhenInstalling(false);

        config.setEventCallbacks(new RePluginEventCallbacks() {
            @Override
            public void onInstallPluginFailed(String path, InstallResult code) {
                //Toast.makeText(MainApp.this, path+"失败,"+code, Toast.LENGTH_SHORT).show();
                Log.d(TAG, path+"失败,"+code);
            }

            @Override
            public void onInstallPluginSucceed(PluginInfo info) {
                //Toast.makeText(MainApp.this, info.getName()+"成功", Toast.LENGTH_SHORT).show();
                Log.d(TAG, "onInstallPluginSucceed: "+info.toString());
            }

            @Override
            public void onStartActivityCompleted(String plugin, String activity, boolean result) {
                Log.d(TAG, "onStartActivityCompleted: "+plugin+","+activity+result);
            }
        });

        return config;
    }
}
