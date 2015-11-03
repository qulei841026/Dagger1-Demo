package qulei.android.dagger1.demo.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * ListCacheHolder
 */
public interface ListCacheHolder {

    /**
     * 构建XML布局
     */
    View createView(LayoutInflater inflater, ViewGroup parent, int position);

    /**
     * 初始化控件实例
     */
    void initView(View convertView, int position);
}
