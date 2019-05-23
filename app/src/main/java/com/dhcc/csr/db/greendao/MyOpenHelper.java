package com.dhcc.csr.db.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.dhcc.csr.db.greendao.gen.DaoMaster;
import com.dhcc.csr.db.greendao.gen.UserInfoDao;
import com.orhanobut.logger.Logger;

import org.greenrobot.greendao.database.Database;

/**
 * @author wlsh
 * @date 2019/1/17 11:58
 * @description 数据库升级工具
 */
public class MyOpenHelper extends DaoMaster.OpenHelper {

    public MyOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        //super.onUpgrade(db, oldVersion, newVersion);
        Logger.d("oldVersion->newVersion" + oldVersion + "->" + newVersion);
        //操作数据库的更新 所有表升级都可以传入到下面
        MigrationHelper.migrate(db, new MigrationHelper.ReCreateAllTableListener() {
                    @Override
                    public void onCreateAllTables(Database db, boolean ifNotExists) {
                        DaoMaster.createAllTables(db, ifNotExists);
                    }

                    @Override
                    public void onDropAllTables(Database db, boolean ifExists) {
                        DaoMaster.dropAllTables(db, ifExists);
                    }
                },
                UserInfoDao.class);
    }
}
