package com.landscape.schoolexandroid.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.landscape.netedge.account.ILogin;
import com.landscape.schoolexandroid.R;
import com.landscape.schoolexandroid.api.BaseCallBack;
import com.landscape.schoolexandroid.api.LoginApi;
import com.landscape.schoolexandroid.api.RetrofitService;
import com.landscape.schoolexandroid.common.BaseActivity;
import com.landscape.schoolexandroid.datasource.account.UserAccountDataSource;
import com.landscape.schoolexandroid.mode.account.UserAccount;
import com.utils.behavior.ToastUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginActivity extends BaseActivity implements ILogin {

    ILogin mOptions;
    UserAccountDataSource userAccountDataSource;

    Call<UserAccount> call;

    @Bind(R.id.edit_username)
    EditText editUsername;
    @Bind(R.id.edit_passwd)
    EditText editPasswd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mOptions = (ILogin) mProxy.createProxyInstance(this);
        userAccountDataSource = new UserAccountDataSource(this);
    }

    private boolean check() {
        if (TextUtils.isEmpty(editUsername.getText().toString().trim())) {
            ToastUtil.show(this, editUsername.getHint());
            return false;
        }
        if (TextUtils.isEmpty(editPasswd.getText().toString().trim())) {
            ToastUtil.show(this, editPasswd.getHint());
            return false;
        }
        return true;
    }

    @OnClick(R.id.login)
    void login(View view) {
        //TODO
        if (check()) {
            mOptions.login();
        }
    }

    @Override
    public void login() {
        call = RetrofitService.createApi(LoginApi.class)
                .accountLogin(editUsername.getText().toString().trim(), editPasswd.getText().toString());
        RetrofitService.addCall(call);
        call.enqueue(new BaseCallBack<UserAccount>() {
            @Override
            public void response(UserAccount response) {
                mOptions.loginResult(response);
            }
        });
    }

    @Override
    public void loginResult(UserAccount result) {
        if (result.isIsSuccess()) {
            userAccountDataSource.saveUserAccount(result);
            startActivity(new Intent(this,MainActivity.class));
            finish();
        } else {
            ToastUtil.show(this,result.getMessage());
        }
    }
}
