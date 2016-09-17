package com.wafflestudio.shafe;

import android.graphics.drawable.Drawable;

/**
 * Created by heesu on 16. 8. 7..
 *
 * Gridview에 나타날 cafe item 데이터에 대한 class
 */
public class CafeItem {
    //TODO : 마저 구현할 것
    private Drawable iconDrawable ;
    private String titleStr ;
    private String descStr ;

    public CafeItem(Drawable icon, String title, String desc) {
        this.iconDrawable = icon;
        this.titleStr = title;
        this.descStr = desc;
    }

    public void setIcon(Drawable icon) { iconDrawable = icon ; }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
}
