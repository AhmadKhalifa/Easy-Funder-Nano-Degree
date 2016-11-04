package khalifa.ahmad.easyfunder.models.user;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.models.transaction.Transaction;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private BankAccount bankAccount;
    private ArrayList<Charity> supportedCharities;
    private ArrayList<SpendingCategory> usedSpendingCategories;
    private Transaction lastMonthTransaction;
    private Transaction currentMonthTransaction;

    public User(
            String firstName,
            String lastName,
            String email,
            String phone,
            String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.password = password;
        supportedCharities = new ArrayList<>();
        usedSpendingCategories = new ArrayList<>();
        bankAccount = null;
    }


    private boolean passwordMatch(String password){
        return this.password.equals(password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public ArrayList<Charity> getSupportedCharities() {
        return supportedCharities;
    }

    public void setSupportedCharities(ArrayList<Charity> supportedCharities) {
        this.supportedCharities = supportedCharities;
    }

    public ArrayList<SpendingCategory> getUsedSpendingCategories() {
        return usedSpendingCategories;
    }

    public void setUsedSpendingCategories(ArrayList<SpendingCategory> usedSpendingCategories) {
        this.usedSpendingCategories = usedSpendingCategories;
    }

    public Transaction getLastMonthTransaction() {
        return lastMonthTransaction;
    }

    public void setLastMonthTransaction(Transaction lastMonthTransaction) {
        this.lastMonthTransaction = lastMonthTransaction;
    }

    public Transaction getCurrentMonthTransaction() {
        this.currentMonthTransaction = new Transaction(
                new Date(2016, 11, 1),
                getTotalAmountDonated(),
                getCurrentlyUsedSpendingCategories()
        );
        return currentMonthTransaction;
    }

    public double getTotalAmountDonated(){
        double amount = 0.00;
        for (int i = 0; i < usedSpendingCategories.size(); i++) {
            amount += usedSpendingCategories.get(i).getTotalDonated();
        }
        return amount;
    }

    public String getPassword(){
        return password;
    }

    public void setCurrentMonthTransaction(Transaction currentMonthTransaction) {
        this.currentMonthTransaction = currentMonthTransaction;
    }

    public boolean isSupportingCharity(Charity charity){
        for (int i = 0; i < supportedCharities.size(); i++) {
            if (supportedCharities.get(i).getName().equals(charity.getName())){
                return true;
            }
        }
        return false;
    }

    public boolean isUsingSpendingCategory(SpendingCategory spendingCategory){
        for (int i = 0; i < usedSpendingCategories.size(); i++) {
            if (usedSpendingCategories.get(i).getName().equals(spendingCategory.getName())){
                return true;
            }
        }
        return false;
    }

    public void supportCharity(Charity charity){
        supportedCharities.add(charity);
    }

    public void unsupportCharity(Charity charity){
        for (int i = 0; i < supportedCharities.size(); i++) {
            if (supportedCharities.get(i).getName().equals(charity.getName())){
                supportedCharities.remove(i);
            }
        }
    }

    public void addSpendingCategory(SpendingCategory spendingCategory){
        usedSpendingCategories.add(spendingCategory);
    }

    public void removeSpendingCategory(SpendingCategory spendingCategory){
        for (int i = 0; i < usedSpendingCategories.size(); i++) {
            if (usedSpendingCategories.get(i).getName().equals(spendingCategory.getName())){
                usedSpendingCategories.remove(i);
            }
        }
    }

    public void removeBankAccount(){
        bankAccount = null;
    }

    public boolean hasNotification(){
        return lastMonthTransaction != null;
    }

    public boolean hasBankAccount(){
        return bankAccount != null;
    }

    public ArrayList<SpendingCategory> getCurrentlyUsedSpendingCategories(){
        ArrayList<SpendingCategory> categories = new ArrayList<>();
        for (int i = 0; i < usedSpendingCategories.size(); i++) {
            if (usedSpendingCategories.get(i).isUsed()){
                categories.add(usedSpendingCategories.get(i));
            }
        }
        return categories;
    }
}