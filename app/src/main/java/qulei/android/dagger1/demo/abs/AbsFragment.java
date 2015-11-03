package qulei.android.dagger1.demo.abs;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Fragment 基础类
 * Created by qulei on 15/10/29.
 */
public class AbsFragment extends Fragment {

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (isInject()) {
            if (getActivity() instanceof AbsActivity) {
                ((AbsActivity) getActivity()).inject(this);
            }
        }
    }

    protected boolean isInject() {
        return false;
    }

}
