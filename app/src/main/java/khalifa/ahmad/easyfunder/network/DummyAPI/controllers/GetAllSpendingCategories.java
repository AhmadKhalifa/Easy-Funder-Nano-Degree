package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import khalifa.ahmad.easyfunder.models.transaction.SpendingCategory;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;

public class GetAllSpendingCategories extends APIController{

    public GetAllSpendingCategories(){}

    @Override
    public Object execute() {
        return new ArrayList<SpendingCategory>(
                Arrays.asList(
                        new SpendingCategory[]{
                                new SpendingCategory(SpendingCategory.AUTOMOBILE),
                                new SpendingCategory(SpendingCategory.BANK_CHARGE),
                                new SpendingCategory(SpendingCategory.CHILDCARE),
                                new SpendingCategory(SpendingCategory.CLOTHING),
                                new SpendingCategory(SpendingCategory.EVENTS),
                                new SpendingCategory(SpendingCategory.FOOD),
                                new SpendingCategory(SpendingCategory.GIFTS),
                                new SpendingCategory(SpendingCategory.HEALTH_CARE),
                                new SpendingCategory(SpendingCategory.INSURANCE),
                                new SpendingCategory(SpendingCategory.VACATION)
                        }
                )
        );
    }
}