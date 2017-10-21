package com.example.song.mobilesw;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {Link OnListFragmentInteractionListener}
 * interface.
 *
 *
 * 타임라인 내에 들어가는 글 입니다.
 */
public class ItemFragment extends Fragment {
    private Drawable iconDrawable;
    private String titleStr;
    private String descStr;
    private String writStr;

    public void setIcon(Drawable icon) {
        iconDrawable = icon;
    }
    public void setTitle(String title) {
        titleStr = title;
    }
    public void setDesc(String desc) {
        descStr = desc;
    }

    public void setWrit(String Writer)
    {
        writStr = Writer;
    }

    public Drawable getIcon() {
        return this.iconDrawable;
    }
    public String getTitle() {
        return this.titleStr;
    }
    public String getDesc() {
        return this.descStr;
    }

    public String getWritStr()
    {
        return this.writStr;
    }
}
