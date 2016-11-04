package khalifa.ahmad.easyfunder.storage.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.charity.builders.CharityBuilder;
import khalifa.ahmad.easyfunder.models.charity.builders.MetricsBuilder;

public class CharitiesDatabase extends SQLiteOpenHelper{
    
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "CharitiesDatabase";
    private static final String TABLE_CHARITIES = "charities";
    private static final String KEY_NAME = "name";
    private static final String KEY_CATEGORY = "category";
    private static final String KEY_RATE = "rate";
    private static final String KEY_MISSION = "mission";
    private static final String KEY_TOTAL_CONTRIBUTION = "contribution";
    private static final String KEY_TOTAL_REVENUE = "total_revenue";
    private static final String KEY_PROGRAM_EXPENSES = "program_expenses";
    private static final String KEY_FUNDRAISING_EXPENSES = "fundraising_expenses";
    private static final String KEY_FUNCTIONAL_EXPENSES = "functional_expenses";
    private static final String KEY_NET_ASSETS = "net_assets";

    public CharitiesDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CHARITIES_TABLE =
                String.format("CREATE TABLE %s (", TABLE_CHARITIES) +
                        String.format("%s TEXT PRIMARY KEY, ", KEY_NAME) +
                        String.format("%s TEXT, ", KEY_CATEGORY) +
                        String.format("%s TEXT, ", KEY_RATE) +
                        String.format("%s TEXT, ", KEY_MISSION) +
                        String.format("%s TEXT, ", KEY_TOTAL_CONTRIBUTION) +
                        String.format("%s TEXT, ", KEY_TOTAL_REVENUE) +
                        String.format("%s TEXT, ", KEY_PROGRAM_EXPENSES) +
                        String.format("%s TEXT, ", KEY_FUNDRAISING_EXPENSES) +
                        String.format("%s TEXT, ", KEY_FUNCTIONAL_EXPENSES) +
                        String.format("%s ", KEY_NET_ASSETS) +
                        ")";
        db.execSQL(CREATE_CHARITIES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CHARITIES);
        onCreate(db);
    }

    public boolean addCharity(Charity charity){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = getValues(charity);
        database.insert(TABLE_CHARITIES, null, values);
        database.close();
        return true;
    }

    public ArrayList<Charity> getAllCharities(){
        ArrayList<Charity> charities = new ArrayList<>();
        String query = String.format("SELECT * FROM %s", TABLE_CHARITIES);
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()){
            do {
                charities.add(getCharity(cursor));
            } while (cursor.moveToNext());
        }
        return charities;
    }

    private ContentValues getValues(Charity charity){
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, charity.getName());
        values.put(KEY_CATEGORY, String.valueOf(charity.getCategory()));
        values.put(KEY_RATE, String.valueOf(charity.getRate()));
        values.put(KEY_MISSION, charity.getMission());
        values.put(KEY_TOTAL_CONTRIBUTION, charity.getMetrics().getTotalContributions());
        values.put(KEY_TOTAL_REVENUE, charity.getMetrics().getTotalRevenue());
        values.put(KEY_PROGRAM_EXPENSES, String.valueOf(charity.getMetrics().getProgramExpenses()));
        values.put(KEY_FUNDRAISING_EXPENSES, charity.getMetrics().getFundraisingExpenses());
        values.put(KEY_FUNCTIONAL_EXPENSES, charity.getMetrics().getTotalFunctionalExpenses());
        values.put(KEY_NET_ASSETS, String.valueOf(charity.getMetrics().getNetAssets()));
        return values;
    }

    private Charity getCharity(Cursor cursor){
        return new CharityBuilder()
                .name(cursor.getString(0))
                .category(Integer.parseInt(cursor.getString(1)))
                .rate(Double.parseDouble(cursor.getString(2)))
                .mission(cursor.getString(3))
                .metrics(
                        new MetricsBuilder()
                        .totalContributions(cursor.getString(4))
                        .totalRevenue(cursor.getString(5))
                        .programExpenses(cursor.getString(6))
                        .fundraisingExpenses(cursor.getString(7))
                        .totalFunctionalExpenses(cursor.getString(8))
                        .netAssets(cursor.getString(9))
                        .build()
                ).build();
    }
}
