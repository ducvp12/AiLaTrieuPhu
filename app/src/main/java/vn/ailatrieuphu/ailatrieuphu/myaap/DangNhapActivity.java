package vn.ailatrieuphu.ailatrieuphu.myaap;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

public class DangNhapActivity extends AppCompatActivity implements  GoogleApiClient.OnConnectionFailedListener,View.OnClickListener {

    CallbackManager callbackManager;
    private TextView tvNamefb;
    private TextView tvEmailfb;
    Button signout;
    private LoginButton loginButton;
    private ImageView img;
    private GoogleApiClient googleApiClient;
    GoogleSignInOptions gso;
    int RC_SIGN_IN = 9001;
    RelativeLayout rl;
    SignInButton signInButton;

    GoogleSignInClient mGoogleSignInClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       FacebookSdk.sdkInitialize(this.getApplicationContext());
        setContentView(R.layout.activity_dang_nhap);
        initView();
        AccessToken accessToken = AccessToken.getCurrentAccessToken();
//        MediaPlayer nhacnen=new MediaPlayer();
//        nhacnen = nhacnen.create(this, R.raw.opening );
//        nhacnen.setLooping(true);
//        boolean isLoggedIn = accessToken != null && !accessToken.isExpired();

        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

//       CallbackManager callbackManager = CallbackManager.Factory.create();

     //   LoginFB();
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                // App code
//            }
//
//            @Override
//            public void onCancel() {
//                // App code
//            }
//
//            @Override
//            public void onError(FacebookException exception) {
//                // App code
//            }
//        });

        signInButton.setOnClickListener(this);
        signout.setOnClickListener(this);


        // Dang nhap GG------------------------------------------------

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(this).enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }



    public void LoginFB() {
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        tvEmailfb.setVisibility(View.VISIBLE);
                        setFacebookData(loginResult);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
    }

    public void setFacebookData(final LoginResult loginResult) {
        GraphRequest request = GraphRequest.newMeRequest(
                loginResult.getAccessToken(),
                new GraphRequest.GraphJSONObjectCallback() {
                    @Override
                    public void onCompleted(JSONObject object, GraphResponse response) {
                        // Application code
                        try {
                            Log.i("Response", response.toString());

                            String email = object.getString("email");
                            String name = object.getString("name");
                            String firstName = object.getString("first_name");
                            String lastName = response.getJSONObject().getString("last_name");
                            String gender = response.getJSONObject().getString("gender");

                            Profile profile = Profile.getCurrentProfile();
                            String id = profile.getId();
                            String link = profile.getLinkUri().toString();
                            Log.i("Link", link);
                            tvEmailfb.setText(lastName);
                            if (Profile.getCurrentProfile() != null) {
                                Log.i("Login", "ProfilePic" + Profile.getCurrentProfile().getProfilePictureUri(200, 200));
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });

        Bundle parameters = new Bundle();
        parameters.putString("fields", "id,email,first_name,last_name,gender,name");

        request.setParameters(parameters);
        request.executeAsync();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==RC_SIGN_IN){
            GoogleSignInResult result=Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            handleResult(result);
        }
    }



    private void initView() {
        tvNamefb = (TextView) findViewById(R.id.tv_namefb);
        tvEmailfb = (TextView) findViewById(R.id.tv_emailfb);
        loginButton = (LoginButton) findViewById(R.id.login_button);
        img = (ImageView) findViewById(R.id.img);
        signInButton = findViewById(R.id.sign_in_buttongg);
        rl = findViewById(R.id.rl);
         signout=findViewById(R.id.btn_signOut);
    }




    private void handleResult(GoogleSignInResult googleSignInResult) {
        if (googleSignInResult.isSuccess()) {
            GoogleSignInAccount acc=googleSignInResult.getSignInAccount();
            tvNamefb.setText(acc.getDisplayName().toString());
            tvEmailfb.setText(acc.getEmail().toString());
            Log.e("Tvnam",acc.getDisplayName().toString());
            if (acc.getPhotoUrl().toString()!= null){
                Picasso.with(this).load(acc.getPhotoUrl().toString()).into(img);  }
            else{
                Picasso.with(this).load("https://d3q6qq2zt8nhwv.cloudfront.net/m/1_extra_7fb5mqex.jpg").into(img);
            }
            updateUI(true);
        }
        else
        {updateUI(false);
        }
    }
    private void updateUI( boolean islogin) {
        if (islogin) {
            rl.setVisibility(View.VISIBLE);
            signInButton.setVisibility(View.GONE);
        } else {
            rl.setVisibility(View.VISIBLE); ;
            signInButton.setVisibility(View.GONE); ;
        }
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.sign_in_buttongg:
                signinGG();
                break;
            case R.id.btn_signOut:
                singout();
                break;
        }
    }

    public void singout() {
//        mGoogleSignInClient.signOut()
////                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
////                    @Override
////                    public void onComplete(@NonNull Task<Void> task) {
////                        Toast.makeText(DangNhapActivity.this, "Signout success", Toast.LENGTH_LONG).show();
////                    }
////                });

        finish();
    }
    public void signinGG() {
        Intent intent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
        Toast.makeText(DangNhapActivity.this, "Signin success", Toast.LENGTH_LONG).show();
        startActivityForResult(intent, RC_SIGN_IN);
    }
}
