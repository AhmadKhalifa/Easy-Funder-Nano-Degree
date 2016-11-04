package khalifa.ahmad.easyfunder.network.AsyncTasks.apiAsyncTask;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.util.Date;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.models.transaction.Transaction;
import khalifa.ahmad.easyfunder.models.user.BankAccount;
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.AddBankAccount;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.AddSpendingCategory;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.GetAllCharities;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.GetAllSpendingCategories;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.SetUpUser;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.RemoveBankAccount;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.RemoveSpendingCategory;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.SignIn;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.SignOut;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.SignUp;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.SupportCharity;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.UnsupportCharity;

public abstract class APIAsyncTask extends AsyncTask<Object, String, Object>{

    public final static int GET_USER_DATA = 0;
    public final static int SIGN_IN = 1;
    public final static int SIGN_UP = 2;
    public final static int SIGN_OUT = 3;
    public final static int SUPPORT_CHARITY = 4;
    public final static int UNSUPPORT_CHARITY = 5;
    public final static int ADD_SPENDING_CATEGORY = 6;
    public final static int REMOVE_SPENDING_CATEGORY = 7;
    public final static int ADD_BANK_ACCOUNT = 8;
    public final static int REMOVE_BANK_ACCOUNT = 9;
    public final static int GET_ALL_CHARITIES = 10;
    public final static int GET_ALL_SPENDING_CATEGORIES = 11;

    private static String[] messages = new String[]{
            "Getting user data..",
            "Signing in...",
            "Signing up...",
            "Signing out...",
            "Supporting charity...",
            "Unsupporting charity...",
            "Adding spending category...",
            "Removing spending category...",
            "Adding bank account...",
            "Removing bank account...",
            "Loading all charities...",
            "Loading all spending categories..."
    };

    private ProgressDialog dialog;
    private int taskType;

    public APIAsyncTask(Context context, int taskType){
        dialog = new ProgressDialog(context);
        this.taskType = taskType;
    }


    @Override
    protected void onPreExecute() {
        dialog.setMessage(messages[taskType]);
        dialog.show();
    }

    @Override
    protected void onPostExecute(Object o) {
        if (dialog.isShowing()){
            dialog.dismiss();
        }
        onPost(o);
    }

    @Override
    protected Object doInBackground(Object... params) {
        Object data;
        switch (taskType){
            case GET_USER_DATA:
                data = new SetUpUser((String)params[0]).execute();
                break;
            case SIGN_IN:
                data = new SignIn((String) params[0], (String) params[1]).execute();
                break;
            case SIGN_UP:
                data = new SignUp((User) params[0]).execute();
                break;
            case SIGN_OUT:
                data = new SignOut().execute();
                break;
            case SUPPORT_CHARITY:
                data = new SupportCharity((Charity) params[0]).execute();
                break;
            case UNSUPPORT_CHARITY:
                data = new UnsupportCharity((Charity) params[0]).execute();
                break;
            case ADD_SPENDING_CATEGORY:
                data = new AddSpendingCategory((SpendingCategory) params[0]).execute();
                break;
            case REMOVE_SPENDING_CATEGORY:
                data = new RemoveSpendingCategory((SpendingCategory) params[0]).execute();
                break;
            case ADD_BANK_ACCOUNT:
                data = new AddBankAccount((BankAccount) params[0]).execute();
                break;
            case REMOVE_BANK_ACCOUNT:
                data = new RemoveBankAccount().execute();
                break;
            case GET_ALL_CHARITIES:
                data = new GetAllCharities().execute();
                break;
            case GET_ALL_SPENDING_CATEGORIES:
                data = new GetAllSpendingCategories().execute();
                break;
            default:
                data = new Object();
                break;
        }
        return data;
    }

    public abstract void onPost(Object object);
}
