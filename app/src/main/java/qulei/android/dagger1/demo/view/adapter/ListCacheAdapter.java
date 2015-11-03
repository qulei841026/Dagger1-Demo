package qulei.android.dagger1.demo.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * ListView的Adapter基础类
 * <p/>
 * <p>对ViewHolder进行了封装</p>
 */
public abstract class ListCacheAdapter<T> extends BaseAdapter {

    protected List<T> mList;
    protected Context mContext;
    protected LayoutInflater mInflater;

    public ListCacheAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public T getItem(int position) {
        return mList == null ? null : mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ListCacheHolder holder;
        if (convertView == null) {
            holder = getHolder();

            if (holder == null)
                return null;

            convertView = holder.createView(mInflater, parent, position);

            if (convertView == null)
                return null;

            holder.initView(convertView, position);
            convertView.setTag(holder);

        } else {
            holder = (ListCacheHolder) convertView.getTag();
        }
        updateView(holder, position);
        return convertView;
    }

    /**
     * 获取数据集合
     */
    public List<T> getList() {
        return mList;
    }

    /**
     * 设置数据集合
     */
    public void setList(List<T> list) {
        this.mList = list;
        notifyDataSetChanged();
    }

    public void addList(List<T> list) {
        if (this.mList == null) {
            setList(list);
        } else {
            mList.addAll(list);
            notifyDataSetChanged();
        }
    }

    /**
     * ListCacheHolder 实例
     */
    public abstract ListCacheHolder getHolder();

    /**
     * 修改 Item 样式
     */
    public abstract void updateView(ListCacheHolder holder, int position);

}
