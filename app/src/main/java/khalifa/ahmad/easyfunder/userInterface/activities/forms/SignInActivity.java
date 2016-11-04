package khalifa.ahmad.easyfunder.userInterface.activities.forms;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.charity.Metrics;
import khalifa.ahmad.easyfunder.models.user.BankAccount;
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.network.AsyncTasks.apiAsyncTask.APIAsyncTask;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.HomeActivity;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button signInButton;
    private Button signUpButton;
    private boolean somethingMissing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
        }
        init();
    }


    private void init(){
        emailEditText = (EditText)findViewById(R.id.sign_in_email);
        passwordEditText = (EditText)findViewById(R.id.sign_in_password);
        signInButton = (Button)findViewById(R.id.sign_in_sign_in);
        signUpButton = (Button)findViewById(R.id.sign_in_sign_up);
        signInButton.setOnClickListener(this);
        signUpButton.setOnClickListener(this);
    }

    public static Intent getIntent(Context context){
        return new Intent(context, SignInActivity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_in_sign_in:
                signIn();
                break;
            case R.id.sign_in_sign_up:
                startActivity(SignUpActivity.getIntent(this));
                break;
        }
    }

    private void signIn(){
        somethingMissing =
                (
                        emailEditText.getText().toString().equals("") ||
                        passwordEditText.getText().toString().equals("")
                )
        ;
        if (somethingMissing){
            showError("Please fill all required fields");
        }
        else {
            Global.init(
                    this,
                    new User(
                            "",
                            "",
                            emailEditText.getText().toString(),
                            "",
                            passwordEditText.getText().toString()
                    )
            );
        }
    }

    private void showError(String message){
        Snackbar.make(signInButton, message, Snackbar.LENGTH_SHORT).show();
    }
}
