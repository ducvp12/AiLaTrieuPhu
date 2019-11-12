package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.List;

import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.HomeActiveActivity;
import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.HomeActivity;
import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.R;
import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.home.HomeFragment;

public class LoginActivity extends AppCompatActivity {
    int RC_SIGN_IN = 1;
    List<AuthUI.IdpConfig> providers = Arrays.asList(
            new AuthUI.IdpConfig.EmailBuilder().build(),
            new AuthUI.IdpConfig.PhoneBuilder().build(),
            new AuthUI.IdpConfig.GoogleBuilder().build());

    // Create and launch sign-in intent

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        package vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ProgressDialog;
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.util.Log;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.ProgressBar;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.auth.api.Auth;
//import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
//import com.google.android.gms.auth.api.signin.GoogleSignInResult;
//import com.google.android.gms.common.ConnectionResult;
//import com.google.android.gms.common.SignInButton;
//import com.google.android.gms.common.api.GoogleApiClient;
//import com.google.android.gms.common.api.OptionalPendingResult;
//import com.google.android.gms.common.api.ResultCallback;
//import com.google.android.gms.common.api.Status;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.squareup.picasso.Picasso;
//
//import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.HomeActiveActivity;
//import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.HomeActivity;
//import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.R;
//import vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.ui.home.HomeFragment;
//
//        public class LoginFirebaseActivity extends AppCompatActivity implements
//                GoogleApiClient.OnConnectionFailedListener,
//                View.OnClickListener{
//            private EditText inputEmail, inputPassword;
//            private Button btnSignIn, btnSignUp, btnResetPassword;
//            private ProgressBar progressBar;
//            private FirebaseAuth auth;
//            SignInButton signInButton;
//
//            private static final String TAG = "SignInActivity";
//            private static final int RC_SIGN_IN = 9001;
//
//            private GoogleApiClient mGoogleApiClient;
//            private TextView mStatusTextView;
//            private ProgressDialog mProgressDialog;
//            ImageView img;
//            @Override
//            protected void onCreate(Bundle savedInstanceState)  {
//                super.onCreate(savedInstanceState);
//                setContentView(R.layout.activity_login_firebase);
////        signin=findViewById(R.id.sign_firebase);
////        rl=findViewById(R.id.rl2);
////        iv_image=findViewById(R.id.img_firebase);
////        name=findViewById(R.id.tv_namefirebase);
////        email=findViewById(R.id.tv_emailFirebase);
////
////        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
////                .requestIdToken(getString(R.string.default_web_client_id))
////                .requestEmail()
////                .build();
////        mAuth = FirebaseAuth.getInstance();
////        mAuthListener = new FirebaseAuth.AuthStateListener() {
////            @Override
////            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
////                FirebaseUser user = firebaseAuth.getCurrentUser();
////                if (user != null) {
////                    // User is signed in
////                    Log.d("LoginActivity", "onAuthStateChanged:signed_in:" + user.getUid());
////                } else {
////                    // User is signed out
////                    Log.d("LoginActivity", "onAuthStateChanged:signed_out");
////                }
////                // [START_EXCLUDE]
////                updateUI(user);
////                // [END_EXCLUDE]
////            }
////        };
////    }
////    private void signIn() {
////        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
////        startActivityForResult(signInIntent, 9001);
////    }
////    @Override
////    public void onActivityResult(int requestCode, int resultCode, Intent data) {
////        super.onActivityResult(requestCode, resultCode, data);
////
////        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
////        if (requestCode == 9001) {
////            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
////            try {
////                // Google Sign In was successful, authenticate with Firebase
////                GoogleSignInAccount account = task.getResult(ApiException.class);
////                firebaseAuthWithGoogle(account);
////            } catch (ApiException e) {
////                // Google Sign In failed, update UI appropriately
////                Log.e("haha", "Google sign in failed", e);
////                // ...
////            }
////        }
////    }
////
////
////    @Override
////    public void onStart() {
////        super.onStart();
////        // Check if user is signed in (non-null) and update UI accordingly.
////        FirebaseUser currentUser = mAuth.getCurrentUser();
////        updateUI(currentUser);
////        mAuth.addAuthStateListener(mAuthListener);
////    }
////
////    @Override
////    public void onStop() {
////        super.onStop();
////        if (mAuthListener != null) {
////            mAuth.removeAuthStateListener(mAuthListener);
////        }
////    }
////
////    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
////        Log.d("LoginActivity", "firebaseAuthWithGoogle:" + acct.getId());
////        // [START_EXCLUDE silent]
////        try {
////
////            dialog.show();
////        } catch (Exception e) {
////
////        }
////        // [END_EXCLUDE]
////
////        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
////        mAuth.signInWithCredential(credential)
////                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
////                    @Override
////                    public void onComplete(@NonNull Task<AuthResult> task) {
////                        Log.d("LoginActivity", "signInWithCredential:onComplete:" + task.isSuccessful());
////
////                        // If sign in fails, display a message to the user. If sign in succeeds
////                        // the auth state listener will be notified and logic to handle the
////                        // signed in user can be handled in the listener.
////                        if (!task.isSuccessful()) {
////                            Log.w("LoginActivity", "signInWithCredential", task.getException());
////                            Toast.makeText(LoginFirebaseActivity.this, "Authentication failed.",
////                                    Toast.LENGTH_SHORT).show();
////                        }
////
////                        // [START_EXCLUDE]
////
////                        try {
////
////                            dialog.dismiss();
////                        } catch (Exception e) {
////
////                        }
////                        // [END_EXCLUDE]
////                    }
////                });}
////
////    private void updateUI(FirebaseUser user) {
////        try {
////            dialog.dismiss();
////        } catch (Exception e) {
////
////        }
////
////        if (user != null) {
////            String str_emailgoogle = user.getEmail();
////            Log.e("Email", str_emailgoogle);
////            email.setText(str_emailgoogle);
////            name.setText(user.getDisplayName());
////            boolean_google=true;
////
////            Picasso.with(LoginFirebaseActivity.this).load( user.getPhotoUrl()).into(iv_image);
////
////
////            Log.e("Profile", user.getPhotoUrl() + "");
////
////        } else {
////
////        }
////    }
////
////    @Override
////    public void onClick(View view) {
////        switch (view.getId()){
////            case R.id.sign_firebase:
////                signIn();
////                break;
////        }
////    }
////
////    @Override
////    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
////        Log.d("LoginActivity", "onConnectionFailed:" + connectionResult);
////        Toast.makeText(this, "Google Play Services error.", Toast.LENGTH_SHORT).show();
////    }
////}
//
//
//                auth = FirebaseAuth.getInstance();
//
//                btnSignIn = (Button) findViewById(R.id.sign_in_button);
//                btnSignUp = (Button) findViewById(R.id.sign_up_button);
//                inputEmail = (EditText) findViewById(R.id.email);
//                inputPassword = (EditText) findViewById(R.id.password);
//                progressBar = (ProgressBar) findViewById(R.id.progressBar);
//                btnResetPassword = (Button) findViewById(R.id.btn_reset_password);
//                signInButton= (SignInButton) findViewById(R.id.logingg_fb);
//                img=findViewById(R.id.imggggg);
//
//
//                GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                        .requestEmail()
//                        .build();
//
//                mGoogleApiClient = new GoogleApiClient.Builder(this)
//                        .enableAutoManage(this /* FragmentActivity */, this /* OnConnectionFailedListener */)
//                        .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
//                        .build();
//
//
//                btnResetPassword.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        startActivity(new Intent(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, HomeActivity.class));
//                    }
//                });
//
//                btnSignIn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        Intent intent = new Intent(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, HomeActivity.class);
//                        startActivity(intent);
//                    }
//                });
//
//                signInButton.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//
//
//                        signIn();
//
//                    }
//                });
//
//
//                btnSignUp.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        String email = inputEmail.getText().toString().trim();
//                        String password = inputPassword.getText().toString().trim();
//
//                        if (TextUtils.isEmpty(email)) {
//                            Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//
//                        if (TextUtils.isEmpty(password)) {
//                            Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//
//                        if (password.length() < 6) {
//                            Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
//
//                        progressBar.setVisibility(View.VISIBLE);
//                        //create user
//                        auth.createUserWithEmailAndPassword(email, password)
//                                .addOnCompleteListener(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, new OnCompleteListener<AuthResult>() {
//                                    @Override
//                                    public void onComplete(@NonNull Task<AuthResult> task) {
//                                        Toast.makeText(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
//                                        progressBar.setVisibility(View.GONE);
//                                        // If sign in fails, display a message to the user. If sign in succeeds
//                                        // the auth state listener will be notified and logic to handle the
//                                        // signed in user can be handled in the listener.
//                                        if (!task.isSuccessful()) {
//                                            Toast.makeText(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, "Authentication failed." + task.getException(),
//                                                    Toast.LENGTH_SHORT).show();
//                                        } else {
//                                            startActivity(new Intent(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, HomeActivity.class));
//                                            finish();
//                                        }
//                                    }
//                                });
//
//                    }
//                });
//            }
//
//
//
//
//
//            @Override
//            protected void onResume() {
//                super.onResume();
//                progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onClick(View view) {
//
//            }
//
//            @Override
//            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
//                Log.d(TAG, "onConnectionFailed:" + connectionResult);
//
//            }
//
//            @Override
//            protected void onStart() {
//                super.onStart();
//                OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(mGoogleApiClient);
//                if (opr.isDone()) {
//                    // If the user's cached credentials are valid, the OptionalPendingResult will be "done"
//                    // and the GoogleSignInResult will be available instantly.
//                    Log.d(TAG, "Got cached sign-in");
//                    GoogleSignInResult result = opr.get();
//                    handleSignInResult(result);
//                } else {
//                    // If the user has not previously signed in on this device or the sign-in has expired,
//                    // this asynchronous branch will attempt to sign in the user silently.  Cross-device
//                    // single sign-on will occur in this branch.
////            showProgressDialog();
//                    opr.setResultCallback(new ResultCallback<GoogleSignInResult>() {
//                        @Override
//                        public void onResult(GoogleSignInResult googleSignInResult) {
//                            hideProgressDialog();
//                            handleSignInResult(googleSignInResult);
//                        }
//                    });
//                }
//            }
//
//
//            @Override
//            public void onActivityResult(int requestCode, int resultCode, Intent data) {
//                super.onActivityResult(requestCode, resultCode, data);
//
//                // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//                if (requestCode == RC_SIGN_IN) {
//                    GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
//                    handleSignInResult(result);
//                }
//            }
//
//            private void handleSignInResult(GoogleSignInResult result) {
//                Log.d(TAG, "handleSignInResult:" + result.isSuccess());
//                if (result.isSuccess()) {
//                    // Signed in successfully, show authenticated UI.
//                    GoogleSignInAccount acct = result.getSignInAccount();
//                    Toast.makeText(this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                    inputEmail.setText(acct.getEmail() );
//
//                    inputPassword.setText(acct.getDisplayName());
//
//
//                    if (acct.getPhotoUrl().toString()!= null){
//                        Picasso.with(this).load(acct.getPhotoUrl().toString()).into(img);  }
//                    else{
//                        Picasso.with(this).load("https://d3q6qq2zt8nhwv.cloudfront.net/m/1_extra_7fb5mqex.jpg").into(img);
//                    }
//
//                    auth.createUserWithEmailAndPassword(acct.getEmail(),acct.getDisplayName())
//                            .addOnCompleteListener(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, new OnCompleteListener<AuthResult>() {
//                                @Override
//                                public void onComplete(@NonNull Task<AuthResult> task) {
//                                    Toast.makeText(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, "createUserWithEmail:onComplete:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
//                                    progressBar.setVisibility(View.GONE);
//                                    // If sign in fails, display a message to the user. If sign in succeeds
//                                    // the auth state listener will be notified and logic to handle the
//                                    // signed in user can be handled in the listener.
//                                    if (!task.isSuccessful()) {
//                                        Toast.makeText(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, "Authentication failed." + task.getException(),
//                                                Toast.LENGTH_SHORT).show();
//                                    } else {
//                                        startActivity(new Intent(vn.ailatrieuphu.ailatrieuphu.ducailatrieuphu.loginfirebase.LoginFirebaseActivity.this, HomeActivity.class));
//                                        finish();
//                                    }
//                                }
//                            });
//                    Bundle bundle = new Bundle();
//                    bundle.putString("na", acct.getDisplayName() );
//                    bundle.putString("img", acct.getPhotoUrl().toString());
//                    Log.e("bundle", bundle.toString());
//                    HomeFragment fragInfo = new HomeFragment ();
//                    fragInfo.setArguments(bundle);
//
//                    getSupportFragmentManager().beginTransaction().replace(R.id.nav_home, fragInfo);
//                    getSupportFragmentManager().beginTransaction().commit();
//
//                    Intent intent=new Intent(this, HomeActiveActivity.class);
//                    intent.putExtra("nameemail",acct.getDisplayName());
//                    intent.putExtra("imgemail",acct.getPhotoUrl());
//                    startActivity(intent);
////            mStatusTextView.setText(getString(R.string.signed_in_fmt, acct.getDisplayName()));
//                    updateUI(true);
//                } else {
//                    // Signed out, show unauthenticated UI.
//                    updateUI(false);
//                }
//            }
//
//            private void signIn() {
//                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
//                startActivityForResult(signInIntent, RC_SIGN_IN);
//            }
//
//            private void signOut() {
//                Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(
//                        new ResultCallback<Status>() {
//                            @Override
//                            public void onResult(Status status) {
//                                // [START_EXCLUDE]
//                                updateUI(false);
//                                // [END_EXCLUDE]
//                            }
//                        });
//            }
//
//
//            private void revokeAccess() {
//                Auth.GoogleSignInApi.revokeAccess(mGoogleApiClient).setResultCallback(
//                        new ResultCallback<Status>() {
//                            @Override
//                            public void onResult(Status status) {
//                                // [START_EXCLUDE]
//                                updateUI(false);
//                                // [END_EXCLUDE]
//                            }
//                        });
//            }
//
////    private void showProgressDialog() {
////        if (mProgressDialog == null) {
////            mProgressDialog = new ProgressDialog(this);
////            mProgressDialog.setMessage(getString(R.string.loading));
////            mProgressDialog.setIndeterminate(true);
////        }
//
////        mProgressDialog.show();
////    }
//
//            private void hideProgressDialog() {
//                if (mProgressDialog != null && mProgressDialog.isShowing()) {
//                    mProgressDialog.hide();
//                }
//            }
//
//            private void updateUI(boolean signedIn) {
//                if (signedIn) {
//                    findViewById(R.id.sign_in_button).setVisibility(View.GONE);
//
//                } else {
////            mStatusTextView.setText(R.string.signed_out);
//
//                    findViewById(R.id.sign_in_button).setVisibility(View.VISIBLE);
////            findViewById(R.id.sign_out_and_disconnect).setVisibility(View.GONE);
//                }
//            }
//
//
////    @Override
////    public void onClick(View v) {
////        switch (v.getId()) {
////            case R.id.sign_in_button:
////                signIn();
////                break;
//////            case R.id.sign_out_button:
//////                signOut();
//////                break;
//////            case R.id.disconnect_button:
//////                revokeAccess();
//////                break;
////        }
//
//        }


    }

    public void bt(View view) {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                // ...
            } else {
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
}
