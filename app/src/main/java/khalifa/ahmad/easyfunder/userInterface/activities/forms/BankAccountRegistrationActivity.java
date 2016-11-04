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

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.user.BankAccount;
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.network.AsyncTasks.apiAsyncTask.APIAsyncTask;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.HomeActivity;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class BankAccountRegistrationActivity extends AppCompatActivity
        implements View.OnClickListener {

    private EditText bankName;
    private EditText accountNumber;
    private EditText branch;
    private EditText swiftCode;
    private EditText address;
    private Button addAccountButton;
    private boolean somethingMissing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_account_registeration);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.green_dark));
        }
        init();
    }

    private void init(){
        bankName = (EditText)findViewById(R.id.bank_bank_name);
        accountNumber = (EditText)findViewById(R.id.bank_account_number);
        branch = (EditText)findViewById(R.id.bank_branch);
        swiftCode = (EditText)findViewById(R.id.bank_swift_code);
        address = (EditText)findViewById(R.id.bank_address);
        addAccountButton = (Button)findViewById(R.id.bank_add_account);
        addAccountButton.setOnClickListener(this);
    }

    private void addBankAccount(){
        somethingMissing =
                (
                        bankName.getText().toString().equals("") ||
                                accountNumber.getText().toString().equals("") ||
                                branch.getText().toString().equals("") ||
                                swiftCode.getText().toString().equals("") ||
                                address.getText().toString().equals("")
                )
        ;

        if (somethingMissing){
            showError("Please fill all required fields");
        }

        else {
            BankAccount bankAccount = new BankAccount(
                    bankName.getText().toString(),
                    branch.getText().toString(),
                    accountNumber.getText().toString(),
                    swiftCode.getText().toString(),
                    address.getText().toString()
            );
            new APIAsyncTask(this, APIAsyncTask.ADD_BANK_ACCOUNT) {
                @Override
                public void onPost(Object object) {
                    startActivity(HomeActivity.getIntent(BankAccountRegistrationActivity.this));
                    BankAccountRegistrationActivity.this.finish();
                }
            }.execute(bankAccount);
        }
    }

    private void showError(String message){
        Snackbar.make(addAccountButton, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bank_add_account:
                addBankAccount();
                break;
        }
    }

    public static Intent getIntent(Context context){
        return new Intent(context, BankAccountRegistrationActivity.class);
    }
}
