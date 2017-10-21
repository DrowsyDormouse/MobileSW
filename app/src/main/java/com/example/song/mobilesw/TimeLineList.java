package com.example.song.mobilesw;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.song.mobilesw.R.id.post;

/**
 * {link RecyclerView.Adapter} that can display a {link DummyItem} and makes a call to the
 * specified {link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 *
 *
 *
 *
 * 어플의 타임라인 리스트 화면입니다.
 */
public class TimeLineList extends BaseAdapter  {
    private ArrayList<ItemFragment> listViewItemList = new ArrayList<ItemFragment>();

    public TimeLineList()
    {

    }

    @Override
    public int getCount()
    {
        return listViewItemList.size();
    }

    // position에 위치한 데이터를 화면에 출력하는데 사용될 View를 리턴. : 필수 구현
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_item_list, parent, false);
        }

        ImageView profileIV = (ImageView)convertView.findViewById(R.id.post_profile);
        TextView writer = (TextView)convertView.findViewById(R.id.writer);
        TextView title = (TextView)convertView.findViewById(R.id.title);
        TextView body = (TextView)convertView.findViewById(R.id.body);

        ItemFragment listViewItem = listViewItemList.get(position);

        profileIV.setImageDrawable(listViewItem.getIcon());
        writer.setText(listViewItem.getWritStr());
        title.setText(listViewItem.getTitle());
        body.setText(listViewItem.getDesc());

        return convertView;
    }

    // 지정한 위치(position)에 있는 데이터와 관계된 아이템(row)의 ID를 리턴. : 필수 구현
    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return listViewItemList.get(position) ;
    }

    public void addItem(Drawable icon, String writer, String title, String desc) {
        ItemFragment itemFragment = new ItemFragment();

        itemFragment.setIcon(icon);
        itemFragment.setWrit(writer);
        itemFragment.setTitle(title);
        itemFragment.setDesc(desc);

        listViewItemList.add(itemFragment);
    }
}
