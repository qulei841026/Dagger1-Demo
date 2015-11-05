package qulei.android.dagger1.demo;

import java.util.Collections;
import java.util.List;

import qulei.android.dagger1.demo.abs.AbsApp;

public class MainApplication extends AbsApp {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    protected List<Object> getAppModules() {
        return Collections.<Object>singletonList(new AppModule(this));
    }

}
