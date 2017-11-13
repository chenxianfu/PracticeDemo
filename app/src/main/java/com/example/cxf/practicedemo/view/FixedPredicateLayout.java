package com.example.cxf.practicedemo.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Hashtable;

/**
 * Created by Tesla on 2017/7/14.
 * 固定数目的布局
 */

public class FixedPredicateLayout extends LinearLayout {
    private static final String TAG = PredicateLayout.class.getSimpleName();
    int mLeft, mRight, mTop, mBottom;
    int max_Bottom;
    private Context mContext;
    /**
     * view position map
     */
    Hashtable<View, Position> map = new Hashtable<View, Position>();

    private boolean is_single_line = false;
    private int width;
    private int height;

    /**
     * the vertical distance of each view
     */
    private int DIVIDER_LINE = 20;
    /**
     * each about view distance
     */
    private int DIVIDER_COL = 30;

    /**
     * margin top
     */
    private int MARGIN_TOP = 5;

    /**
     * construction
     *
     * @param context Context
     */
    public FixedPredicateLayout(Context context) {
        super(context);
        mContext = context;
    }

    /**
     * construction
     *
     * @param context           Context
     * @param horizontalSpacing horizontal Spacing
     * @param verticalSpacing   vertical Spacing
     */
    public FixedPredicateLayout(Context context, int horizontalSpacing, int verticalSpacing) {
        super(context);
        mContext = context;
    }

    /**
     * construction
     *
     * @param context Context
     * @param attrs   AttributeSet
     */
    public FixedPredicateLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int mWidth = MeasureSpec.getSize(widthMeasureSpec);
        final int mCount = getChildCount();

        //左边paddding
        mLeft = 0;
        //本行所有child占用空间 + 左边paddding
        mRight = 0;
        mTop = MARGIN_TOP;
        mBottom = 0;

        int j = 0;
        max_Bottom = 0;
        for (int i = 0; i < mCount; i++) {
            final View child = getChildAt(i);

            if (child.getVisibility() == GONE) {
                continue;
            }
            child.measure(MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED);
            // measure height and width
            final int childw = child.getMeasuredWidth();
            final int childh = child.getMeasuredHeight();
            // the length sum, if more than the set width need to wrap,height
            // also need to reset
            //mRight += childw;
            final Position position = new Position();

            mLeft = getPosition(i - j, i);

            mRight = mLeft + childw;
            /*if (mRight >= mWidth - getPaddingRight()) {
                if(is_single_line){
                    break;
                }
                j = i;
                mLeft = getPaddingLeft();
                mRight = mLeft + childw ;
                mTop = max_Bottom + DIVIDER_LINE + MARGIN_TOP;
            }*/
            if (i % 4 == 0 && i != 0) {
                j = i;
                mLeft = getPaddingLeft();
                mRight = mLeft + childw;
                mTop = max_Bottom + DIVIDER_LINE + MARGIN_TOP;
            }
            //child高度 + 顶部margin
            mBottom = mTop + childh;
            max_Bottom = mBottom > max_Bottom ? mBottom : max_Bottom;
            //JLog.d(TAG, "height = " + (max_Bottom + getPaddingBottom()));
            position.mLeft = mLeft;
            position.mTop = mTop;
            position.mRight = mRight;
            position.mBottom = mBottom;
            map.put(child, position);
        }
        width = mWidth;
        height = max_Bottom + getPaddingBottom();
        setMeasuredDimension(mWidth, max_Bottom + getPaddingBottom());
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        // default of 1px spacing
        return new LayoutParams(1, 1);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        final int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final View child = getChildAt(i);
            final Position pos = map.get(child);
            if (pos != null) {
                child.layout(pos.mLeft, pos.mTop, pos.mRight, pos.mBottom);
            } else {
            }
        }
    }

    public int getDIVIDER_LINE() {
        return DIVIDER_LINE;
    }

    public void setDIVIDER_LINE(int DIVIDER_LINE) {
        this.DIVIDER_LINE = DIVIDER_LINE;
    }

    public int getDIVIDER_COL() {
        return DIVIDER_COL;
    }

    public void setDIVIDER_COL(int DIVIDER_COL) {
        this.DIVIDER_COL = DIVIDER_COL;
    }

    public int getMARGIN_TOP() {
        return MARGIN_TOP;
    }

    public void setMARGIN_TOP(int MARGIN_TOP) {
        this.MARGIN_TOP = MARGIN_TOP;
    }

    /**
     * Position left top right bottom
     */
    private class Position {
        int mLeft, mTop, mRight, mBottom;
    }

    /**
     * get view posX
     *
     * @param indexinrow Index in Row
     * @param childindex Child Index
     * @return int width
     */
    public int getPosition(int indexinrow, int childindex) {
        if (indexinrow > 0) {
            int width = 0;
            if (getChildAt(childindex - 1).getVisibility() == VISIBLE) {
                width = getChildAt(childindex - 1).getMeasuredWidth() + DIVIDER_COL;
            }
            return getPosition(indexinrow - 1, childindex - 1) + width;
        }
        return getPaddingLeft();
    }

    public boolean is_single_line() {
        return is_single_line;
    }

    public void setIs_single_line(boolean is_single_line) {
        this.is_single_line = is_single_line;
    }

    public void changeIs_single_line() {
        is_single_line = !is_single_line;
    }

}

