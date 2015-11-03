package qulei.android.dagger1.demo.module;

import dagger.Module;
import qulei.android.dagger1.demo.MainActivity;

@Module(
        injects = MainActivity.class,

        addsTo = AppModule.class
)
public class TopModule {

}