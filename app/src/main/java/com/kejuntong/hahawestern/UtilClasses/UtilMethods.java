package com.kejuntong.hahawestern.UtilClasses;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by kejuntong on 16-05-08.
 */
public class UtilMethods {

    public static void saveBitmapToMemory( Bitmap bitmap, String url) {
        File file = new File(MyApp.getContext().getCacheDir(), url);
//        file.getParentFile().mkdirs();

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            System.out.println("finished saving bitmap to memory");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Bitmap getBitmapFromMemory(String url){

        Bitmap bitmap = null;
        File file = new File(MyApp.getContext().getCacheDir(), url);
        if (file.exists()){
//            BitmapFactory.Options options = new BitmapFactory.Options();
//            options.inSampleSize = 2;
//            bitmap = BitmapFactory.decodeFile(filePath, options);
            bitmap = BitmapFactory.decodeFile(file.getPath());

        }
        return bitmap;
    }

}
