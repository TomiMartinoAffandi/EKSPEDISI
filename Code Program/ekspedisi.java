import java.util.Scanner;

public class ekspedisi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        var clearScreen = ("\033[H\033[2J");
        System.out.print(clearScreen);
        
        String pilih;
        String[][] user = new String[1][2];
        user[0][0] = "admin";
        user[0][1] = "admin";
        boolean berhasilLogin = false;

        while (true) {
            System.out.println("Login");
            System.out.println("1. Sign in");
            System.out.println("Exit");
            System.out.print("pilih menu : ");
            pilih = input.nextLine();
            System.out.print(clearScreen);

            if (pilih.equals("1")) {
                String username, passwrod;
                System.out.print("Masukan username :");
                username = input.nextLine();
                System.out.print("Masukan password :");
                passwrod = input.nextLine();
                for (int i = 0; i < user.length; i++) {
                    if (username.equals(user[i][0]) && passwrod.equals(user[i][1])) {
                        System.out.print("berhasil login");
                        berhasilLogin = true;
                    }
                }
                System.out.println(clearScreen);

            } else
                break;

            while (berhasilLogin) {
                System.out.println("pilih menu :");
                System.out.println("1. Pick up");
                System.out.println("2. Drop off");
                System.out.println("3. Harga");
                System.out.println("4. Drop Point Sekitar");
                System.out.println("5. Tukar Poin");
                System.out.println("6. Tukar Voucher");
                System.out.println("7. Order Saya");
                System.out.println("8.");
                System.out.println("9.");
                System.out.println("10. Exit");

                System.out.print("pilih menu : ");
                pilih = input.nextLine();
                System.out.print(clearScreen);

                if (pilih.equals("1")) {
                    
                }else if (pilih.equals("2")) {
                    
                }else if (pilih.equals("3")) {
                    
                }else if (pilih.equals("4")) {
                    
                }else if (pilih.equals("5")) {
                    
                }else if (pilih.equals("6")) {
                    
                }else if (pilih.equals("7")) {
                    
                }else if (pilih.equals("8")) {
                    
                }else if (pilih.equals("9")) {
                    
                }else if (pilih.equals("10")) {
                    System.out.print("keluar");
                    System.exit(0);
                }
            }
        }
    }
}