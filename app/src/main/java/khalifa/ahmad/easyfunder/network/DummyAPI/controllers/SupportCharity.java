package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import khalifa.ahmad.easyfunder.models.charity.Charity;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class SupportCharity extends APIController {

    private Charity charity;

    public SupportCharity(Charity charity) {
        this.charity = charity;
    }

    @Override
    public Object execute() {
        Global.user.supportCharity(charity);
        return true;
    }
}