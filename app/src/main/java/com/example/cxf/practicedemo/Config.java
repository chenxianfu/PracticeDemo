package com.example.cxf.practicedemo;


/**
 * @author cxf.
 * @date 2018年4月20日10:08:56
 * @description 公共配置
 */
public class Config {

    // star common 公共模块================================================================= -->

    //http://192.68.75.27:8006 测试环境
    //http://192.68.75.20:8006 开发环境
    public static String IP = "http://192.68.75.20:8006";

    public static final boolean DEBUG=true; // 发布记得改为false

    public static final String OK = "000";
    public static final String TOKEN = "token";
    // star activity result code
    public static final int REQUEST_CODE_PICK_IMAGE = 1;// 本地相册
    public static final int REQUEST_CODE_CAMERA_IMAGE = 2;// 拍照
    // end activity result code

    // star file config
    public static final String APP_IMAGE_PATH = "eye_image";//缓存图片目录
    public static final String APP_TEMP_PATH = "eye_temp";//缓存文件目录
    // end file config

    public static final String PAGE_INDEX = "page_index";
    public static final int MAX_IMG = 4;

    public static final String SHARED_INFO = "share_info";


    public static final String YEAR = "YEAR";//年
    public static final String MONTH = "MONTH";//月
    public static final String DAY = "DAY";//日

    //
    public static final String NEWS_TITLES = "news_titles";// 新闻标题
    public static final String GIRL_TITLES = "girl_titles";// 美女标题



}
