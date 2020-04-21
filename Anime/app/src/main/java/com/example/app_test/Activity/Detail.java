package com.example.app_test.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app_test.Adapter.Like_Adapter;
import com.example.app_test.Adapter.Recent_Adapter;
import com.example.app_test.Database.Database;
import com.example.app_test.Model.Detail_model;
import com.example.app_test.Model.Like;
import com.example.app_test.R;
import com.squareup.picasso.Picasso;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import eightbitlab.com.blurview.BlurView;
import eightbitlab.com.blurview.RenderScriptBlur;

public class Detail extends AppCompatActivity {
    RecyclerView recyclerView;
    private ImageView imageView,img,img_like;
    private TextView txt_detailUrl,txt_category,txt_info;
    String detailString,category,info;
    ProgressDialog progressDialog;
    ArrayList<Detail_model> arrayList;
    Recent_Adapter adapter;
    Database database;
    ListView listView;
    ArrayList<Like> likeArrayList;
    Like_Adapter likeAdapter;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        recyclerView=findViewById(R.id.recycleView_detail);
        blurView=findViewById(R.id.blurView_detail);
        blurBackground();
        recyclerView.setLayoutManager(new GridLayoutManager(Detail.this,5,GridLayoutManager.HORIZONTAL,false));
        anhXa();
        arrayList= new ArrayList<>();
        arrayList.add(new Detail_model("1.The New Threat","23m"));
        arrayList.add(new Detail_model("2.Reunions","25m"));
        arrayList.add(new Detail_model("3.Unlikely Alliance","25m"));
        arrayList.add(new Detail_model("4.The New Threat","23m"));
        arrayList.add(new Detail_model("5.Piccolo's Plan","26m"));
        arrayList.add(new Detail_model("6.The New Threat","23m"));
        arrayList.add(new Detail_model("7.The New Threat","23m"));
        arrayList.add(new Detail_model("8.The New Threat","23m"));
        arrayList.add(new Detail_model("9.The New Threat","23m"));
        arrayList.add(new Detail_model("10.The New Threat","23m"));
        arrayList.add(new Detail_model("11.The New Threat","23m"));
        arrayList.add(new Detail_model("12.The New Threat","23m"));
        arrayList.add(new Detail_model("13.The New Threat","23m"));
        arrayList.add(new Detail_model("14.The New Threat","23m"));
        arrayList.add(new Detail_model("15.The New Threat","23m"));
        arrayList.add(new Detail_model("16.The New Threat","23m"));
        arrayList.add(new Detail_model("17.The New Threat","23m"));
        adapter= new Recent_Adapter(arrayList,this);
        recyclerView.setAdapter(adapter);

        img=findViewById(R.id.img_backgroudDetail);
        Picasso.get().load(getIntent().getStringExtra("image")).into(img);
        imageView=findViewById(R.id.imageView_home);
        txt_category=findViewById(R.id.txt_category_home);
        txt_detailUrl=findViewById(R.id.txt_detail_home);
        txt_info=findViewById(R.id.txt_animeinfo_home);
        Picasso.get().load(getIntent().getStringExtra("image")).into(imageView);


        img_like=findViewById(R.id.img_like);
        database= new Database(this,"LikeList.sqlite",null,3);
        database.QueryData("CREATE TABLE IF NOT EXISTS Like (Id INTEGER PRIMARY KEY AUTOINCREMENT, Title VARCHAR(200),Category VARCHAR(100),Info VARCHAR(100))");

        img_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  likeArrayList.clear();
                String title=txt_detailUrl.getText().toString();
                String category=txt_category.getText().toString();
                String info=txt_info.getText().toString();
               // database.QueryData("DELETE FROM Like");
                database.QueryData("INSERT INTO Like VALUES (null,'"+title+"','"+category+"','"+info+"')");
                img_like.setBackgroundResource(R.drawable.icon_dislike);
                Toast.makeText(Detail.this, "Đã thêm vào danh sách phim yêu thích", Toast.LENGTH_SHORT).show();
//                Cursor dataLike =database.GetData("SELECT * FROM Like");
//               // likeArrayList.clear();
//                while (dataLike.moveToNext()){
//                    int Id=dataLike.getInt(0);
//                    title=dataLike.getString(1);
//                    category=dataLike.getString(2);
//                    info=dataLike.getString(3);
//                    likeArrayList.add(new Like(Id,title,category,info));
//                }
//                likeAdapter.notifyDataSetChanged();

            }
        });

        Content content= new Content();
        content.execute();

    }
    private class Content extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressDialog= new ProgressDialog(Detail.this);
            progressDialog.setMessage("Loading Data...");
            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txt_detailUrl.setText(detailString);
            txt_category.setText(category);
            txt_info.setText(info);
            progressDialog.dismiss();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try
            {
                String baseUrl="https://www10.gogoanime.io/";
                String detailUrl=getIntent().getStringExtra("detailUrl");
                String url=baseUrl+detailUrl;
                Document doc= org.jsoup.Jsoup.connect(url).get();
                detailString=doc.select("h1").text();

                Elements data=doc.select("div.anime_video_body_cate");

                for (int i=0;i<data.size();i++)
                {
                    category=data.select("a").attr("title");
                    info=data.select("div.anime-info").select("a").attr("title");
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    BlurView blurView;
    private void blurBackground ()
    {
        float radius = 20f;
        View decorView = getWindow().getDecorView();
        ViewGroup rootView = (ViewGroup) decorView.findViewById(android.R.id.content);
        Drawable windowBackground = decorView.getBackground();
        blurView.setupWith(rootView)
                .setFrameClearDrawable(windowBackground)
                //.setBlurAlgorithm(new SupportRenderScriptBlur(this))
                .setBlurAlgorithm(new RenderScriptBlur(this))
                .setBlurRadius(radius)
                .setHasFixedTransformationMatrix(true);
    }
    private void anhXa()
    {

    }
}
