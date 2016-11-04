package khalifa.ahmad.easyfunder.utlities.mystatic;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.network.AsyncTasks.apiAsyncTask.APIAsyncTask;
import khalifa.ahmad.easyfunder.network.DummyAPI.controllers.SignIn;
import khalifa.ahmad.easyfunder.storage.databases.CharitiesDatabase;
import khalifa.ahmad.easyfunder.userInterface.activities.tabbed.HomeActivity;
import khalifa.ahmad.easyfunder.userInterface.viewHolders.listItem.RecyclerViewHolder;

public class Global {
    public static User user;
    public static ArrayList<ArrayList<Charity>> allCharities;
    public static ArrayList<SpendingCategory> spendingCategories;
    public static CharitiesDatabase database;
    public static Context globalContext;
    public static Fragment fragment;
    public static RecyclerView.Adapter adapter;
    public static RecyclerView recyclerView;
    public static RecyclerViewHolder viewHolder;

    public static void init(final Context context, final User user){
        Global.database = new CharitiesDatabase(context);
        new APIAsyncTask(context, APIAsyncTask.GET_ALL_CHARITIES) {
            @Override
            public void onPost(Object object) {
                Global.allCharities = (ArrayList<ArrayList<Charity>>) object;
                new APIAsyncTask(context, APIAsyncTask.GET_ALL_SPENDING_CATEGORIES) {
                    @Override
                    public void onPost(Object object) {
                        Global.spendingCategories = (ArrayList<SpendingCategory>) object;
                        if (!user.getFirstName().equals("")){ // sign up
                            new APIAsyncTask(context, APIAsyncTask.GET_USER_DATA) {
                                @Override
                                public void onPost(Object object) {
                                    Global.user = (User) object;
                                    context.startActivity(HomeActivity.getIntent(context));
                                    ((Activity)context).finish();
                                }
                            }.execute(SignIn.HARD_WRITTEN_USER_EMAIL);
                        }
                        else { // sign in
                            new APIAsyncTask(context, APIAsyncTask.SIGN_IN) {
                                @Override
                                public void onPost(Object object) {
                                    if ((boolean) object == true) {
                                        new APIAsyncTask(context, APIAsyncTask.GET_USER_DATA) {
                                            @Override
                                            public void onPost(Object object) {
                                                Global.user = (User) object;
                                                context.startActivity(HomeActivity.getIntent(context));
                                                ((Activity)context).finish();
                                            }
                                        }.execute(SignIn.HARD_WRITTEN_USER_EMAIL);
                                    }
                                    else {
                                        Toast.makeText(
                                                context,
                                                "Invalid email or password",
                                                Toast.LENGTH_SHORT
                                        ).show();
                                    }
                                }
                            }.execute(user.getEmail(), user.getPassword());
                        }
                    }
                }.execute();
            }
        }.execute();
    }
}
