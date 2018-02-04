package com.mitnick.tannotour.smartutlis.gaea.dynamic.send.adapter;

/**
 * Created by mitnick on 2018/2/3.
 * Description
 */

public interface SelectImgClickListener {

    int ITEM_TYPE_ADD = 0;
    int ITEM_TYPE_IMG = 1;

    /**
     * 图片列表点击事件
     * @param type 点击事件类型 0 添加图片 1 其他
     * @param position 点击位置
     */
    void onImgItemClick(int type, int position);

    /**
     * 删除item点击事件
     * @param position 点击位置
     */
    void onImgDelItemClick(int position);
}
