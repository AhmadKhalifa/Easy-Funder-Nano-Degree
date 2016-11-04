package khalifa.ahmad.easyfunder.models.user;

import java.io.Serializable;

public class BankAccount implements Serializable {
    private String bankName;
    private String branch;
    private String accountNumber;
    private String swiftCode;
    private String address;

    public BankAccount(
            String bankName,
            String branch,
            String accountNumber,
            String swiftCode,
            String address){
        this.bankName = bankName;
        this.branch = branch;
        this.accountNumber = accountNumber;
        this.swiftCode = swiftCode;
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
