import java.util.Scanner;

public class ekspedisi {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in); // Scanner for user input
        String username = "pengguna";
        String password = "katasandi";

        Scanner scan = new Scanner(System.in);
        boolean berhasilLogin = false;

        while (!berhasilLogin) {
            System.out.print("Masukkan nama pengguna: ");
            String inputUsername = scan.nextLine();
            System.out.print("Masukkan kata sandi: ");
            String inputPassword = scan.nextLine();

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("Selamat datang, " + username + "!");
                berhasilLogin = true;
            } else {
                System.out.println("Login gagal. Nama pengguna atau kata sandi salah.");
            }
        }

        clearScreen();

        double diskon = 0.0, berat, jarak;
        int biaya, jenLay = 0;
        String jenis;

        System.out.print("Masukkan jenis layanan yang dipilih (Express, Regular, Standard): ");
        jenis = scan.nextLine();
        System.out.print("Masukkan berat paket(kg): ");
        berat = scan.nextDouble();
        System.out.print("Masukkan jarak pengiriman paket (km): ");
        jarak = scan.nextDouble();

        if (jenis.equalsIgnoreCase("express")) {
            jenLay = 500;
            if ((jarak > 10) || (berat > 10)) {
                diskon = 0.2;
                System.out.println("Anda telah mendapat diskon 20%!");
            } else {
                diskon = 0.0;
                System.out.println("Anda tidak mendapatkan diskon");
            }
        } else if (jenis.equalsIgnoreCase("regular")) {
            jenLay = 400;
            if ((jarak > 10) || (berat > 10)) {
                diskon = 0.1;
                System.out.println("Anda telah mendapat diskon 10%!");
            } else {
                diskon = 0.0;
                System.out.println("Anda tidak mendapatkan diskon");
            }
        } else if (jenis.equalsIgnoreCase("standard")) {
            jenLay = 300;
            diskon = 0.0;
            System.out.println("Anda tidak mendapat diskon");
        } else {
            System.out.println("Masukan jenis layanan anda salah. Harap pilih Express, Regular, atau Standard.");
        }

        biaya = (int) ((berat * jarak * jenLay) - (berat * jarak * jenLay * diskon));
        System.out.println("Biaya pengiriman paket anda adalah : " + biaya);

        userInput.close();
        scan.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
