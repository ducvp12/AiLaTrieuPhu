package vn.ailatrieuphu.ailatrieuphu.myaap.ui.tools;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.ailatrieuphu.ailatrieuphu.myaap.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class XHTGFragment extends Fragment {

    public static final String TAG = XHTGFragment.class.getSimpleName();

    private int mPage;
    private String mTitle;
    private TextView mText;

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
