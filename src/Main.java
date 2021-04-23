import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Account> accountList = new ArrayList<>();
        Account account1 = new Account(1, 10, "Đỗ Duy Hải", 50000);
        Account account2 = new Account(2,20, "Đỗ Duy Nam", 50000);
        accountList.add(account1);
        accountList.add(account2);
        ManagerAccount hai = new ManagerAccount(accountList);

        while (true){
            System.out.println("Mời bạn nhập lựa chọn: ");
            System.out.println("1. Thêm tài khoản mới.");
            System.out.println("2. Xóa tài khoản khỏi danh sách.");
            System.out.println("3. Kiểm tra thông tin tài khoản.");
            System.out.println("4. Nạp tiền.");
            System.out.println("5. Rút tiền.");
            System.out.println("6. Chuyển tiền.");
            System.out.println("7. kết thúc.");
            Scanner scanner = new Scanner(System.in);
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    hai.addAccount();
                    break;
                case 2:
                    hai.deleteAccount();
                    break;
                case 3:
                    hai.showAccount();
                    break;
                case 4:
                    hai.inputMoney();
                    break;
                case 5:
                    hai.withdrawal();
                    break;
                case 6:
                    hai.transfers();
                    break;
                case 7:
                    return;
                default:
                    System.out.println("không đúng.");
            }
        }
    }
}
