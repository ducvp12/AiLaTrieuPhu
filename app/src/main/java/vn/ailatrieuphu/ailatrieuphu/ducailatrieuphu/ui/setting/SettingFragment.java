package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.setting;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.R;

public class SettingFragment extends Fragment {
    public MediaPlayer playr;
    private SettingViewModel shareViewModel;
    Boolean switchState;
    ImageView img;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(SettingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);

        playr=MediaPlayer.create(getContext(),R.raw.loinho);

//        img.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(!playr.isPlaying()){
////                    playr.seekTo(0);
//                    playr.start();
//                    playr.setLooping(true);
//                    img.setImageResource(R.drawable.app__ic_toggle_on);
//
//                } else {
//                    playr.pause();
//                    img.setImageResource(R.drawable.app__ic_toggle_off);
//                }
//            }
//        });

        final ToggleButton toggle = (ToggleButton) root.findViewById(R.id.imgcheck);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    playr.start();
                    playr.setLooping(true);
                    toggle.setChecked(true);
                } else {
                    playr.pause();
                    toggle.setChecked(false);
                }
            }
        });



        return root;
    }
}