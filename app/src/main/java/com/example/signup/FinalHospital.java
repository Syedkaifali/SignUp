package com.example.signup;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.signup.ModelH.StractFinal;

import java.util.ArrayList;

public class FinalHospital extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<StractFinal> myList;
    FinalAdapter finalAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_hospital);
        Intent intent = getIntent();
        String abc = intent.getStringExtra("Hospital");
        //displayItem();


    }
}
//
//    private void displayItem() {
//        recyclerView = (RecyclerView) findViewById(R.id.recycler_vieww);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        FinalDatabase mDBHELPER = new FinalDatabase(FinalHospital.this, "Hospital");
//        File database = getApplicationContext().getDatabasePath(FinalDatabase.DBNAME);
//        if (!database.exists()) {
//            mDBHELPER.getReadableDatabase();
//            if (!database.exists()) {
//                mDBHELPER.getReadableDatabase();
//                if (!copydatabase(FinalHospital.this)) {
//                    return;
//                }
//            }
//        }
//        //myList = mDBHELPER.GetCity();
//        finalAdapter = new FinalAdapter(myList, this);
//        finalAdapter.notifyDataSetChanged();
//        recyclerView.setAdapter(finalAdapter);
//
//    }
//    public Boolean copydatabase(Context context) {
//
//        try {
//            InputStream inputStream = context.getAssets().open(FinalDatabase.DBNAME);
//            String OutFileName = FinalDatabase.DBLOCATION + FinalDatabase.DBNAME;
//            File f = new File(OutFileName);
//            f.getParentFile().mkdirs();
//            OutputStream outputStream = new FileOutputStream(OutFileName);
//
//            byte[] buffer = new byte[1024];
//            int length = 0;
//            while ((length = inputStream.read(buffer)) > 0) {
//                outputStream.write(buffer, 0, length);
//            }
//            outputStream.flush();
//            outputStream.close();
//            return true;
//        } catch (IOException e) {
//            return false;
//        }
//    }
//}