package com.example.myhelper;

import android.Manifest;
import android.app.NotificationManager;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.List;


public class setupActivity extends AppCompatActivity {

    private ComponentName compName;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS=1;
    Toolbar toolbar;
    Button smsButton,contactButton,locationButton,adminButton,autorestartButton,continue_btn;
    RelativeLayout smsExpand,contactExpand,locationExpand,adminExpand,autorestartExpand,smsDescription,contactDescription,locationDescription,adminDescription,autorestartDescription;
    ImageView smsImage,contactImage,locationImage,adminImage,autorestartImage,smsDone,contactDone,locationDone,adminDone,autorestartDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

        DevicePolicyManager devicePolicyManager = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
        compName=new ComponentName(getApplicationContext(),MyAdmin.class);


        toolbar=findViewById(R.id.toolbar);
        smsButton= findViewById(R.id.smsPermissionButton);
        contactButton= findViewById(R.id.contactPermissionButton);
        locationButton= findViewById(R.id.locationPermissionButton);
        adminButton= findViewById(R.id.adminPermissionButton);
//        autorestartButton= findViewById(R.id.autorestartPermissionButton);
        continue_btn= findViewById(R.id.btn_continue);
        smsExpand= findViewById(R.id.smsPermissionExpand);
        contactExpand= findViewById(R.id.contactPermissionExpand);
        locationExpand= findViewById(R.id.locationPermissionExpand);
        adminExpand= findViewById(R.id.adminPermissionExpand);
//        autorestartExpand= findViewById(R.id.autorestartPermissionExpand);
        smsDescription= findViewById(R.id.smsPermissionDescription);
        contactDescription= findViewById(R.id.contactPermissionDescription);
        locationDescription= findViewById(R.id.locationPermissionDescription);
        adminDescription= findViewById(R.id.adminPermissionDescription);
//        autorestartDescription= findViewById(R.id.autorestartPermissionDescription);
        smsImage= findViewById(R.id.smsPermissionImage);
        contactImage= findViewById(R.id.contactPermissionImage);
        locationImage= findViewById(R.id.locationPermissionImage);
        adminImage= findViewById(R.id.adminPermissionImage);
//        autorestartImage= findViewById(R.id.autorestartPermissionImage);
        smsDone= findViewById(R.id.smsPermissionDone);
        contactDone= findViewById(R.id.contactPermissionDone);
        locationDone= findViewById(R.id.locationPermissionDone);
        adminDone= findViewById(R.id.adminPermissionDone);
//        autorestartDone= findViewById(R.id.autorestartPermissionDone);

        toolbar.setTitle("SETUP PERMISSIONS");
        setSupportActionBar(toolbar);

        String permission= Manifest.permission.SEND_SMS;
        int grant= ContextCompat.checkSelfPermission(getApplicationContext(),permission);
        if(grant == PackageManager.PERMISSION_GRANTED){
            smsDone.setVisibility(View.VISIBLE);
        }

        permission= Manifest.permission.READ_CONTACTS;
        grant= ContextCompat.checkSelfPermission(getApplicationContext(),permission);
        if(grant == PackageManager.PERMISSION_GRANTED){
            contactDone.setVisibility(View.VISIBLE);
        }

        permission= Manifest.permission.ACCESS_FINE_LOCATION;
        grant= ContextCompat.checkSelfPermission(getApplicationContext(),permission);
        if(grant == PackageManager.PERMISSION_GRANTED){
            locationDone.setVisibility(View.VISIBLE);
        }

        SharedPreferences pref=getSharedPreferences("Admin",MODE_PRIVATE);
        if(pref.getBoolean("enabled",false)){
            adminDone.setVisibility(View.VISIBLE);
        }

        smsExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(smsDescription.getVisibility()==View.GONE){
                    smsImage.setImageResource(R.drawable.ic_expand_less_black_24dp);
                    smsDescription.setVisibility(View.VISIBLE);
                }
                else{
                    smsImage.setImageResource(R.drawable.ic_expand_more_black_24dp);
                    smsDescription.setVisibility(View.GONE);
                }

            }
        });

        contactExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(contactDescription.getVisibility()==View.GONE){
                    contactImage.setImageResource(R.drawable.ic_expand_less_black_24dp);
                    contactDescription.setVisibility(View.VISIBLE);
                }
                else{
                    contactImage.setImageResource(R.drawable.ic_expand_more_black_24dp);
                    contactDescription.setVisibility(View.GONE);
                }

            }
        });

        locationExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(locationDescription.getVisibility()==View.GONE){
                    locationImage.setImageResource(R.drawable.ic_expand_less_black_24dp);
                    locationDescription.setVisibility(View.VISIBLE);
                }
                else{
                    locationImage.setImageResource(R.drawable.ic_expand_more_black_24dp);
                    locationDescription.setVisibility(View.GONE);
                }
            }
        });

        adminExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(adminDescription.getVisibility()==View.GONE){
                    adminImage.setImageResource(R.drawable.ic_expand_less_black_24dp);
                    adminDescription.setVisibility(View.VISIBLE);
                }
                else{
                    adminImage.setImageResource(R.drawable.ic_expand_more_black_24dp);
                    adminDescription.setVisibility(View.GONE);
                }

            }
        });

