package khalifa.ahmad.easyfunder.models.user.builders;

import khalifa.ahmad.easyfunder.models.user.BankAccount;
import khalifa.ahmad.easyfunder.models.user.User;

public class UserBuilder {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String password;
    private BankAccount bankAccount;

    public UserBuilder firstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public UserBuilder lastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public UserBuilder email(String email){
        this.email = email;
        return this;
    }

    public UserBuilder phone(String phone){
        this.phone = phone;
        return this;
    }

    public UserBuilder password(String password){
        this.password = password;
        return this;
    }

    public User build(){
        return new User(
                this.firstName,
                this.lastName,
                this.email,
                this.phone,
                this.password
        );
    }
}
