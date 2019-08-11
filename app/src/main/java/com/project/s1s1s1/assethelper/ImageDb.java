package com.project.s1s1s1.assethelper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImageDb extends SQLiteAssetHelper {

    private static final String DB_NAME="image.db";
    private static final int DB_VERSION=1;
    private static final String TBL_NAME="img_tbl";
    private static final String TAG = ImageDb.class.getSimpleName();
    private Context context;
    private SQLiteDatabase db;

    public ImageDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    public List<DataModel> getAllImage(){
        List<DataModel>imgLlist=new ArrayList<>();
        try {
            db=getReadableDatabase();
            if (db!=null){
                Cursor cursor=db.rawQuery("select * from "+TBL_NAME,null);
                if (cursor.getCount()!=0){
                    while (cursor.moveToNext()){
                        String description=cursor.getString(0);
                        byte[] imgByte=cursor.getBlob(1);
                        Bitmap imgae= BitmapFactory.decodeByteArray(imgByte,0,imgByte.length);
                        imgLlist.add(new DataModel(description,imgae));
                    }
                }
            }

        }catch (Exception e){
            Log.e(TAG, "getAllImage: "+e.getLocalizedMessage() );
        }
        return imgLlist;
    }
}
