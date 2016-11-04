package khalifa.ahmad.easyfunder.network.DummyAPI.controllers;

import khalifa.ahmad.easyfunder.network.DummyAPI.APIController;

public class SignIn extends APIController {

    private String userEmail;
    private String userPassword;
    public static String HARD_WRITTEN_USER_EMAIL = "ahmad.khalifa795@gmail.com";
    public static String HARD_WRITTEN_PASSWORD = "12345678";

    public SignIn(String userEmail, String userPassword) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
    }

    @Override
    public Object execute() {
        return (userEmail.equals(HARD_WRITTEN_USER_EMAIL)
                && userPassword.equals(HARD_WRITTEN_PASSWORD));
    }
}