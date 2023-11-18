import java.util.Scanner;

public class ekspedisi {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String clearScreen = ("\033[H\033[2J");
        System.out.println(clearScreen);
        
        String pilih, asal, tujuan, kota, layanan,username, passwrod;
        boolean berhasilLogin = false; 
        int biaya, jenLay, beratVolume, counter, disc1 = 0, disc2 = 0, Poin = 0;
        String[][] user = new String[1][2];
        user[0][0] = "admin";
        user[0][1] = "admin";
        String[][] identitas = new String[8][2];
        String[] identitasLabels = {
            "Nama", "Alamat", "Kecamatan", "Kelurahan", "Kota", "Provinsi", "Kode pos", "Nomor Telepon"
        };
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
                    while(true) {
                    System.out.print("Silahkan masukkan informasi pengiriman");
                        for (int j = 0; j < 2; j++) {
                            System.out.println("Masukkan informasi " + ((j == 0) ? "pengirim" : "penerima") + " (Informasi tidak boleh kosong!):");
                            
                            for (int i = 0; i < 8; i++) {
                                if (i == 4) {
                                    boolean valid = false;
                                    do{
                                        System.out.print(identitasLabels[i] + " " + ((j == 0) ? "pengirim" : "penerima") + " (Malang/Surabaya/Jakarta/Madiun/Jember): ");
                                        kota = input.nextLine();
                                        for (String kotaD : kotaDiterima) {
                                            if (kota.equalsIgnoreCase(kotaD)) {
                                                identitas[i][j] = kota;
                                                valid = true;
                                                break;
                                            } 
                                        }
                                        if (!valid) {
                                            System.out.println("Kota yang dimasukkan tidak valid. Silakan masukkan salah satu dari lima kota yang diizinkan.");
                                        }
                                    } while (!valid);
                                } else {
                                    System.out.print(identitasLabels[i] + " " + ((j == 0) ? "pengirim" : "penerima") + ": ");
                                    identitas[i][j] = input.nextLine();
                                }
                            }
                        }
                        
                        System.out.print("Apakah anda ingin merubah data informasi barang?(y/n): ");
                        String jawaban = input.next();
                        if (jawaban.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    System.out.println("=============================");
                    System.out.println("=============================");
                    
                    //untuk informasi barang yang dikirim
                    System.out.println ("Masukkan informasi barang (Informasi tidak boleh kosong!)");
                    while (true) {
                        //input informasi barang
                        System.out.print("Nama barang: ");
                        barangString[0] = input.nextLine();
                        input.nextLine();
                        System.out.print("Jenis barang: ");
                        barangString[1] = input.nextLine();
                        System.out.print("Jumlah(pcs): ");
                        barangInt[0] = input.nextInt();
                        System.out.print("Berat(kg): ");
                        barangInt[1] = input.nextInt();
                        System.out.println("Hitung berat volume");
                        System.out.print("Panjang(cm): ");
                        barangInt[2] = input.nextInt();
                        System.out.print("Lebar(cm): ");
                        barangInt[3] = input.nextInt();
                        System.out.print("Tinggi(cm): ");
                        barangInt[4] = input.nextInt();
                        
                        System.out.print("Apakah anda ingin merubah data informasi barang?(y/n): ");
                        String jawaban = input.next();
                        if (jawaban.equalsIgnoreCase("n")) {
                            break;
                            }
                        }
                    
                        System.out.println("=============================");
                        System.out.println("=============================");
                    // Pemilihan jenis layanan
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
                            continue; // Mengulangi loop jika jenis layanan tidak valid
                        }
                        break;
                    }
                    
                        // Perhitungan biaya (berdasarkan jenLay + berat)
                    beratVolume = (barangInt[2] * barangInt[3] * barangInt[4]) / 6000;
                    
