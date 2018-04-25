package com.example.cxf.practicedemo.irecycleview.universaladapter.recyclerview;

public interface MultiItemTypeSupport<T>
{
	int getLayoutId(int itemType);

	int getItemViewType(int position, T t);
}