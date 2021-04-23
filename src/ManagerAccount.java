import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerAccount {
    List<Account> accountList = new ArrayList<>();

    public ManagerAccount(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void addAccount(){
        Scanner s1 = new Scanner(System.in);
        System.out.print("Mời nhập số chứng minh nhân dân: ");
        int id = s1.nextInt();
        for (Account a: accountList) {
            if (a.getID() == id){
                System.out.println("Số chứng minh đã được đăng kí rồi");
                return;
            }
        }
        System.out.println("Mời nhập số tài khoản: ");
        int accountNumber = s1.nextInt();
        for (Account a: accountList) {
            if (a.getAccountNumber() == accountNumber){
                System.out.println("Số tài khoản đã được đăng kí rồi");
                return;
            }
        }
        System.out.println("Mời nhập tên: ");
        Scanner s2 = new Scanner(System.in);
        String name = s2.nextLine();
        double amountInAccount = 50000;
        Account account = new Account(id,accountNumber, name, amountInAccount);
        accountList.add(account);
    }

    public void deleteAccount(){
        Scanner s1 = new Scanner(System.in);
        System.out.print("Nhập số chứng minh cho tài khoản cần xóa:");
        for (int i = 0; i < accountList.size(); i++) {
            int id = s1.nextInt();
            if (accountList.get(i).getID() == id) accountList.remove(accountList.get(i));
        }
    }

    public void inputMoney(){
        Scanner s1 = new Scanner(System.in);
        System.out.print("Nhập số tài khoản cần nạp: ");
        int accountNumber = s1.nextInt();
        System.out.print("Nhập số tiền bạn muốn nạp:");
        double input = s1.nextDouble();
        for (Account a: accountList) {
            if ( a.getAccountNumber() == accountNumber) {
                if (input > 0){
                a.setAmountInAccount(input + a.getAmountInAccount());
                NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
                String str1 = currencyEN.format(input);
                System.out.println("bạn vừa nap: " + str1 + "Đ vào số tài khoản: " + accountNumber);
            }
                else System.out.println("Số tiền nạp vào không hợp lệ.");
            }

        }
    }

    public void withdrawal(){
        Scanner scanner = new Scanner(System.in);
        double fees = 5000;
        System.out.println("Nhập số tài khoản cần rút tiền: ");
        int accountNumber = scanner.nextInt();
        int count = 0;
        for (Account a: accountList) {
            if (a.getAccountNumber() != accountNumber) count++;
            if (count == accountList.size()){
                System.out.println("Thông tin số tài khoản không đúng.");
                return;
            }
        }
        System.out.print("Nhập số tiền cần rút:");
        double Withdrawal = scanner.nextDouble();
        for (Account account: accountList) {
            if (account.getAccountNumber() == accountNumber) {
                if ((account.getAmountInAccount()) > (Withdrawal + fees)) {
                    account.setAmountInAccount(account.getAmountInAccount() - (Withdrawal + fees));
                    NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
                    String str = currencyEN.format(Withdrawal);
                    System.out.println("Bạn đã rút" + str + "Đ từ tài khoản" + accountNumber + " Phí giao dịch là 5000Đ ");
                }
                else System.out.println("số tiền muốn rút không hợp lệ, Bạn chỉ còn: " + account.getAmountInAccount() + "Đ trong tài khoản.");
            }
        }
    }

    public void interestRate(){
        double rate = 0.05;
        double interest = 0;
        for (Account account: accountList) {
            account.setAmountInAccount(account.getAmountInAccount() + account.getAmountInAccount()*rate);
            interest = account.getAmountInAccount()*rate;
            NumberFormat currencyEN = NumberFormat.getCurrencyInstance();
            String str = currencyEN.format(interest);
            System.out.println("Bạn nhận được: " + str + " từ đáo hạn 1 tháng");
            System.out.println("số tiền hiện tại của bạn là: " + str);

        }
    }

    public void showAccount(){
        for (Account account: accountList) {
            System.out.println(account);
        }
    }

    public void transfers(){
        double rate = 5000;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số tài khoản chuyển tiền: ");
        int account1 = scanner.nextInt();
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountNumber() != account1) count2++;
        }
        if (count2 == accountList.size()){
            System.out.println("Sai thông tin người gửi.");
            return;
        }
        System.out.print("nhập số tài khoản nhận: ");
        int account2 = scanner.nextInt();
        for (int i = 0; i < accountList.size(); i++) {
            if (accountList.get(i).getAccountNumber() != account2) count1++;
        }
        if (count1 == accountList.size()){
            System.out.println("Sai thông tin người nhận.");
            return;
        }
        System.out.println("Nhập số tiền cần chuyển: ");
        double amountOfMoney = scanner.nextDouble();
        for (Account accountA: accountList) {
            if (accountA.getAccountNumber() == account1) {
                if ((amountOfMoney + rate) <= accountA.getAmountInAccount()) {
                    for (Account accountB: accountList) {
                        if (accountB.getAccountNumber() == account2) {
                            accountA.setAmountInAccount(accountA.getAmountInAccount() - amountOfMoney - rate);
                            accountB.setAmountInAccount(accountB.getAmountInAccount() + amountOfMoney);
                            System.out.println("Bạn vừa chuyển: " + amountOfMoney + " từ số tài khoản: " + account1 + " tới số tài khoản: " + account2);
                            System.out.println("Phí dịch vụ: " + rate + "Đ");
                        }
                    }
                } else {
                    System.out.println("số tiền chuyển vượt qua số tiền trong tài khoản.");
                }
            }
        }
    }
    public void searchByAccountNumber(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời bạn nhập số tài khoản để tìm kiếm");
        int accountNumber = scanner.nextInt();
        for (Account account: accountList) {
            if (account.getAccountNumber() == accountNumber) System.out.println(account);
        }
    }
}
