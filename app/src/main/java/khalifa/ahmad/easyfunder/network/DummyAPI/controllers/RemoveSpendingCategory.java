package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class RemoveSpendingCategory extends APIController {

    private SpendingCategory spendingCategory;

    public RemoveSpendingCategory(SpendingCategory spendingCategory) {
        this.spendingCategory = spendingCategory;
    }

    @Override
    public Object execute() {
        Global.user.removeSpendingCategory(spendingCategory);
        return true;
    }
}