package khalifa.ahmad.easyfunder.userInterface.fragments.home;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import khalifa.ahmad.easyfunder.R;
import khalifa.ahmad.easyfunder.models.user.BankAccount;
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.network.AsyncTasks.apiAsyncTask.APIAsyncTask;
import khalifa.ahmad.easyfunder.userInterface.activities.forms.BankAccountRegistrationActivity;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeProfileFragment extends Fragment implements View.OnClickListener {

    private static String ADD_ACCOUNT = "Add account";
    private static String REMOVE_ACCOUNT = "Remove account";

    private User user;
    private BankAccount bankAccount;
    private TextView name;
    private TextView email;
    private TextView phone;
    private TextView bankName;
    private TextView bankAccountNumber;
    private TextView bankBranch;
    private TextView bankSwiftCode;
    private TextView bankAddress;
    private LinearLayout bankDetailsContainer;
    private Button addOrRemoveBankAccountButton;

    public HomeProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_profile, container, false);
        init(view);
        return view;
    }

    private void init(View view){
        user = Global.user;
        name = (TextView) view.findViewById(R.id.profile_person_name);
        email = (TextView) view.findViewById(R.id.profile_email);
        phone = (TextView) view.findViewById(R.id.profile_phone);
        bankName = (TextView) view.findViewById(R.id.profile_bank_name);
        bankAccountNumber = (TextView) view.findViewById(R.id.profile_account_number);
        bankBranch = (TextView) view.findViewById(R.id.profile_branch);
        bankSwiftCode = (TextView) view.findViewById(R.id.profile_swift_code);
        bankAddress = (TextView) view.findViewById(R.id.profile_address);
        bankDetailsContainer = (LinearLayout) view.findViewById(R.id.profile_bank_account_details);
        addOrRemoveBankAccountButton = (Button) view.findViewById(R.id.add_or_remove_bank_account);
        addOrRemoveBankAccountButton.setOnClickListener(this);
        setUpUser();
    }

    private void setUpUser(){
        name.setText(user.getFirstName() + " " + user.getLastName());
        email.setText(user.getEmail());
        phone.setText(user.getPhone());
        if (user.hasBankAccount()){
            bankAccount = user.getBankAccount();
            addOrRemoveBankAccountButton.setBackgroundColor(
                    getContext().getResources().getColor(R.color.red));
            addOrRemoveBankAccountButton.setText(REMOVE_ACCOUNT);
            bankDetailsContainer.setVisibility(View.VISIBLE);
            bankName.setText(bankAccount.getBankName());
            bankAccountNumber.setText(bankAccount.getAccountNumber());
            bankBranch.setText(bankAccount.getBranch());
            bankSwiftCode.setText(bankAccount.getSwiftCode());
            bankAddress.setText(bankAccount.getAddress());
        }
        else {
            addOrRemoveBankAccountButton.setBackgroundColor(
                    getContext().getResources().getColor(R.color.green));
            addOrRemoveBankAccountButton.setText(ADD_ACCOUNT);
            bankDetailsContainer.setVisibility(View.GONE);
        }
    }

    public static HomeProfileFragment getInstance(){
        return new HomeProfileFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.add_or_remove_bank_account:
                addOrRemoveBankAccount();
                break;
        }
    }

    private void addOrRemoveBankAccount(){
        if (addOrRemoveBankAccountButton.getText().equals(ADD_ACCOUNT)){
            startActivity(BankAccountRegistrationActivity.getIntent(getContext()));
        }
        else {
            new APIAsyncTask(getContext(), APIAsyncTask.REMOVE_BANK_ACCOUNT) {
                @Override
                public void onPost(Object object) {
                    addOrRemoveBankAccountButton.setBackgroundColor(
                            getContext().getResources().getColor(R.color.green));
                    addOrRemoveBankAccountButton.setText(ADD_ACCOUNT);
                    bankDetailsContainer.setVisibility(View.GONE);
                }
            }.execute();
        }
    }
}
