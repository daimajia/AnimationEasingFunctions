package daimajia.com.easing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.daimajia.easing.BaseEasingMethod;
import com.daimajia.easing.Skill;

import daimajia.com.eaing.R;

public class EasingAdapter extends BaseAdapter {

    private Context mContext;
    public EasingAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return Skill.values().length;
    }

    @Override
    public Object getItem(int i) {
        return Skill.values()[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Object o = getItem(i);
        BaseEasingMethod b = ((Skill)o).getMethod(1000);
        int start = b.getClass().getName().lastIndexOf(".") + 1;
        String name = b.getClass().getName().substring(start);
        View v = LayoutInflater.from(mContext).inflate(R.layout.item,null);
        TextView tv = (TextView)v.findViewById(R.id.list_item_text);
        tv.setText(name);
        v.setTag(o);
        return v;
    }
}
