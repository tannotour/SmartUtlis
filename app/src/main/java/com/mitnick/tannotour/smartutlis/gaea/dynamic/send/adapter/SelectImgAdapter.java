package com.mitnick.tannotour.smartutlis.gaea.dynamic.send.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.mitnick.tannotour.smartutlis.R;

import java.io.File;
import java.util.LinkedList;

/**
 * Created by 陈睿 on 16-10-2.
 * Describe:选择说说图片适配器
 */
public class SelectImgAdapter extends RecyclerView.Adapter<SelectImgAdapter.ViewHolder> {

    private LinkedList<String> imgs = new LinkedList<>();
    private SelectImgClickListener selectImgClickListener = null;
    private Context context = null;


    public SelectImgAdapter(@NonNull Context context,
                            @NonNull LinkedList<String> imgs,
                            @Nullable SelectImgClickListener selectImgClickListener) {
        this.imgs = imgs;
        this.selectImgClickListener = selectImgClickListener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.gaea_dynamic_send_item_imgs_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if(position == imgs.size() - 1){
            holder.imgDel.setVisibility(View.INVISIBLE);
            holder.imgShow.setPadding(16,16,16,16);
            holder.imgShow.setImageResource(R.drawable.shuoshuo_add_img);
            holder.imgShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(null != selectImgClickListener){
                        selectImgClickListener.onImgItemClick(SelectImgClickListener.ITEM_TYPE_ADD,position);
                    }
                }
            });
        }else{
            holder.imgShow.setPadding(0,0,0,0);
            Glide.with(context)
                    .load(new File(imgs.get(position)))
                    .asBitmap()
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            holder.imgShow.setImageBitmap(ThumbnailUtils.extractThumbnail(resource, 192, 192));
                        }
                    });
            holder.imgDel.setVisibility(View.VISIBLE);
            holder.imgShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(null != selectImgClickListener){
                        selectImgClickListener.onImgItemClick(SelectImgClickListener.ITEM_TYPE_IMG,position);
                    }
                }
            });
            holder.imgDel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(null != selectImgClickListener){
                        selectImgClickListener.onImgDelItemClick(position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return imgs.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imgShow;
        ImageView imgDel;

        ViewHolder(View view){
            super(view);
            imgShow = (ImageView) view.findViewById(R.id.shuoshuo_item_img_show);
            imgDel = (ImageView) view.findViewById(R.id.shuoshuo_item_img_del);
        }
    }
}
