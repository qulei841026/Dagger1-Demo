package qulei.android.dagger1.demo.main;

import dagger.Module;

@Module(        //简单的Module，不使用processor的Module时默认注入图谱。
        injects = {
                MainActivity.class
        },      //简单的Activity，Fragment可以多注入，不必复杂使用processor注入。

        addsTo = AppModule.class        //并入到AppModule图谱中。
)
public class TopModule {

}