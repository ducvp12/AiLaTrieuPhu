package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.tools;


import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class XHTGFragment extends Fragment {

    public static final String TAG = XHTGFragment.class.getSimpleName();

    private List<ModelXHTuan> list;
    private XHTuanAdapter adapter;
    RecyclerView rv;
    private int mPage;
    private String mTitle;
    private TextView mText;
    LinearLayoutManager linearLayoutManager;

    private EditText mEditText;

    public XHTGFragment() {
        // Required empty public constructor
    }

    /**
     * Create only one instance of fragment
     *
     * @param page
     * @param title
     * @return
     */
    public static XHTGFragment newInstance(int page, String title) {
        XHTGFragment homeFragment = new XHTGFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        homeFragment.setArguments(args);
        return homeFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt("page", 0);
        mTitle = getArguments().getString("title");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_thegioit, container, false);
        mText = (TextView) rootView.findViewById(R.id.text);
        rv= rootView.findViewById(R.id.rv_thegioi);
        list=new ArrayList<>();
        for (int i=1;i<40;i++){
            list.add(new ModelXHTuan("https://datvietmedia.com/wp-content/uploads/2019/05/da-dep5.jpg","Trung kiên","10000",""+i));
        }
        rv.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        adapter = new XHTuanAdapter((ArrayList<ModelXHTuan>) list,getActivity());
        rv.setAdapter(adapter);
//        for (int i = 0; i < 40; i++) {
//            list.add(new ModelXHTuan( "https://2.bp.blogspot.com/-fjf5yU5r1Jk/WE1VD1BBKpI/AAAAAAAAjgI/bXwGoigAPJYvScMPtzJtzbOJfoGQO2C_ACEw/s1600/15349541_533868826819201_3350340522319981193_n.jpg", "Trung Kiên",  "1 Tỷ"));
//        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                final XHTuanAdapter adapter = new XHTuanAdapter(c);
//                c.runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        recyclerView.setAdapter(adapter);
//                    }
//                });
//            }
//        }).start();
        Log.e("list", list.toString());
        Log.e("list", String.valueOf(list.size()));

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String text = mEditText.getText().toString().trim();
        if (text != null) {
            outState.putString("text", text);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            String text_old = savedInstanceState.getString("text");
            mEditText.setText(text_old);
        }
    }
}