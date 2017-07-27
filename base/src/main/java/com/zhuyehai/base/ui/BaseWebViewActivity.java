//package com.zhuyehai.base.ui;
//
//import android.os.Build;
//import android.webkit.WebSettings;
//import android.webkit.WebView;
//import android.webkit.WebViewClient;
//
//import com.zhuyehai.base.R;
//
//import butterknife.Bind;
//
///**
// * Created by zhuyehai on 17/7/13.
// */
//
//public abstract class BaseWebViewActivity extends BaseActiviy {
//    @Bind(R.id.web_view)
//    protected WebView mWebView;
//
//
//    String mUrlContent;
//    String xmlcontent;
//
//    float mTextSize  = (float) 2;
//
//
//
//
//    @Override
//    protected int getLayoutId() {
//        return R.layout.activity_web_view;
//    }
//
//    @Override
//    protected void getData() {
//        webViewSetting();
//        if(loadUrlState()){
////            xmlcontent = "<div class=\"baseinfo\" style=\"font-size: " + ((float) (mTextSize + 1)) + "em; line-height: " + ((float) (mTextSize + 2)) + "em;text-indent: " + 1.5 + "em\">" + "<div class=\"title\">" + getContentTitle() + "</div><div class=\"from\">" + getName() + "</div>" + "</div>" + "<div class=\"content\" style=\"font-size: " + ((float) (mTextSize + 1)) + "em; line-height: " + ((float) (mTextSize+ 2)) + "em \">" + getContent() + "</div>";
////            mUrlContent = Utils.getHtmlDataSmallNew(xmlcontent);
////            mWebView.loadDataWithBaseURL("", mUrlContent, "text/html", "utf-8", "");
//        }else {
//            loadUrl();
//        }
//
//
//    }
//
//    protected  void loadUrl(){}
//
//    protected  boolean loadUrlState(){
//        return false;
//    }
//
//    protected String getContentTitle(){return "";}
//    protected String getName(){return "";}
//    protected String getContent(){return "";}
//
//    private void webViewSetting() {
//        WebSettings webSettings = mWebView.getSettings();
//        //支持获取手势焦点，输入用户名、密码或其他
//        mWebView.requestFocusFromTouch();
//        webSettings.setJavaScriptEnabled(true);  //支持js
//        //设置自适应屏幕，两者合用
//        webSettings.setUseWideViewPort(true);  //将图片调整到适合webview的大小
//        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小
//        webSettings.setSupportZoom(false);  //支持缩放，默认为true。是下面那个的前提。
//        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。
//        //若上面是false，则该WebView不可缩放，这个不管设置什么都不能缩放。
//        webSettings.setDisplayZoomControls(false); //隐藏原生的缩放控件
//        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN); //支持内容重新布局
//        webSettings.supportMultipleWindows();  //多窗口
//        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);  //关闭webView中缓存
//        webSettings.setAllowFileAccess(true);  //设置可以访问文件
//        webSettings.setNeedInitialFocus(true); //当webView调用requestFocus时为webView设置节点
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
//        webSettings.setLoadsImagesAutomatically(true);  //支持自动加载图片
//        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
////        webSettings.setJavaScriptEnabled(true);
//        //html中的_bank标签就是6新建窗口打开，有时会打不开，需要加以下
//        //然后 复写 WebChromeClient的onCreateWindow方法
//        webSettings.setSupportMultipleWindows(false);
//        webSettings.setJavaScriptCanOpenWindowsAutomatically(true);
//        //有时候网页需要自己保存一些关键数据,Android WebView 需要自己设置
//        webSettings.setDomStorageEnabled(true);
//        webSettings.setDatabaseEnabled(true);
//        webSettings.setAppCacheEnabled(true);
//        webSettings.setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
//        if (Build.VERSION.SDK_INT >= 19) {
//            webSettings.setLoadsImagesAutomatically(true);
//        } else {
//            webSettings.setLoadsImagesAutomatically(false);
//        }
////        mWebView.setInitialScale(25);
//        mWebView.setWebViewClient(mWebViewClient);
////        mWebView.setWebChromeClient(mWebChromeClient);
//    }
//
//
//    public WebViewClient mWebViewClient = new WebViewClient() {
//
//
//        public void onPageFinished(final WebView view, final String url) {
//            super.onPageFinished(view, url);
//            if (view != null) {
//                if (!view.getSettings().getLoadsImagesAutomatically()) {
//                    view.getSettings().setLoadsImagesAutomatically(true);
//                }
//            }
//        }
//    };
//
//}
