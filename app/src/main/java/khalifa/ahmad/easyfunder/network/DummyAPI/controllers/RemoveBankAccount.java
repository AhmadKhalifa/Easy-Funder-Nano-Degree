package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class RemoveBankAccount extends APIController {

    public RemoveBankAccount() {}

    @Override
    public Object execute() {
        Global.user.removeBankAccount();
        return true;
    }
}