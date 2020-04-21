package com.example.app_test.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app_test.Adapter.Recent_Adapter;
import com.example.app_test.Model.Detail_model;
import com.example.app_test.R;
import com.squareup.picasso.Picasso;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Detail_Popular_Activity extends AppCompatActivity {
    private ImageView imageView;
    private TextView txt_detailUrl,txt_type,txt_genre,txt_plot,txt_released,txt_status,txt_orther;
    String detailString,type,plot,genre,released,status,orther,img;
    ProgressDialog progressDialog;
    ArrayList<Detail_model> arrayList;
    Recent_Adapter adapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_popular);
        recyclerView=findViewById(R.id.recycleView_popolarDetail);
        recyclerView.setLayoutManager(new GridLayoutManager(Detail_Popular_Activity.this,5,GridLayoutManager.HORIZONTAL,false));
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


        imageView=findViewById(R.id.img_popularDetail);
        txt_detailUrl=findViewById(R.id.title_polularDetail);
        txt_type=findViewById(R.id.type_polularDetail);
        txt_genre=findViewById(R.id.genre_polularDetail);
        txt_plot=findViewById(R.id.plotSummary_polularDetail);
        txt_released=findViewById(R.id.released_polularDetail);
        txt_status=findViewById(R.id.status_polularDetail);
        txt_orther=findViewById(R.id.ortheName_polularDetail);
        Picasso.get().load(getIntent().getStringExtra("image")).into(imageView);
        //txt_genre.setText(getIntent().getStringExtra("genre"));
        Content content= new Content();
        content.execute();

    }
    private class Content extends AsyncTask<Void,Void,Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//            progressDialog= new ProgressDialog(Detail_Popular_Activity.this);
//            progressDialog.setMessage("Loading Data...");
//            progressDialog.show();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            txt_detailUrl.setText(detailString);
            txt_type.setText(type);
            txt_plot.setText(plot);
            txt_genre.setText(genre);
            txt_released.setText(released);
            txt_status.setText(status);
            txt_orther.setText(orther);
            //progressDialog.dismiss();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try
            {
                String baseUrl="https://gogoanime.movie/";
                String detailUrl=getIntent().getStringExtra("detailUrl");
                String url=baseUrl+detailUrl;
                Document doc= org.jsoup.Jsoup.connect(url).get();
                Elements data=doc.select("div.anime_info_body");
                detailString=doc.select("h1").text();
                img=doc.select("img").attr("src");
                for(int i=0;i<data.size();i++)
                {
                    type = data.select("p.type").select("a").attr("title");
                    plot=data.select("p.type").get(1).text();
                    genre=data.select("p.type").get(2).text();
                    released=data.select("p.type").get(3).text();
                    status=data.select("p.type").get(4).text();
                    orther=data.select("p.type").get(5).text();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
