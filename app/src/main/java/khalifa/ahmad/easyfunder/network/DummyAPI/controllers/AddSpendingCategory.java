package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class AddSpendingCategory extends APIController {

    private SpendingCategory spendingCategory;

    public AddSpendingCategory(SpendingCategory spendingCategory) {
        this.spendingCategory = spendingCategory;
    }

    @Override
    public Object execute() {
        Global.user.addSpendingCategory(spendingCategory);
        return true;
    }
}