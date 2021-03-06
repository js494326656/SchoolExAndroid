package com.landscape.netedge.account;

import com.edge.annotation.NetBegin;
import com.edge.annotation.NetEnd;
import com.landscape.netedge.BaseEdge;
import com.landscape.schoolexandroid.mode.account.UserAccount;

/**
 * Created by 1 on 2016/6/21.
 */
public interface ILogin extends BaseEdge {
    @NetBegin
    void login();
    @NetEnd
    void loginResult(UserAccount result);
}
