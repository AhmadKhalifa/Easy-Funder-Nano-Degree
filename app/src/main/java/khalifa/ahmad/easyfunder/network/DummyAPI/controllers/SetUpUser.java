package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.models.transaction.Transaction;
import khalifa.ahmad.easyfunder.models.user.BankAccount;
import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.models.user.builders.BankAccountBuilder;
import khalifa.ahmad.easyfunder.models.user.builders.UserBuilder;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class SetUpUser extends APIController {

    private String userEmail;

    public SetUpUser(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public Object execute() {
        User user = new UserBuilder()
                .firstName("Ahmad")
                .lastName("Khalifa")
                .email(SignIn.HARD_WRITTEN_USER_EMAIL)
                .phone("01123985925")
                .password(SignIn.HARD_WRITTEN_PASSWORD)
                .build();
        BankAccount bankAccount = new BankAccountBuilder()
                .bankName("Banque Misr")
                .branch("El-Haram")
                .accountNumber("134401251531")
                .swiftCode("ICICINBBXXX")
                .address("184th, El-Haram st, Giza, Egypt")
                .build();
        user.setBankAccount(bankAccount);

        for (int i = 0; i < Global.allCharities.size(); i++) {
            user.supportCharity(Global.allCharities.get(i).get(0));
        }
        SpendingCategory category;
        user.addSpendingCategory(
                new SpendingCategory(SpendingCategory.AUTOMOBILE, 56.00));
        user.addSpendingCategory(
                new SpendingCategory(SpendingCategory.BANK_CHARGE, 160.00));
        user.addSpendingCategory(
                new SpendingCategory(SpendingCategory.CHILDCARE, 140.00));

        category = new SpendingCategory(SpendingCategory.CLOTHING, 400.00, 8.00, 2.0);
        category.setUsed(true);
        user.addSpendingCategory(category);

        user.addSpendingCategory(
                new SpendingCategory(SpendingCategory.EVENTS, 530.00));

        category = new SpendingCategory(SpendingCategory.FOOD, 350.00, 35.00, 10.0);
        category.setUsed(true);
        user.addSpendingCategory(category);


        user.addSpendingCategory(
                new SpendingCategory(SpendingCategory.GIFTS, 420.00));

        category = new SpendingCategory(SpendingCategory.HEALTH_CARE, 200.00, 30.00, 15.0);
        category.setUsed(true);
        user.addSpendingCategory(category);

        category =  new SpendingCategory(SpendingCategory.INSURANCE, 500.00, 100.00, 20.0);
        category.setUsed(true);
        user.addSpendingCategory(category);

        user.addSpendingCategory(
                new SpendingCategory(SpendingCategory.VACATION, 1000.00));


        user.setLastMonthTransaction(new Transaction(
                new Date(2016, 10, 1),
                300.00,
                new ArrayList<SpendingCategory>(
                        Arrays.asList(
                                new SpendingCategory[] {
                                        new SpendingCategory(
                                                SpendingCategory.CLOTHING, 500.00, 50.00, 10.0),
                                        new SpendingCategory(
                                                SpendingCategory.HEALTH_CARE, 300.00, 15.00, 5.0),
                                        new SpendingCategory(
                                                SpendingCategory.INSURANCE, 2000.00, 20.00, 2.0)
                                }
                        )
                )
        ));

        return user;
        }
    }