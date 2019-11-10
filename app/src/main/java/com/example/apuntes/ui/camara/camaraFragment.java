package com.example.apuntes.ui.camara;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.apuntes.R;

import java.io.File;
import java.io.FileOutputStream;

public class camaraFragment extends Fragment {

    private camaraViewModel slideshowViewModel;
    private Button btn_camara;
    private Bitmap bmp;
    private int contador = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(camaraViewModel.class);
        View root = inflater.inflate(R.layout.fragment_camara, container, false);

        btn_camara = root.findViewById(R.id.btn_abrir_camara);
        btn_camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Ojo cuidado da los permisos en el manifest no te emociones
                int permissionCheck = ContextCompat.checkSelfPermission(
                        getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE);
                int permisocamara = ContextCompat.checkSelfPermission(
                        getContext(), Manifest.permission.CAMERA);
                if (permissionCheck != PackageManager.PERMISSION_GRANTED || permisocamara != PackageManager.PERMISSION_GRANTED) {
                    Log.i("Mensaje", "No se tiene permiso para la camara!.");
                    ActivityCompat.requestPermissions((Activity) getContext(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE}, 225);
                } else {
                    Log.i("Mensaje", "Tienes permiso para usar la camara.");
                }
                sacarFoto();
            }

        });

        return root;
    }

    private void sacarFoto(){
        //Mediante un intente llamaremos a la camara para sacar una foto
        Intent i = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,0);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            //Una vez sacada esa foto vamos a cojerla del intent y la guardaremos en forma de bitmap
            Bundle ext = data.getExtras();
            bmp = (Bitmap) ext.get("data");
            System.out.println("exito");
            //guardarFoto();
            saveTempBitmap(bmp);
        }
    }

    public void saveTempBitmap(Bitmap bitmap) {
        if (isExternalStorageWritable()) {
            saveImage(bitmap);
        }else{
            //prompt the user or do something
        }
    }

    private void saveImage(Bitmap finalBitmap) {

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/imagenesGuardadas/");
        myDir.mkdirs();
        String fname = contador +".jpg";
        File file = new File(myDir, fname);
        if (file.exists()){
            file.delete ();
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
            out.flush();
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        contador = contador +1;
    }

    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
}