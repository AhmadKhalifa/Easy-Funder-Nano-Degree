package khalifa.ahmad.easyfunder.models.user.builders;

import khalifa.ahmad.easyfunder.models.user.BankAccount;

public class BankAccountBuilder {
    private String bankName;
    private String branch;
    private String accountNumber;
    private String swiftCode;
    private String address;

    public BankAccountBuilder bankName(String bankName){
        this.bankName = bankName;
        return this;
    }

    public BankAccountBuilder branch(String branch){
        this.branch = branch;
        return this;
    }

    public BankAccountBuilder accountNumber(String accountNumber){
        this.accountNumber = accountNumber;
        return this;
    }

    public BankAccountBuilder swiftCode(String swiftCode){
        this.swiftCode = swiftCode;
        return this;
    }

    public BankAccountBuilder address(String address){
        this.address = address;
        return this;
    }

    public BankAccount build(){
        return new BankAccount(
                this.bankName,
                this.branch,
                this.accountNumber,
                this.swiftCode,
                this.address
        );
    }
}
