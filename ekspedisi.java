import java.util.Scanner;

public class ekspedisi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        var clearScreen = ("\033[H\033[2J");
        System.out.println(clearScreen);
        
        String pilih, asal, tujuan, kota, layanan;
        boolean berhasilLogin = false;
        int biaya, berat, panjang, lebar, tinggi, jenLay, beratVolume, counter;
        String[][] user = new String[1][2];
        user[0][0] = "admin";
        user[0][1] = "admin";
        String[][] identitas = new String[8][2];
        String[] kotaDikirim = {"Malang", "Surabaya", "Jakarta", "Madiun", "Jember"};
        String[] kotaDiterima = {"Malang", "Surabaya", "Jakarta", "Madiun", "Jember"};
        String[] barangString = new String[2];
        int[] barangInt = new int[5];
        int metodePembayaran;
        boolean pembayaranValid = false;
        
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
                    System.out.println(clearScreen);
                    System.out.println("Silahkan masukkan informasi pengiriman");
                    
                } else if (pilih.equals("2")) {
                    System.out.println(clearScreen);
                    System.out.println("Silahkan masukkan informasi pengiriman");
                    
                } else if (pilih.equals("3")) {
                        System.out.println("Asal(Provinsi):");
                        asal = input.nextLine();
                        System.out.println("Tujuan(Provinsi)");
                        tujuan = input.nextLine();

                         System.out.print("Berat(kg): ");
                        barangInt[1] = input.nextInt();
                        System.out.println("Hitung berat volume");
                        System.out.print("Panjang(cm): ");
                        barangInt[2] = input.nextInt();
                        System.out.print("Lebar(cm): ");
                        barangInt[3] = input.nextInt();
                        System.out.print("Tinggi(cm): ");
                        barangInt[4] = input.nextInt();

                            while (true) {
                            System.out.print("Pilih jenis layanan pengiriman (Standard/Reguler/Express): ");
                            layanan = input.nextLine();
                            if (layanan.equalsIgnoreCase("Standard")) {
                                jenLay = 400;
                            } else if (layanan.equalsIgnoreCase("Reguler")) {
                                jenLay = 500;
                            } else if (layanan.equalsIgnoreCase("Express")) {
                                jenLay = 600;
                            } else {
                                System.out.println("Jenis layanan tidak valid!");
                                continue; 
                            }
                        }

                        beratVolume = (barangInt[2] * barangInt[3] * barangInt[4]) / 6000;

                        if (beratVolume > barangInt[1]) {
                        biaya = (10000 * beratVolume) + (jenLay * 10);
                        if (asal.equalsIgnoreCase(tujuan)) {
                            biaya += 5000;
                            }
                        } else {
                        biaya = (10000 * barangInt[1]) + (jenLay * 10);
                        if (asal.equalsIgnoreCase(tujuan)) {
                            biaya += 5000;
                            }
                        }
                        System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (biaya));
                 
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
