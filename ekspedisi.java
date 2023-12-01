import java.util.Scanner;

public class ekspedisi {
    static String[][] informasiPengiriman(String[][] n) {
        Scanner input = new Scanner(System.in);
        String[] kotaDiterima = {"Malang", "Surabaya", "Jakarta", "Madiun", "Jember"};
        String[] identitasLabels = {
            "Nama", "Alamat", "Kecamatan", "Kelurahan", "Kota", "Provinsi", "Kode pos", "Nomor Telepon"
        };
        String[][] identitas = new String[2][8];
        while(true) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Masukkan informasi " + ((i == 0) ? "pengirim" : "penerima") + " (Informasi tidak boleh kosong!):");
                            
                for (int j = 0; j < 8; j++) {
                    if (j == 4) {
                        boolean valid = false;
                        do {
                            System.out.print(identitasLabels[j] + " " + ((i == 0) ? "pengirim" : "penerima") + " (Malang/Surabaya/Jakarta/Madiun/Jember): ");
                            String kota = input.nextLine();
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
                        System.out.print(identitasLabels[j] + " " + ((i == 0) ? "pengirim" : "penerima") + ": ");
                        identitas[i][j] = input.nextLine();
                    }
                }
            }
                        
            System.out.print("Apakah anda ingin merubah data informasi pengiriman?(y/n): ");
            String jawaban = input.next();
            if (jawaban.equalsIgnoreCase("n")) {
                break;
            }
        }
        return identitas;
    }
    static int[] informasiBarang(int[] n) {
        Scanner input = new Scanner(System.in);
        String[] barangString = new String[2];
        int[] barangInt = new int[5];
        n = barangInt;
        System.out.println ("Masukkan informasi barang (Informasi tidak boleh kosong!)");
        while (true) {
            //input informasi barang
            System.out.print("Nama barang: ");
            barangString[0] = input.nextLine();
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
            input.nextLine();
            
            
            System.out.print("Apakah Anda ingin mengubah data informasi barang? (y/n): ");
            String jawaban = input.next();
            if (jawaban.equalsIgnoreCase("n")) {
                break;
            }
        }
        return barangInt;
    }
    
    static int hitungBiaya(int n) {
        int biaya;
        
        Scanner input = new Scanner(System.in);
        int[] barangInt = informasiBarang(new int[5]);
        String[][] identitas = informasiPengiriman(new String[2][8]);
        
        int jenLay = jenisLayanan(n);
        
        int beratVolume = (barangInt[2] * barangInt[3] * barangInt[4]) / 6000;
               
        if (beratVolume > barangInt[1]) {
            biaya = (10000 * beratVolume) + (jenLay * 10);
            if (!identitas[0][5].equalsIgnoreCase(identitas[1][5])) {
                biaya += 5000; // Jika beda provinsi
            }
        } else {
            biaya = (10000 * barangInt[1]) + (jenLay * 10);
            if (!identitas[0][5].equalsIgnoreCase(identitas[1][5])) {
                biaya += 5000; // Jika beda provinsi
            }
        }
        return biaya;
    }
    static int jenisLayanan(int L) {
        Scanner input = new Scanner(System.in);
        L = 0;
        while (true) {
            System.out.print("Pilih jenis layanan pengiriman (Standard/Reguler/Express): ");
            String layanan = input.nextLine();
            if (layanan.equalsIgnoreCase("Standard")) {
                L = 400;
                break;
            } else if (layanan.equalsIgnoreCase("Reguler")) {
                L = 500;
                break;
            } else if (layanan.equalsIgnoreCase("Express")) {
                L = 600;
                break;
            } else {
                System.out.println("Jenis layanan tidak valid!");
            }
        }
        return L;
    }
    static int[] tukarPoin(int poin) {
        int p = poin;
        Scanner input = new Scanner(System.in);
        int[] disc = new int[2];
        
        while(true) {
            System.out.println("poin anda :" +poin);
            System.out.println("1. voucher diskon ongkir 40%(25 poin)");
            System.out.println("2. voucher diskon ongkir 30%(20 poin)");
            System.out.println("3. Iphone 14 Pro Max(5000000 poin)");
            System.out.println("4. Macbook A1(10000000 poin)");
            System.out.println("5. Exit");
            
            System.out.print("Pilih pilihan tukar poin: ");
            String pilih = input.nextLine();
            
            if (pilih.equals("1")) {
                if (p >= 25) {
                    System.out.println("selamat anda mendapat voucher diskon ongkir 40%");
                    p -= 25;
                    disc[0] += 1;
                }else
                    System.out.println("poin anda tidak mencukupi");
            } else if (pilih.equals("2")) {
                if (p >= 20) {
                    System.out.println("selamat anda mendapat voucher diskon ongkir 30%");
                    p -= 20;
                    disc[2] += 1;
                }else
                    System.out.println("poin anda tidak mencukupi");
            } else if (pilih.equals("3")) {
                if (p >= 5000000 ) {
                    System.out.println("selamat anda mendapat Iphone 14 Pro Max");
                    p -= 5000000;
                }else
                    System.out.println("poin anda tidak mencukupi");
            }else if (pilih.equals("4")) {
                if (p >= 10000000) {
                    System.out.println("selamat anda mendapat Macbook A1");
                    p -= 10000000;
                }else
                    System.out.println("poin anda tidak mencukupi");
            }else if (pilih.equals("5")) {
                break;
            }else {
                System.out.println("Pilihan tidak valid");
            }
        }
        return disc;
    }
    static void pembayaran() {
        Scanner input = new Scanner(System.in);
        boolean pembayaranValid = false;
        int metodePembayaran;
        do {
            System.out.println("Pilihan Pembayaran:");
            System.out.println("1. COD (Cash On Delivery)");
            System.out.println("2. Transfer Bank");
            System.out.print("Pilih metode pembayaran (1/2): ");
            metodePembayaran = input.nextInt();
            input.nextLine();
            
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
            input.nextLine();
            String masaAktifKartu = input.nextLine();
            System.out.print("Masukkan CVV: ");
            int cvv = input.nextInt();
            input.nextLine();
            pembayaranValid = true;
            System.out.print("Pembayaran sukses!");
            } else {
                System.out.println("Metode pembayaran tidak valid!");
                pembayaranValid = false;
            }
        } while (!pembayaranValid);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String clearScreen = ("\033[H\033[2J");
        System.out.println(clearScreen);
        
        String pilih, asal, tujuan,username, passwrod;
        boolean berhasilLogin = false; 
        int jenLay = 0, Poin = 0, harga = 0, voucher = 0;
        String[][] user = new String[1][2];
        user[0][0] = "admin";
        user[0][1] = "admin";
        int[] barangI = new int[5];
        
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
                        break;
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
                    //memanggil fungsi informasiPengiriman
                    
                    String[][] identitas = informasiPengiriman(new String[2][5]);
                
                    System.out.println("=============================");
                    System.out.println("=============================");
                    
                    //memanggil fungsi informasiBarang
                    if (barangI == null) {
                        barangI = informasiBarang(new int[5]);
                    }
                    
                    System.out.println("=============================");
                    
                    // Pemilihan jenis layanan
                    if (jenLay == 0) {
                        jenLay = jenisLayanan(jenLay);
                    }
                    
                    // Pemanggilan fungsi hitungBiaya
                    harga = hitungBiaya(harga);
                    if (harga == 0) {
                        harga = hitungBiaya(harga);
                    }
                    
                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga+5000));
                    
                    // memanggil fungsi pembayaran
                    while (true) {
                        System.out.print("Ingin melanjutkan pembayaran? (y/n): ");
                        String jawaban = input.next();
                        if (jawaban.equalsIgnoreCase("y")) {
                            pembayaran();
                            break;
                        }
                        System.out.println("=============================");
                    }
                    
                    
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
                    input.nextLine();
                        
                    //update no resi
                    System.out.println("Silahkan simpan nomor resi anda!");
                    String noResi = "EKS001"+((year+month+20)/4)+(day+12);
                    System.out.println("Nomor resi anda adalah: "+noResi);
                    
                    //info pick up
                    System.out.println("Silahkan menunggu kurir untuk mengambil paket anda sampai "+(day+1)+"/"+month+"/"+year);
                    Poin += 10;
                    
                } else if (pilih.equals("2")) {
                    System.out.println(clearScreen);
                    System.out.println("Silahkan masukkan informasi pengiriman");
                    //memanggil fungsi informasiPengiriman
                    String[][] identitas = informasiPengiriman(new String[2][5]);
                
                    System.out.println("=============================");
                    System.out.println("=============================");
                    
                    //memanggil fungsi informasiBarang
                    if (barangI == null) {
                        barangI = informasiBarang(new int[5]);
                    }
                
                    System.out.println("=============================");
                    System.out.println("=============================");
                
                    // Pemilihan jenis layanan
                    if (jenLay == 0) {
                        jenLay = jenisLayanan(jenLay);
                    }
                
                    // Pemanggilan fungsi hitungBiaya
                    if (harga == 0) {
                        harga = hitungBiaya(harga);
                    }
                
                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga));
                
                    //pemanggilan fungsi pembayaran
                    while (true) {
                        System.out.print("Ingin melanjutkan pembayaran? (y/n): ");
                        String jawaban = input.next();
                        if (jawaban.equalsIgnoreCase("y")) {
                            pembayaran();
                            break;
                        }
                        System.out.println("=============================");
                    }
                
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
                    input.nextLine();
                
                    //update no resi
                    System.out.println("Silahkan simpan nomor resi anda!");
                    String noResi = "EKS021"+((year+month+20)/4)+(day+12);
                    System.out.println("Nomor resi anda adalah: "+noResi);
                
                    //info drop off
                    System.out.println("Silahkan letakkan paket anda pada kantor cabang terdekat sampai "+(day+1)+"/"+month+"/"+year) ;
                    Poin += 10;
                
                } else if (pilih.equals("3")) {
                    System.out.print("Asal(Provinsi):");
                    asal = input.nextLine();
                    System.out.print("Tujuan(Provinsi):");
                    tujuan = input.nextLine();
                
                    //memanggil fungsi informasiBarang
                    if (barangI == null) {
                        barangI = informasiBarang(new int[5]);
                    }
                
                    if (jenLay == 0) {
                        jenLay = jenisLayanan(jenLay);
                    }
                
                    if (harga == 0) {
                        harga = hitungBiaya(harga);
                    }
                
                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga));
                    
                }else if (pilih.equals("4")) {
                        
                }else if (pilih.equals("5")) {
                    int disc[] = tukarPoin(Poin);
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