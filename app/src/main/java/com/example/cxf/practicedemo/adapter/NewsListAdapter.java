package com.example.cxf.practicedemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cxf.practicedemo.R;
import com.example.cxf.practicedemo.bean.NewsSummary;
import com.example.cxf.practicedemo.irecycleview.universaladapter.ViewHolderHelper;
import com.example.cxf.practicedemo.irecycleview.universaladapter.recyclerview.MultiItemRecycleViewAdapter;
import com.example.cxf.practicedemo.irecycleview.universaladapter.recyclerview.MultiItemTypeSupport;
import com.example.cxf.practicedemo.utils.CommontUtils;
import com.example.cxf.practicedemo.utils.DisplayUtil;
import com.example.cxf.practicedemo.utils.JLog;

import java.util.List;

/**
 * @auther: cxf on 2018/4/25.
 * @email: chenxianfu_it@163.com
 * @title: 新闻列表的adapter
 * @description:
 */

public class NewsListAdapter extends MultiItemRecycleViewAdapter<NewsSummary> {
    private static final int TYPE_ITEM = 0;
    private static final int TYPE_PHOTO_ITEM = 1;
    private static final String TAG = NewsListAdapter.class.getSimpleName();

    private Context context;

    public NewsListAdapter(Context context, List datas) {
        super(context, datas, new MultiItemTypeSupport<NewsSummary>() {
            @Override
            public int getLayoutId(int itemType) {
                if (itemType == TYPE_PHOTO_ITEM) {
                    return R.layout.item_news_photo;
                } else {
                    return R.layout.item_news;
                }
            }

            @Override
            public int getItemViewType(int position, NewsSummary newsSummary) {
                if (CommontUtils.isEmpty(newsSummary.getDigest())) {
                    return TYPE_PHOTO_ITEM;
                }
                return TYPE_ITEM;
            }
        });

        this.context = context;

    }

    @Override
    public void convert(ViewHolderHelper helper, NewsSummary obj) {
        if (helper.getLayoutId() == R.layout.item_news) {
            setItemValues(helper, obj, getPosition(helper));
        } else {
            setPhotoItemValues(helper, obj, getPosition(helper));
        }
    }


    /**
     * 一图模式
     *
     * @param holder
     * @param newsSummary
     * @param position
     */
    private void setItemValues(ViewHolderHelper holder, NewsSummary newsSummary, final int position) {
        String title = newsSummary.getLtitle();
        if (title == null) {
            title = newsSummary.getTitle();
        }
        String ptime = newsSummary.getPtime();
        String digest = newsSummary.getDigest();
        String imgSrc = newsSummary.getImgsrc();

        holder.setText(R.id.tv_top_title, title);
        holder.setText(R.id.tv_middle_title, digest);
        holder.setText(R.id.tv_time, ptime);
        holder.setImageUrl(R.id.image_news, imgSrc);
        holder.setOnClickListener(R.id.rl_root, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JLog.d(TAG, "点击了" + position);
            }
        });
    }


    /**
     * 多图模式
     *
     * @param holder
     * @param newsSummary
     * @param position
     */
    private void setPhotoItemValues(ViewHolderHelper holder, final NewsSummary newsSummary, final int position) {
        String title = newsSummary.getTitle();
        String ptime = newsSummary.getPtime();
        holder.setText(R.id.tv_title, title);
        holder.setText(R.id.tv_news_time, ptime);
        setImageView(holder, newsSummary);
        holder.setOnClickListener(R.id.ll_root, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JLog.d(TAG, "点击了" + position);
            }
        });
    }

    private void setImageView(ViewHolderHelper holder, NewsSummary newsSummary) {
        int PhotoThreeHeight = DisplayUtil.dip2px(context, 90);
        int PhotoTwoHeight = DisplayUtil.dip2px(context, 120);
        int PhotoOneHeight = DisplayUtil.dip2px(context, 150);

        String imgSrcLeft = null;
        String imgSrcMiddle = null;
        String imgSrcRight = null;
        LinearLayout news_summary_photo_iv_group = holder.getView(R.id.image_group);
        ViewGroup.LayoutParams layoutParams = news_summary_photo_iv_group.getLayoutParams();

        if (newsSummary.getAds() != null) {
            List<NewsSummary.AdsBean> adsBeanList = newsSummary.getAds();
            int size = adsBeanList.size();
            if (size >= 3) {
                imgSrcLeft = adsBeanList.get(0).getImgsrc();
                imgSrcMiddle = adsBeanList.get(1).getImgsrc();
                imgSrcRight = adsBeanList.get(2).getImgsrc();
                layoutParams.height = PhotoThreeHeight;
                holder.setText(R.id.tv_title, context
                        .getString(R.string.photo_collections, adsBeanList.get(0).getTitle()));
            } else if (size >= 2) {
                imgSrcLeft = adsBeanList.get(0).getImgsrc();
                imgSrcMiddle = adsBeanList.get(1).getImgsrc();

                layoutParams.height = PhotoTwoHeight;
            } else if (size >= 1) {
                imgSrcLeft = adsBeanList.get(0).getImgsrc();

                layoutParams.height = PhotoOneHeight;
            }
        } else if (newsSummary.getImgextra() != null) {
            int size = newsSummary.getImgextra().size();
            if (size >= 3) {
                imgSrcLeft = newsSummary.getImgextra().get(0).getImgsrc();
                imgSrcMiddle = newsSummary.getImgextra().get(1).getImgsrc();
                imgSrcRight = newsSummary.getImgextra().get(2).getImgsrc();

                layoutParams.height = PhotoThreeHeight;
            } else if (size >= 2) {
                imgSrcLeft = newsSummary.getImgextra().get(0).getImgsrc();
                imgSrcMiddle = newsSummary.getImgextra().get(1).getImgsrc();

                layoutParams.height = PhotoTwoHeight;
            } else if (size >= 1) {
                imgSrcLeft = newsSummary.getImgextra().get(0).getImgsrc();

                layoutParams.height = PhotoOneHeight;
            }
        } else {
            imgSrcLeft = newsSummary.getImgsrc();

            layoutParams.height = PhotoOneHeight;
        }

        setPhotoImageView(holder, imgSrcLeft, imgSrcMiddle, imgSrcRight);
        news_summary_photo_iv_group.setLayoutParams(layoutParams);
    }

    private void setPhotoImageView(ViewHolderHelper holder, String imgSrcLeft, String imgSrcMiddle, String imgSrcRight) {
        if (imgSrcLeft != null) {
            holder.setVisible(R.id.image_news_first, true);
            holder.setImageUrl(R.id.image_news_first, imgSrcLeft);
        } else {
            holder.setVisible(R.id.image_news_first, false);
        }
        if (imgSrcMiddle != null) {
            holder.setVisible(R.id.image_news_second, true);
            holder.setImageUrl(R.id.image_news_second, imgSrcMiddle);
        } else {
            holder.setVisible(R.id.image_news_second, false);
        }
        if (imgSrcRight != null) {
            holder.setVisible(R.id.image_news_third, true);
            holder.setImageUrl(R.id.image_news_third, imgSrcRight);
        } else {
            holder.setVisible(R.id.image_news_third, false);
        }
    }


}
