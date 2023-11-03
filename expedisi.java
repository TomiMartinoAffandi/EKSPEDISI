import java.util.Scanner;

public class EkspedisiLogin {
    public static void main(String[] args) {
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

        var clearScreen = ("\033[H\033[2J");
        System.out.println(clearScreen);

        // TODO: transaksi

        String nPengirim, aPengirim, nPenerima, aPenerima, kecamatan, kota, provinsi, nHandphonePengirim, nHandphonePenerima, kPOs, tKirim;

        Scanner transaksi = new Scanner(System.in);

        while (true) {
            // input data pengirim
            System.out.print("Nama Pengirim : ");
            nPengirim = transaksi.nextLine();
            System.out.print("Alamat Pengirim : ");
            aPengirim = transaksi.nextLine();
            System.out.print("No. Handphone : ");
            nHandphonePengirim = transaksi.nextLine();

            System.out.println(clearScreen);

            // input data penerima
            System.out.print("Nama Penerima : ");
            nPenerima = transaksi.nextLine();
            System.out.print("Alamat Penerima : ");
            aPenerima = transaksi.nextLine();
            System.out.print("Kecamatan : ");
            kecamatan = transaksi.nextLine();
            System.out.print("Kota/Kabupaten : ");
            kota = transaksi.nextLine();
            System.out.print("Provinsi : ");
            provinsi = transaksi.nextLine();
            System.out.print("Kode Pos : ");
            kPOs = transaksi.nextLine();
            System.out.print("No. Handphone : ");
            nHandphonePenerima = transaksi.nextLine();
            System.out.print("Tanggal Kirim : ");
            tKirim = transaksi.nextLine();

            System.out.print(clearScreen);

            System.out.print("apakah anda ingin memasukan data lain (y/n) : ");
            String jawaban = transaksi.next();
            if (jawaban.equals("n")) {
                break;
            }
            System.out.println(clearScreen);
            transaksi.nextLine();
        }

        // Calculate delivery cost and perform further actions here.
        // You can add more functionality as needed for the delivery service.
    }
}