                    if (beratVolume > barangInt[1]) {
                        biaya = (10000 * beratVolume) + (jenLay * 10);
                        if (!identitas[5][0].equalsIgnoreCase(identitas[5][1])) {
                            // Jika beda provinsi
                            biaya += 5000;
                            }
                        } else {
                            biaya = (10000 * barangInt[1]) + (jenLay * 10);
                            if (!identitas[5][0].equalsIgnoreCase(identitas[5][1])) {
                            // Jika beda provinsi
                            biaya += 5000;
                            }
                        }
                    System.out.println("apakah anda ingin menggunakan voucher(y/n)?");
                    if (pilih.equalsIgnoreCase("y")) {
                    while (true) {
                            System.out.println("Pilih Voucher :");
                            System.out.println("1. Diskon Ongkir 40%");
                            System.out.println("2. Diskon Ongkir 30%");
                            
                            if (pilih.equals("1")) {
                                if (disc1 == 1) {
                                    biaya*=0.4;
                                    disc1 -=1;
                                }else
                                    System.out.println("anda tidak memenuhi syarat");
                            }else if (pilih.equals("2")) {
                                if (disc2 == 1) {
                                    biaya*=0.3;
                                    disc2-=1;
                                }else
                                    System.out.println("anda tidak memenuhi syarat");
                            }
                        } 
                    }
                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (biaya+5000));
                        //pembayaran
                    do {
                        System.out.print("Ingin melanjutkan pembayaran? (y/n): ");
                        String jawaban = input.next();
                        if (jawaban.equalsIgnoreCase("y")) {
                            break;
                        }
                    } while (true);
                    
                    System.out.println("=============================");
                    System.out.println("=============================");
                        
                    do {
                        System.out.println("Pilihan Pembayaran:");
                        System.out.println("1. COD (Cash On Delivery)");
                        System.out.println("2. Transfer Bank");
                        System.out.print("Pilih metode pembayaran (1/2): ");
                        metodePembayaran = input.nextInt();
                            
                        if (metodePembayaran == 1) {
                            // Pembayaran menggunakan COD
                            System.out.println("Anda memilih pembayaran COD. Biaya pengiriman akan ditagihkan ke penerima.");
                            pembayaranValid = true;
                            } else if (metodePembayaran == 2) {
                            // Pembayaran menggunakan Transfer Bank
                            input.nextLine();
                            System.out.print("Masukkan jenis Bank(BRI/BNI/others): ");
                            String bank = input.nextLine();
                            System.out.print("Masukkan nomor kartu bank: ");
                            int nomorKartu = input.nextInt();
                            System.out.print("Masukkan masa aktif kartu (MM/YY): ");
                            String masaAktifKartu = input.nextLine();
                            System.out.print("Masukkan CVV: ");
                            int cvv = input.nextInt();
                            pembayaranValid = true;
                            System.out.print("Pembayaran sukses!");
                            } else {
                            System.out.println("Metode pembayaran tidak valid!");
                            pembayaranValid = false;
                            }
                        } while (!pembayaranValid);

                        //Informasi tanggal
                    System.out.println("=============================");
                    System.out.println("=============================");
                    System.out.println("Masukkan tanggal pick-up: ");
                    System.out.print("dd: ");
                    int day = input.nextInt();
                    System.out.print("mm: ");
                    int month = input.nextInt();
                    System.out.print("yy: ");
                    int year = input.nextInt();
                        
                        //update no resi
                    System.out.println("Silahkan simpan nomor resi anda!");
                    String noResi = "EKS001"+((year+month+20)/4)+(day+12)+(barangInt[1]+beratVolume);
                    System.out.println("Nomor resi anda adalah: "+noResi);
                        //info pick up
                    System.out.println("Silahkan menunggu kurir untuk mengambil paket anda sampai "+(day+1)+"/"+month+"/"+year);
                    Poin += 10;
                    
                } else if (pilih.equals("2")) {
                    System.out.println(clearScreen);
                    System.out.println("Silahkan masukkan informasi pengiriman");
                    //untuk informasi identitas pengirim dan penerima
                    while(true) {
                        for (int j = 0; j < 2; j++) {
                            System.out.println("Masukkan informasi " + ((j == 0) ? "pengirim" : "penerima") + " (Informasi tidak boleh kosong!):");
                            
                            for (int i = 0; i < 8; i++) {
                                if (i == 4) {
                                    boolean valid = false;
                                    do {
                                        System.out.print(identitasLabels[i] + " " + ((j == 0) ? "pengirim" : "penerima") + " (Malang/Surabaya/Jakarta/Madiun/Jember): ");
                                        kota = input.nextLine();
                                        for (String kotaD : kotaDiterima) {
                                            if (kota.equalsIgnoreCase(kotaD)) {
                                                identitas[i][j] = kota;
                                                valid = true;
                                                break;
                                            } 
                                        }
                                        if (!valid) {
                                            System.out.println("Kota yang dimasukkan tidak valid. Silakan masukkan salah satu dari lima kota yang diizinkan.");
                                        }
                                    } while (!valid);
                                } else {
                                    System.out.print(identitasLabels[i] + " " + ((j == 0) ? "pengirim" : "penerima") + ": ");
                                    identitas[i][j] = input.nextLine();
                                }
                            }
                        }
                        
                        System.out.print("Apakah anda ingin merubah data informasi barang?(y/n): ");
                        String jawaban = input.next();
                        if (jawaban.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    System.out.println("=============================");
                    System.out.println("=============================");
                    
                    //untuk informasi barang yang dikirim
                    System.out.println ("Masukkan informasi barang (Informasi tidak boleh kosong!)");
                    while (true) {
                        //input informasi barang
                        System.out.print("Nama barang: ");
                        barangString[0] = input.nextLine();
                        input.nextLine();
                        System.out.print("Jenis barang: ");
                        barangString[1] = input.nextLine();
                        System.out.print("Jumlah(pcs): ");
                        barangInt[0] = input.nextInt();
                        System.out.print("Berat(kg): ");
                        barangInt[1] = input.nextInt();
                        System.out.println("Hitung berat volume");
                        System.out.print("Panjang(cm): ");
                        barangInt[2] = input.nextInt();
                        System.out.print("Lebar(cm): ");
                        barangInt[3] = input.nextInt();
                        System.out.print("Tinggi(cm): ");
                        barangInt[4] = input.nextInt();
                            
                        System.out.print("Apakah anda ingin merubah data informasi barang?(y/n): ");
                        String jawaban = input.next();
                        if (jawaban.equalsIgnoreCase("n")) {
                            break;
                        }
                    }
                    
                    System.out.println("=============================");
                    System.out.println("=============================");
                    // Pemilihan jenis layanan
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
                            continue; // Mengulangi loop jika jenis layanan tidak valid
                        }
                        break;
                    }
                        
                            // Perhitungan biaya (berdasarkan jenLay + berat)
                    beratVolume = (barangInt[2] * barangInt[3] * barangInt[4]) / 6000;
                        
                    if (beratVolume > barangInt[1]) {
                        biaya = (10000 * beratVolume) + (jenLay * 10);
                        if (!identitas[5][0].equalsIgnoreCase(identitas[5][1])) {
                            // Jika beda provinsi
                            biaya += 5000;
                        }
                    } else {
                        biaya = (10000 * barangInt[1]) + (jenLay * 10);
                        if (!identitas[5][0].equalsIgnoreCase(identitas[5][1])) {
                            // Jika beda provinsi
                            biaya += 5000;
                        }
                    }
                    System.out.println("apakah anda ingin menggunakan voucher(y/n)?");
                    if (pilih.equalsIgnoreCase("y")) {
                    while (true) {
                            System.out.println("Pilih Voucher :");
                            System.out.println("1. Diskon Ongkir 40%");
                            System.out.println("2. Diskon Ongkir 30%");
                            
                            if (pilih.equals("1")) {
                                if (disc1 == 1) {
                                    biaya*=0.4;
                                    disc1 -=1;
                                }else
                                    System.out.println("anda tidak memenuhi syarat");
                            }else if (pilih.equals("2")) {
                                if (disc2 == 1) {
                                    biaya*=0.3;
                                    disc2-=1;
                                }else
                                    System.out.println("anda tidak memenuhi syarat");
                            }
                        } 
                    }
                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (biaya));
                    //pembayaran
                    
                    do {
                        System.out.print("Ingin melanjutkan pembayaran? (y/n): ");
                        String jawaban = input.next();
                        if (jawaban.equalsIgnoreCase("y")) {
                            break;
                        }
                    } while (true);
                    
                    System.out.println("=============================");
                    System.out.println("=============================");
                    
                    do {
                        System.out.println("Pilihan Pembayaran:");
                        System.out.println("1. COD (Cash On Delivery)");
                        System.out.println("2. Transfer Bank");
                        System.out.print("Pilih metode pembayaran (1/2): ");
                        metodePembayaran = input.nextInt();
                        
                        if (metodePembayaran == 1) {
                            // Pembayaran menggunakan COD
                            System.out.println("Anda memilih pembayaran COD. Biaya pengiriman akan ditagihkan ke penerima.");
                            pembayaranValid = true;
                        } else if (metodePembayaran == 2) {
                            // Pembayaran menggunakan Transfer Bank
                            input.nextLine();
                            System.out.print("Masukkan jenis Bank(BRI/BNI/others): ");
                            String bank = input.nextLine();
                            System.out.print("Masukkan nomor kartu bank: ");
                            int nomorKartu = input.nextInt();
                            System.out.print("Masukkan masa aktif kartu (MM/YY): ");
                            String masaAktifKartu = input.nextLine();
                            System.out.print("Masukkan CVV: ");
                            int cvv = input.nextInt();
                            pembayaranValid = true;
                            System.out.print("Pembayaran sukses!");
                        } else {
                            System.out.println("Metode pembayaran tidak valid!");
                            pembayaranValid = false;
                        }
                    
                    } while (!pembayaranValid);
                
                        //Informasi tanggal
                        System.out.println("=============================");
                        System.out.println("=============================");
                        System.out.println("Masukkan tanggal drop-off: ");
                        System.out.print("dd: ");
                        int day = input.nextInt();
                        System.out.print("mm: ");
                        int month = input.nextInt();
                        System.out.print("yy: ");
                        int year = input.nextInt();
                        
                        //update no resi
                        System.out.println("Silahkan simpan nomor resi anda!");
                        String noResi = "EKS021"+((year+month+20)/4)+(day+12)+(barangInt[1]+beratVolume);
                        System.out.println("Nomor resi anda adalah: "+noResi);
                        //info drop off
                        System.out.println("Silahkan letakkan paket anda pada kantor cabang terdekat sampai "+(day+1)+"/"+month+"/"+year) ;
                        Poin += 10;
                
                } else if (pilih.equals("3")) {
                    System.out.print("Asal(Provinsi):");
                    asal = input.nextLine();
                    System.out.print("Tujuan(Provinsi):");
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
                        break;
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
                    counter = 0;
                    
                    System.out.println("poin anda :" +Poin);
                    System.out.println("1. voucher diskon ongkir 40%");
                    System.out.println("2. voucher diskon ongkir 30%");
                    System.out.println("3. Exit");
                        
                    if (pilih.equals("1")) {
                        System.out.println("selamat anda mendapat voucher diskon ongkir 40%(25 Poin)");
                        Poin -= 25;
                        disc1 += 1;
                    }
                    if (pilih.equals("2")) {
                        System.out.println("selamat anda mendapat voucher diskon ongkir 40%(25 Poin)");
                        Poin -= 20;
                        disc2 += 1;
                    }
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