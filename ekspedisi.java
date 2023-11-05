import java.util.Scanner;

public class ekspedisi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        var clearScreen = ("\033[H\033[2J");
        System.out.println(clearScreen);
        
        String pilih;
        String[][] user = new String[1][2];
        user[0][0] = "admin";
        user[0][1] = "admin";
        boolean berhasilLogin = false;

        String kotaAsal, kotaTujuan;
        int biaya, berat, panjang, lebar, tinggi;
        double volume = 0;

        while (true) {
            System.out.println("Login");
            System.out.println("1. Sign in");
            System.out.println("Exit");
            System.out.print("pilih menu : ");
            pilih = input.nextLine();
            System.out.println(clearScreen);

            if (pilih.equals("1")) {
                String username, passwrod;
                System.out.print("Masukan username :");
                username = input.nextLine();
                System.out.print("Masukan password :");
                passwrod = input.nextLine();
                for (int i = 0; i < user.length; i++) {
                    if (username.equals(user[i][0]) && passwrod.equals(user[i][1])) {
                        berhasilLogin = true;
                    }else{
                        System.out.println("Maaf, Username atau Password anda salah");
                    }
                }
                System.out.println(clearScreen);
            }
            while (berhasilLogin) {
                System.out.println("menu");
                System.out.println("1. Pick up");
                System.out.println("2. Drop off");
                System.out.println("3. Harga");
                System.out.println("4. Drop Point Sekitar");
                System.out.println("5. Total Poin");
                System.out.println("6. Tukar Voucher");
                System.out.println("7. Order Saya");
                System.out.println("8. Lacak Paket");
                System.out.println("9. Exit");

                System.out.print("pilih menu : ");
                pilih = input.nextLine();
                System.out.println(clearScreen);

                if (pilih.equals("1")) {

                }else if (pilih.equals("2")) {

                }else if (pilih.equals("3")) {
                    while (berhasilLogin) {
                        
                        System.out.print("Masukan Kota Asal :");
                        kotaAsal = input.nextLine();
                        System.out.print("Masukan Kota Tujuan :");
                        kotaTujuan = input.nextLine();
                        System.out.print("Berat Paket :");
                        berat = input.nextInt();
                        System.out.println("Volume Paket");
                        System.out.print("panjang :");
                        panjang = input.nextInt();
                        System.out.print("lebar :");
                        lebar = input.nextInt();
                        System.out.print("tinggi :");
                        tinggi = input.nextInt();
                        volume = (int) panjang*lebar*tinggi/6000;

                        if (kotaAsal.equalsIgnoreCase("Malang") && kotaTujuan.equalsIgnoreCase("Surabaya")) {
                            if (berat > volume) {
                                biaya = 10000 * berat;
                            }else
                                biaya = 10000 * (int) volume;
                            System.out.println(biaya);
                            pilih = input.nextLine();
                        }
                        System.out.print("Kembali ke menu? (y/n) :");
                        pilih = input.nextLine();
                        if (pilih.equals("y")) {
                            break;
                        }
                    }  
                    System.out.println(clearScreen);

                }else if (pilih.equals("4")) {
                    
                
                }else if (pilih.equals("5")) {
                    
                
                }else if (pilih.equals("6")) {
                    
                
                }else if (pilih.equals("7")) {
                    
                
                }else if (pilih.equals("8")) {
                    
                
                }else if (pilih.equals("9")) {
                    System.out.println("keluar");
                    System.exit(0);
                }
            }
        }
    }
}