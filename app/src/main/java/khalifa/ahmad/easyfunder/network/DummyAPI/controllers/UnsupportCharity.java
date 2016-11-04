package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class UnsupportCharity extends APIController {

    private Charity charity;

    public UnsupportCharity(Charity charity) {
        this.charity = charity;
    }

    @Override
    public Object execute() {
        Global.user.unsupportCharity(charity);
        return true;
    }
}