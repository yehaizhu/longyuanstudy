package com.zhuyehai.base.ui;

import java.io.Serializable;
import java.util.List;

/**
 * Created by zhuyehai on 17/6/23.
 */

public class SubscriptionBean implements Serializable {

    public int categoryid;
    public String categoryname;
    public List<SubscriptionBean> Data;

}
