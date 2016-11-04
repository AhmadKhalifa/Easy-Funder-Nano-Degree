package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import khalifa.ahmad.easyfunder.models.user.User;
import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;
import khalifa.ahmad.easyfunder.utlities.mystatic.Global;

public class SignUp extends APIController {

    private User user;

    public SignUp(User user) {
        this.user = user;
    }

    @Override
    public Object execute() {
        Global.user = user;
        return true;
    }
}