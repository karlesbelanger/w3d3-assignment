package ca.kgb.portraitlandscape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView mImageView;
    private String[] imgArray = {
            "http://static4.fjcdn.com/thumbnails/comments/Obligatory+response+gif+_5002e44dafbdf953942f75be2f4c510d.gif",
            "http://static2.fjcdn.com/thumbnails/comments/Mandatory+boob+gif+_ff83e77a004a0322b8437254aa01b633.gif",
            "https://media.giphy.com/media/E8wPnDQR5Ubi8/giphy.gif",
            "https://media.giphy.com/media/HEGPEWesR1Ht6/giphy.gif",
            "http://images.thehollywoodgossip.com/iu/s--zl3lxCy3--/t_full/f_auto,fl_lossy,q_75/v1406900721/hot-kate-upton-bikini-gif.gif"
   };
    private ListView mListView;
    private String[] name = {"karles", "aldo", "Mike", "Chris", "Edwin"};
    //private ArrayList<String> arrayList = new ArrayList<String>();
    private List<String> arrayList =  Arrays.asList(name);
    private ArrayAdapter<String> arrayAdapter;
    private TextView mTextView;
    private static final String TAG = MainActivity.class.getSimpleName();
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //arrayList.addAll(Arrays.asList(name));
        mListView = (ListView)findViewById(R.id.listViewSimple);
        arrayAdapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item,
                R.id.l_item_txt,
                arrayList);
        arrayAdapter.sort( comp );
        mListView.setAdapter(arrayAdapter);
        mImageView = (ImageView)findViewById(R.id.a_main_img);
       // String str = arrayAdapter.getItem(position);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                if(mImageView != null) {
                    //Log.d(TAG, "onItemClick: " + mImageView);
                    GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(mImageView);
                    Glide
                         .with(view.getContext())
                        .load(imgArray[i])
                        .into(imageViewTarget);
                }else{
                    String toastText = adapterView.getItemAtPosition(i).toString();
                    Toast.makeText(view.getContext(), toastText, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
    final private Comparator<String> comp = new Comparator<String>() {
        public int compare(String e1, String e2) {
            return e1.toString().toLowerCase().compareTo(e2.toString().toLowerCase());
        }
    };
}
