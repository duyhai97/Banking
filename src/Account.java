import java.text.NumberFormat;

public class Account {
    private int ID;
    private int accountNumber;
    private String accountName;
    private double amountInAccount;


    public Account(int ID, int accountNumber, String accountName, double amountInAccount) {
        this.ID = ID;
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.amountInAccount = amountInAccount;
    }

    @Override
    public String toString() {
        return "Thông tin tài khoản: " +
                "Số chứng minh thư: " + ID +
                ", Số tài khoản:  " + accountNumber +
                ", Tên tài khoản: '" + accountName + '\'' +
                ", Số dư tài khoản: " + amountInAccount ;
    }
//public String toString() {
//    // TODO Auto-generated method stub
//    NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
//    String str1 = currencyEN.format(amountInAccount);
//
//    return ID + "-" + accountNumber + "-" + accountName + "-" + str1;
//}

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getAmountInAccount() {
        return amountInAccount;
    }

    public void setAmountInAccount(double amountInAccount) {
        this.amountInAccount = amountInAccount;
    }
}
