package com.dhcc.csr.ui.main;

import android.content.res.Resources;
import android.os.Bundle;

import com.blankj.utilcode.util.AdaptScreenUtils;
import com.coder.zzq.smartshow.dialog.LoadingDialog;
import com.coder.zzq.smartshow.dialog.SmartDialog;
import com.dhcc.csr.R;
import com.dhcc.csr.common.base.BaseMvpActivity;
import com.dhcc.csr.network.exception.ApiException;
import com.dhcc.csr.ui.main.contact.MainContactLifecycle;
import com.dhcc.csr.ui.main.model.MainModel;
import com.dhcc.csr.ui.main.presenter.MainPresenterImpl;
import com.orhanobut.logger.Logger;

import java.util.Calendar;

/**
 * @author wlsh
 * @date 2019/1/16 13:35
 * @description 主界面
 */
public class MainMvpActivity extends BaseMvpActivity<MainContactLifecycle.MainPresenter> implements MainContactLifecycle.MainView {

    private SmartDialog loadingDialog;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        if (loadingDialog == null) {
            loadingDialog = new LoadingDialog()
                    .large()
                    .withMsg(true)
                    .message("登录中");
        }
        mPresenter.outBaseUrlTest("010700010403");
    }

    @Override
    protected void initData() {

        Calendar calendar = Calendar.getInstance();
        String result = String.format("%1$d-%2$d-%3$d", calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DATE));
        Logger.d("result:" + result);

//        //RxJava
//        //被观察者
//        //创建操作符 create() 创建一个被观察者
//        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
//                //产生事件
//                emitter.onNext("TOM");
//                emitter.onNext("Amy");
//                emitter.onNext("Java");
//                emitter.onNext("Kotlin");
//                //结束
//                emitter.onComplete();
//            }
//        });
//
//        //观察者
//        Observer<String> observer = new Observer<String>() {
//
//            private Disposable disposable;
//
//            @Override
//            public void onSubscribe(Disposable d) {
//                Logger.d("onSubscribe");
//                disposable = d;
//            }
//
//            @Override
//            public void onNext(String s) {
//                Logger.d("onNext:" + s);
//                //当Java时中断
//                if ("Java".equals(s)) {
//                    disposable.dispose();
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Logger.d("onError:" + e.getMessage());
//            }
//
//            @Override
//            public void onComplete() {
//                Logger.d("onComplete:");
//            }
//        };
//
//        //订阅
//        observable.subscribe(observer);
//
//        //创建观察者方式
//        //just() 创建一个被观察者，并发送事件，发送的事件不可以超过10个以上。
//        Observable.just(1, 2, 3)
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//        //From 操作符
//        //fromArray() 这个方法和 just() 类似，只不过 fromArray 可以传入一个数组
//        Integer array[] = {1, 2, 3, 4};
//        Observable.fromArray(array)
//                .subscribe(new Observer<Integer>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Integer integer) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//        //fromCallable() Callable 和 Runnable 的用法基本一致，只是它会返回一个结果值
//        Observable.fromCallable(new Callable<Integer>() {
//            @Override
//            public Integer call() throws Exception {
//                return 1;
//            }
//        }).subscribe(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Logger.d("accept：" + integer);
//            }
//        });
//        //fromIterable() 直接发送一个 List 集合数据给观察者
//        List<String> list = new ArrayList<>();
//        Observable.fromIterable(list)
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//
//        //empty() 直接发送 onComplete() 事件
//        Observable.empty()
//                .subscribe(new Observer<Object>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Object o) {
//
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        Logger.d("empty()  onComplete:");
//                    }
//                });
//
//
//        //转换操作符
//        //map() map 可以将被观察者发送的数据类型转变成其他的类型,是一对一的转换
//        Observable.just(1, 2, 3)
//                .map(new Function<Integer, String>() {
//                    @Override
//                    public String apply(Integer integer) throws Exception {
//                        return integer + "RxJava";
//                    }
//                })
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        Logger.d("onNext:" + s);
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//
//        //flatMap() 这个方法可以将事件序列中的元素进行整合加工，返回一个新的被观察者。
//        ArrayList<Student> students = new ArrayList<>();
//        for (int i = 0; i < 30; i++) {
//            Student student = new Student();
//            student.setName("张三" + i);
//            student.setSchool("蒙城六中" + i);
//            students.add(student);
//            student=null;
//        }
//
//
//        ArrayList<Department> departments = new ArrayList<>();
//        for (int j = 0; j < 1; j++) {
//            Department department = new Department();
//            department.setName("技术信息部" + j);
//            department.setStudents(students);
//            departments.add(department);
//        }

//        Observable.fromIterable(departments)
//                .flatMap(new Function<Department, ObservableSource<Student>>() {
//                    @Override
//                    public ObservableSource<Student> apply(Department department) throws Exception {
//                        return Observable.fromIterable(department.getStudents());
//                    }
//                })
//                .subscribe(new Observer<Student>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(Student student) {
//                        Logger.d("flatMap onNext:" + student.getName() + "," + student.getSchool());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

//        //concatMap()
//        //concatMap() 和 flatMap() 基本上是一样的，只不过 concatMap() 转发出来的事件是有序的，而 flatMap() 是无序的。
//        //delay() 延迟一段事件发送事件。
//        //doOnSubscribe() Observable 每发送 onSubscribe() 之前都会回调这个方法。
//        Observable.fromIterable(departments)
//                .delay(1000, TimeUnit.MILLISECONDS)
//                .concatMap(new Function<Department, ObservableSource<Student>>() {
//                    @Override
//                    public ObservableSource<Student> apply(Department department) throws Exception {
//                        return Observable.fromIterable(department.getStudents());
//                    }
//                })
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//                        //Observable.doOnSubscribe()方法是在subscribe() 调用后而且在事件发送前执行。
//                        //默认情况下， doOnSubscribe() 执行在 subscribe() 发生的线程；
//                        //而如果在 doOnSubscribe() 之后有 subscribeOn() 的话，
//                        //它将执行在离它最近的 subscribeOn() 所指定的线程。
//                        Logger.d("doOnSubscribe");
//                    }
//                })
//                //被观察者线程
//                .subscribeOn(Schedulers.io())
//                //观察者线程
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<Student>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        Logger.d("onSubscribe开始了");
//                    }
//
//                    @Override
//                    public void onNext(Student student) {
//                        Logger.d("concatMap onNext:" + student.getName() + "," + student.getSchool());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
    }

    @Override
    protected MainContactLifecycle.MainPresenter initPresenter() {
        return new MainPresenterImpl(this, new MainModel());
    }

    @Override
    public Resources getResources() {
        return AdaptScreenUtils.adaptWidth(super.getResources(), 1080);
    }

    @Override
    public void success(String result) {
        Logger.d("外部参数返回:" + result);
    }


    @Override
    public void fail(ApiException e) {
        Logger.d("fail:" + e.getDisplayMessage());
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
