package khalifa.ahmad.easyfunder.userInterface.activities.forms;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.network.AsyncTasks.apiAsyncTask.APIAsyncTask;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.HomeActivity;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private EditText phoneNumberEditText;
    private EditText passwordEditText;
    private Button signUpButton;
    private boolean somethingMissing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
        }
        init();
    }
    public static Intent getIntent(Context context){
        return new Intent(context, SignUpActivity.class);
    }

    private void init(){
        firstNameEditText = (EditText)findViewById(R.id.sign_up_first_name);
        lastNameEditText = (EditText)findViewById(R.id.sign_up_last_name);
        emailEditText = (EditText)findViewById(R.id.sign_up_email);
        phoneNumberEditText = (EditText)findViewById(R.id.sign_up_phone_number);
        passwordEditText = (EditText)findViewById(R.id.sign_up_password);
        signUpButton = (Button)findViewById(R.id.sign_up_sign_up);
        signUpButton.setOnClickListener(this);
    }

    private void signUp(){
        somethingMissing =
                (
                        firstNameEditText.getText().toString().equals("") ||
                        lastNameEditText.getText().toString().equals("") ||
                        emailEditText.getText().toString().equals("") ||
                        passwordEditText.getText().toString().equals("") ||
                        phoneNumberEditText.getText().toString().equals("")
                )
        ;

        if (somethingMissing){
            showError("Please fill all required fields");
        }

        else {
            Global.init(
                    this,
                    new User(
                            firstNameEditText.getText().toString(),
                            lastNameEditText.getText().toString(),
                            emailEditText.getText().toString(),
                            phoneNumberEditText.getText().toString(),
                            passwordEditText.getText().toString()
                    )
            );
        }
    }

    private void showError(String message){
        Snackbar.make(signUpButton, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.sign_up_sign_up:
                signUp();
                break;
        }
    }
}
