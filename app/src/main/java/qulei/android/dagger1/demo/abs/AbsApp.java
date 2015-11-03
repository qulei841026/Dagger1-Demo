package qulei.android.dagger1.demo.abs;

import android.app.Application;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Application 基础类
 * Created by qulei on 15/10/29.
 */
public class AbsApp extends Application {

    private ObjectGraph objectGraph;

    @Override
    public void onCreate() {
        super.onCreate();
        List<Object> list = getAppModules();
        if (list != null && list.size() > 0) {
            objectGraph = ObjectGraph.create(list.toArray());
            objectGraph.inject(this);
        }
    }

    protected List<Object> getAppModules() {
        return null;
    }

    protected List<Object> getTopModules() {
        return null;
    }

    public ObjectGraph pushGraph(Object... modules) {
        if (objectGraph != null) {
            return objectGraph.plus(modules);
        }
        return null;
    }


}
