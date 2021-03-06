package qulei.android.dagger1.demo.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Collections;

import javax.inject.Inject;

import qulei.android.dagger1.demo.R;
import qulei.android.dagger1.demo.abs.AbsFragment;
import qulei.android.dagger1.demo.processor.LoginListener;
import qulei.android.dagger1.demo.processor.LoginModule;
import qulei.android.dagger1.demo.processor.LoginProcessor;


/**
 * 登录LoginFragment
 */
public class LoginFragment extends AbsFragment implements LoginListener {

    @Inject
    LoginProcessor loginProcessor;

    public LoginFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        plusModules(Collections.<Object>singletonList(new LoginModule(this)));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_login, container, false);
        rootView.findViewById(R.id.email_sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginProcessor.login();
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    protected boolean isInject() {
        return true;
    }

    @Override
    public void onSuccess() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        } else {
            getActivity().finish();
        }
    }
}
