package com.kejuntong.hahawestern;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.kejuntong.hahawestern.UtilClasses.UtilMethods;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

/**
 * Created by kejuntong on 16-05-08.
 */
public class CropImageActivity extends Activity {

    CropImageView cropImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop_image);

        Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(data != null) {
            findViewById(R.id.crop_layout).setVisibility(View.VISIBLE);
            cropImageView = (CropImageView) findViewById(R.id.image_to_crop);
            cropImageView.setCropShape(CropImageView.CropShape.RECTANGLE);
            cropImageView.setAspectRatio(2, 1);
            cropImageView.setFixedAspectRatio(true);

            Uri imageUri = data.getData();
            cropImageView.setImageUriAsync(imageUri);

            findViewById(R.id.crop).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    final Bitmap croppedBitmap = cropImageView.getCroppedImage(500, 250);
                    UtilMethods.saveBitmapToMemory(croppedBitmap, "test");
                    finish();

                }
            });
        }
    }
}
