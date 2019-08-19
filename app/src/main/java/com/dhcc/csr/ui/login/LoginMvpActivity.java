package com.dhcc.csr.ui.login;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPStaticUtils;
import com.blankj.utilcode.util.SPUtils;
import com.coder.zzq.smartshow.dialog.LoadingDialog;
import com.coder.zzq.smartshow.dialog.SmartDialog;
import com.coder.zzq.smartshow.toast.SmartToast;
import com.dhcc.csr.R;
import com.dhcc.csr.bean.VisitObject;
import com.dhcc.csr.common.base.BaseMvpActivity;
import com.dhcc.csr.common.base.Constants;
import com.dhcc.csr.network.exception.ApiException;
import com.dhcc.csr.ui.login.contact.LoginContactLifecycle;
import com.dhcc.csr.ui.login.model.LoginModel;
import com.dhcc.csr.ui.login.presenter.LoginPresenterImpl;
import com.dhcc.csr.ui.main.MainMvpActivity;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Order;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * @author wlsh
 * @date 2019/1/16 13:46
 * @description 登录
 */
public class LoginMvpActivity extends BaseMvpActivity<LoginContactLifecycle.LoginPresenter> implements Validator.ValidationListener, LoginContactLifecycle.LoginView {

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

        //初始化sp
        SPStaticUtils.setDefaultSPUtils(SPUtils.getInstance(Constants.SP_NAME));
        SPStaticUtils.put(Constants.LOGIN_TOKEN, "24006264-68de-4794-acc7-dbc4c8adf3b5");
    }

    @Override
    protected LoginContactLifecycle.LoginPresenter initPresenter() {
        return new LoginPresenterImpl(this, new LoginModel());
    }


    @OnClick({R.id.img_click, R.id.btn_finish, R.id.btn_login})
    public void hideOrShowPass(View view) {
        switch (view.getId()) {
            case R.id.img_click:
                //密码的显示与隐藏
                if (SHOW_PASS) {
                    imgClick.setBackground(ContextCompat.getDrawable(LoginMvpActivity.this, R.drawable.ic_visibility_off_24dp));
                    //隐藏密码
                    edtPass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                } else {
                    imgClick.setBackground(ContextCompat.getDrawable(LoginMvpActivity.this, R.drawable.ic_visibility_24dp));
                    //显示密码
                    edtPass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                SHOW_PASS = !SHOW_PASS;
                edtPass.postInvalidate();
                break;
            case R.id.btn_login:
                validator.validate();
                break;
            case R.id.btn_finish:
                //结束LoginActivity测试是否有内存泄漏
                ActivityUtils.startActivity(MainMvpActivity.class);
                finish();
                break;
        }
    }

    @Override
    public void onValidationSucceeded() {
        //校验通过
        String uName = edtName.getText().toString();
        String pWord = edtPass.getText().toString();
        //执行登录操作
        mPresenter.login(uName, pWord, "1", "AsJfxUBOo7O9CDPJpxCvLY-3qM9OZSlU2V2tN8oEJbD9");
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
    public void loginSuccess(ArrayList<VisitObject> result) {
        Logger.d("loginSuccess:" + GsonUtils.toJson(result));
        ActivityUtils.startActivity(MainMvpActivity.class);
        finish();
    }

    @Override
    public void loginFailure(ApiException e) {
        Logger.d("loginFailure:" + e.getDisplayMessage());
        SmartToast.error("登录失败,请稍后重试");
    }

    @Override
    public void memoryTest(Long number) {
        //内存泄漏测试
        edtName.setText(String.valueOf(number));
    }

    @Override
    public void showLoading() {
        loadingDialog.showInActivity(this);
    }

    @Override
    public void hideLoading() {
        loadingDialog.dismiss();
    }
}
