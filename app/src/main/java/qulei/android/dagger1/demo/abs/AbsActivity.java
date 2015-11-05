package qulei.android.dagger1.demo.abs;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

import dagger.ObjectGraph;
import qulei.android.dagger1.demo.main.TopModule;

/**
 * Activity 基础类
 * Created by qulei on 15/10/29.
 */
public class AbsActivity extends AppCompatActivity {

    private ObjectGraph objectGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (isInject()) {
            objectGraph = plusModules(getTopModules());
            inject(this);
        }   //默认的Module注入
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        objectGraph = null;
    }

    /**
     * 增加Module。
     */
    public ObjectGraph plusModules(List<Object> modules) {
        if (modules != null && modules.size() > 0) {
            Application application = getApplication();
            if (application instanceof AbsApp) {
                AbsApp app = (AbsApp) application;
                return app.pushGraph(modules.toArray());
            }
        }
        return null;
    }

    /**
     * 提供Fragment的注入
     */
    public void inject(Object object) {
        if (objectGraph != null) {
            objectGraph.inject(object);
        }
    }

    /**
     * 默认简单的UiModule的图谱
     */
    protected List<Object> getTopModules() {
        return Collections.<Object>singletonList(new TopModule());
    }

    /**
     * 是否被注入
     */
    protected boolean isInject() {
        return false;
    }

}
