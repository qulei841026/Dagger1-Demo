package qulei.android.dagger1.demo.abs;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import java.util.List;

import dagger.ObjectGraph;

/**
 * Fragment 基础类
 * Created by qulei on 15/10/29.
 */
public class AbsFragment extends Fragment {

    ObjectGraph objectGraph;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isInject()) {
            if (objectGraph == null) {
                if (getActivity() instanceof AbsActivity) {
                    ((AbsActivity) getActivity()).inject(this); //注入当前类
                }
            } else {
                objectGraph.inject(this);
            }
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        objectGraph = null;
    }

    /**
     * 增加指定的Module
     * <p>调用在{@link #onCreate(Bundle)}方法内。</p>
     */
    protected void plusModules(List<Object> modules) {
        if (getActivity() instanceof AbsActivity) {
            objectGraph = ((AbsActivity) getActivity()).plusModules(modules);
        }
    }

    /**
     * 是否被注入
     * <p/>
     * <p> 不调用 {@link #plusModules(List)}的情况下，默认注入AbsActivity的Module</p>
     */
    protected boolean isInject() {
        return false;
    }

}
