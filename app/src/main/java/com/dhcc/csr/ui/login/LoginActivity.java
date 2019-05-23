package com.dhcc.csr.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.coder.zzq.smartshow.dialog.LoadingDialog;
import com.coder.zzq.smartshow.dialog.SmartDialog;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.dhcc.csr.R;
import com.dhcc.csr.common.base.MvpBaseActivity;
import com.dhcc.csr.ui.login.contact.LoginContact;
import com.dhcc.csr.ui.login.presenter.LoginPresenterImpl;
import com.dhcc.csr.ui.main.MainActivity;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.orhanobut.logger.Logger;
import com.umeng.message.PushAgent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wlsh
 * @date 2019/1/16 13:46
 * @description 登录
 */
public class LoginActivity extends MvpBaseActivity<LoginContact.LoginView, LoginContact.LoginPresenter> implements Validator.ValidationListener, LoginContact.LoginView {

    @Order(1)
    @NotEmpty(message = "工号不能为空!")
    @BindView(R.id.edt_name)
    EditText edtName;
    @Order(2)
    @NotEmpty(message = "密码不能为空!")
    @BindView(R.id.edt_pass)
    EditText edtPass;
    @BindView(R.id.img_click)
    ImageView imgClick;

    //非空校验
    private Validator validator;
    private boolean SHOW_PASS = false;
    private SmartDialog loadingDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected void initData() {
        //非空判断
        validator = new Validator(this);
        validator.setValidationMode(Validator.Mode.IMMEDIATE);
        validator.setValidationListener(this);

        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog()
                    .large()
                    .withMsg(true)
                    .message("登录中");
        }
    }

    @Override
    protected LoginContact.LoginPresenter initPresenter() {
        return new LoginPresenterImpl();
    }

    @OnClick(R.id.btn_login)
    public void login() {
        validator.validate();
    }

    @OnClick(R.id.img_click)
    public void hideOrShowPass() {
        //密码的显示与隐藏
        if (SHOW_PASS) {
            imgClick.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.ic_visibility_off_24dp));
            //隐藏密码
            edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
        } else {
            imgClick.setBackground(ContextCompat.getDrawable(LoginActivity.this, R.drawable.ic_visibility_24dp));
            //显示密码
            edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        }
        SHOW_PASS = !SHOW_PASS;
        edtPass.postInvalidate();
    }

    @Override
    public void onValidationSucceeded() {
        //校验通过
        String uName = edtName.getText().toString();
        String pWord = edtPass.getText().toString();
        //执行登录操作
        mPresenter.login(uName, pWord, "1", PushAgent.getInstance(this).getRegistrationId());
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            if (view instanceof EditText) {
                ((EditText) view).setError(message);
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void loginSuccess(String result) {
        try {
            Logger.d("登录返回:" + result);
            JSONObject object = new JSONObject(result);
            String status = object.optString("status");
            String msg = object.optString("msg");
            String data = object.optString("data");
            switch (status) {
                case "0":
                    //登录成功
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                    break;
                case "1":
                    //登录失败
                    SmartToast.error(msg);
                    break;
                case "2":
                    //异常
                    SmartToast.error(msg);
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loginFailure() {
        SmartToast.error("登录失败,请稍后重试");
    }

    @Override
    public void showLoginDialog() {
        loadingDialog.showInActivity(this);
    }

    @Override
    public void dismissLoginDialog() {
        loadingDialog.dismiss();
    }
}