//        autorestartExpand.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
//                if(autorestartDescription.getVisibility()==View.GONE){
//                    autorestartImage.setImageResource(R.drawable.ic_expand_less_black_24dp);
//                    autorestartDescription.setVisibility(View.VISIBLE);
//                }
//                else{
//                    autorestartImage.setImageResource(R.drawable.ic_expand_more_black_24dp);
//                    autorestartDescription.setVisibility(View.GONE);
//                }
//
//            }
//        });

        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String permission= Manifest.permission.SEND_SMS;
                int grant= ContextCompat.checkSelfPermission(getApplicationContext(),permission);
                if(grant!= PackageManager.PERMISSION_GRANTED){
                    String[] permission_list=new String[2];
                    permission_list[0]=permission;
                    permission_list[1] = Manifest.permission.READ_SMS;
                    ActivityCompat.requestPermissions(setupActivity.this,permission_list,REQUEST_ID_MULTIPLE_PERMISSIONS);
                }
                smsDone.setVisibility(View.VISIBLE);
            }
        });

        contactButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String permission= Manifest.permission.READ_CONTACTS;
                int grant= ContextCompat.checkSelfPermission(getApplicationContext(),permission);
                if(grant!= PackageManager.PERMISSION_GRANTED){
                    String[] permission_list=new String[1];
                    permission_list[0]=permission;
                    ActivityCompat.requestPermissions(setupActivity.this,permission_list,REQUEST_ID_MULTIPLE_PERMISSIONS);
                }
                contactDone.setVisibility(View.VISIBLE);
            }
        });

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String permission= Manifest.permission.ACCESS_FINE_LOCATION;
                int grant= ContextCompat.checkSelfPermission(getApplicationContext(),permission);
                if(grant!= PackageManager.PERMISSION_GRANTED){
                    String[] permission_list=new String[1];
                    permission_list[0]=permission;
                    ActivityCompat.requestPermissions(setupActivity.this,permission_list,REQUEST_ID_MULTIPLE_PERMISSIONS);
                }

                locationDone.setVisibility(View.VISIBLE);
            }
        });

        adminButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
                intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,compName);
                intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,"Additional text explaining why we need this permission");
                startActivity(intent);
                NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !nm.isNotificationPolicyAccessGranted()) {
                        intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);
                        startActivity(intent);
                }
                adminDone.setVisibility(View.VISIBLE);
            }
        });

//        autorestartButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    Intent intent=new Intent();
//                    String manufacturer= Build.MANUFACTURER;
//                    if("xiaomi".equalsIgnoreCase(manufacturer)){
//                        intent.setComponent(new ComponentName("com.miui.securitycenter","com.miui.permcenter.autostart.AutoStartManagementActivity"));
//                    } else if ("Oppo".equalsIgnoreCase(manufacturer)){
//                        intent.setComponent(new ComponentName("com.coloros.safecenter","com.coloros.safecenter.permission.startup.StartupAppListActivity"));
//                    } else if ("Vivo".equalsIgnoreCase(manufacturer)){
//                        intent.setComponent(new ComponentName("com.vivo.permissionmanager","com.vivo.permissionmanager.activity.BgStartupManagerActivity"));
//                    } else if ("Letv".equalsIgnoreCase(manufacturer)){
//                        intent.setComponent(new ComponentName("com.letv.android.letvsafe","com.letv.android.letvsafe.AutobootManageActivity"));
//                    } else if ("Honor".equalsIgnoreCase(manufacturer)){
//                        intent.setComponent(new ComponentName("com.huawei.systemmanager","com.huawei.systemmanager.optimize.process.ProtectActivity"));
//                    } else if ("Asus".equalsIgnoreCase(manufacturer)){
//                        intent.setComponent(new ComponentName("com.asus.mobilemanager","com.asus.mobilemanager.powersaver.PowerSaverSettings"));
//                    } else if ("Nokia".equalsIgnoreCase(manufacturer)){
//                        intent.setComponent(new ComponentName("com.evenwell.powersaving.g3","com.evenwell.powersaving.g3.exception.PowerSaverExceptionActivity"));
//                    }
//                    else{
//                        startActivityForResult(new Intent(Settings.ACTION_SETTINGS), 0);
//                    }
//                    List<ResolveInfo> list=getPackageManager().queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY);
//                    if(list.size()>0){
//                        startActivity(intent);
//                        autorestartDone.setVisibility(View.VISIBLE);
//                    }
//                } catch (Exception e){
//                    Toast.makeText(getApplicationContext(),String.valueOf(e),Toast.LENGTH_LONG).show();
//                }
//            }
//        });

        continue_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDialogOk("First make sure that all permission must be granted before continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                SharedPreferences.Editor ed=getSharedPreferences("isFirst",MODE_PRIVATE).edit();
                                ed.putBoolean("setupActivity",false);
                                ed.apply();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                return;
                        }
                    }
                });
            }
        });
    }

    private void showDialogOk(String message, DialogInterface.OnClickListener okListener) {
        new AlertDialog.Builder(this)
                .setMessage(message)
                .setPositiveButton("OK",okListener)
                .create()
                .show();
    }
}
