package com.example.cxf.practicedemo.view;


/**
 * @author cxf.
 * @date 2015/9/6.
 * @description 应用信息配置
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

    // star price point
    public static final int MAX_POINT_UNIT = 4;// 单价小数点后的有效位
    public static final int MAX_POINT_TOTAL = 2;// 总价小数点后的有效位
    public static final int MAX_POINT_DISCOUNT = 1;//折扣


    public static final String YEAR = "YEAR";//年
    public static final String MONTH = "MONTH";//月
    public static final String DAY = "DAY";//日

    // the getters and setters

}
