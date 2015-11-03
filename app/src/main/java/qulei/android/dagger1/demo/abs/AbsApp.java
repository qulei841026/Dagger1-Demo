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
        }//生成AppModule图谱，并注入当前Application类。
    }

    /**
     * 获取AppModule的图谱
     */
    protected List<Object> getAppModules() {
        return null;
    }

    /**
     * 默认简单的UiModule的图谱
     */
    protected List<Object> getTopModules() {
        return null;
    }

    /**
     * 并入Module到AppModule中
     */
    public ObjectGraph pushGraph(Object... modules) {
        if (objectGraph != null) {
            return objectGraph.plus(modules);
        }
        return null;
    }


}
