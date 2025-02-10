package com.test.trabajou5listamultimedia;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class MediaDialog extends DialogFragment {
    private static final String ARG_TYPE = "type";
    private static final String ARG_ID = "id";

    public static MediaDialog newInstance(int type, int id) {
        MediaDialog fragment = new MediaDialog();
        Bundle args = new Bundle();
        args.putInt(ARG_TYPE, type);
        args.putInt(ARG_ID, id);
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        int type = getArguments() != null ? getArguments().getInt(ARG_TYPE) : 0;
        int id = getArguments() != null ? getArguments().getInt(ARG_ID) : 0;
        AlertDialog.Builder builder = new AlertDialog.Builder(requireActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_media, null);

        VideoView videoView = view.findViewById(R.id.videoView);
        WebView webView = view.findViewById(R.id.webView);
        View audioPlayButton = view.findViewById(R.id.audioPlayButton);

        if (type == 1) { // Videos
            videoView.setVisibility(View.VISIBLE);
            int videoResId = (id == 1) ? R.raw.video : R.raw.video1;
            Uri videoUri = Uri.parse("android.resource://" + requireContext().getPackageName() + "/" + videoResId);
            videoView.setVideoURI(videoUri);
            videoView.setMediaController(new MediaController(getContext()));
            videoView.start();
        } else if (type == 2) { // Audios
            audioPlayButton.setVisibility(View.VISIBLE);
            int audioResId = (id == 1) ? R.raw.audio : R.raw.audio1;
            audioPlayButton.setOnClickListener(v -> {
                MediaPlayer mediaPlayer = MediaPlayer.create(getContext(), audioResId);
                mediaPlayer.start();
            });
        } else if (type == 3) { // Webs
            webView.setVisibility(View.VISIBLE);
            String url = (id == 1) ? "https://www.lavozdegalicia.es" : "https://www.twitch.tv/";
            webView.loadUrl(url);
        }

        builder.setView(view).setNegativeButton("Cerrar", (dialog, which) -> dialog.dismiss());
        return builder.create();
    }
}


