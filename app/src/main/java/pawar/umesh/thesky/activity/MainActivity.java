package pawar.umesh.thesky.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import pawar.umesh.thesky.R;
import pawar.umesh.thesky.adapter.RecyclerViewAdapter;
import pawar.umesh.thesky.model.Anime;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "http://parthinfotech.net/roku/photos.json" ;
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Anime> lstAnime ;
    private RecyclerView recyclerView ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        lstAnime = new ArrayList<> () ;
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest ( JSON_URL, new Response.Listener<JSONArray> () {
            @Override
            public void onResponse(JSONArray response) {


                JSONObject jsonObject = null;

                for (int i = 0 ; i < response.length(); i++ ){
                    try{

                        jsonObject = response.getJSONObject(i) ;
                        Anime anime = new Anime() ;
                        anime.setTitle (jsonObject.getString("title"));
                        anime.setCaption (jsonObject.getString("caption"));
                        anime.setImage (jsonObject.getString("img"));
                        lstAnime.add(anime);


                    } catch (JSONException e) {
                        e.printStackTrace ();
                    }
                }

                setuprecyclerview(lstAnime);
            }
        }, new Response.ErrorListener () {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        } );

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request) ;

    }

    private void setuprecyclerview(List<Anime> lstAnime) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter (this,lstAnime) ;
        recyclerView.setLayoutManager(new LinearLayoutManager (this));
        recyclerView.setAdapter(myadapter);

    }

}
