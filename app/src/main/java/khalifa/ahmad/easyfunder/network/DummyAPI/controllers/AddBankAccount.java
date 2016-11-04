package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import khalifa.ahmad.easyfunder.models.user.BankAccount;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class AddBankAccount extends APIController {

    private BankAccount bankAccount;

    public AddBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    @Override
    public Object execute() {
        Global.user.setBankAccount(bankAccount);
        return true;
    }
}
