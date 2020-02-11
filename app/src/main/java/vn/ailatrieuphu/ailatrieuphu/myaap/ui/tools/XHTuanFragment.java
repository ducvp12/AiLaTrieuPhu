package vn.ailatrieuphu.ailatrieuphu.myaap.ui.tools;


import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.ailatrieuphu.ailatrieuphu.myaap.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class XHTuanFragment extends Fragment {

    private int mPage;
    private String mTitle;
    private TextView mText;

    public XHTuanFragment() {
        // Required empty public constructor
    }

    /**
     * Create only one instance of fragment
     *
     * @param page
     * @param title
     * @return
     */
    public static XHTuanFragment newInstance(int page, String title) {
        XHTuanFragment contactsFragment = new XHTuanFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title", title);
        contactsFragment.setArguments(args);
        return contactsFragment;
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
        View rootView = inflater.inflate(R.layout.fragment_tuan, container, false);
        mText = (TextView) rootView.findViewById(R.id.text);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
