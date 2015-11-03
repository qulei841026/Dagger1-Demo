package qulei.android.dagger1.demo.abs;

import android.app.Application;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import dagger.ObjectGraph;

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
            Application application = getApplication();
            if (application instanceof AbsApp) {
                AbsApp app = (AbsApp) application;
                pushGraph(app, app.getTopModules());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        objectGraph = null;
    }

    protected void pushGraph(AbsApp app, List<Object> modules) {
        if (modules != null && modules.size() > 0) {
            objectGraph = app.pushGraph(modules.toArray());
            objectGraph.inject(this);
        }
    }

    protected boolean isInject() {
        return false;
    }

    public void inject(Object object) {
        if (objectGraph != null) {
            objectGraph.inject(object);
        }
    }

}
