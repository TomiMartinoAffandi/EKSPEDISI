import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;  
import java.time.format.DateTimeFormatter;  

public class ekspedisi {
    static int poin;
    static int counter;
    static int[] disc = new int[100];
    static Scanner input = new Scanner(System.in);

    static String[][] informasiPengiriman(String[][] n) {
        String[] kotaDiterima = { "Malang", "Surabaya", "Jakarta", "Madiun", "Jember" };
        String[] identitasLabels = {
                "Nama", "Alamat", "Kecamatan", "Kelurahan", "Kota", "Provinsi", "Kode pos", "Nomor Telepon"
        };
        n = new String[2][8];
        boolean a = true;
        while (a) {
            for (int i = 0; i < 2; i++) {
                System.out.println("Masukkan informasi " + ((i == 0) ? "pengirim" : "penerima")
                        + " (Informasi tidak boleh kosong!):");

                for (int j = 0; j < 8; j++) {
                    if (j == 4) {
                        boolean valid = false;
                        do {
                            System.out.print(identitasLabels[j] + " " + ((i == 0) ? "pengirim" : "penerima")
                                    + " (Malang/Surabaya/Jakarta/Madiun/Jember): ");
                            String kota = input.nextLine();
                            for (String kotaD : kotaDiterima) {
                                if (kota.equalsIgnoreCase(kotaD)) {
                                    n[i][j] = kota;
                                    valid = true;
                                    break;
                                }
                            }
                            if (!valid) {
                                System.out.println(
                                        "Kota yang dimasukkan tidak valid. Silakan masukkan salah satu dari lima kota yang diizinkan.");
                            }
                        } while (!valid);
                    } else {
                        System.out.print(identitasLabels[j] + " " + ((i == 0) ? "pengirim" : "penerima") + ": ");
                        n[i][j] = input.nextLine();
                    }
                }
            }
            while (a) {
                System.out.print("Apakah anda ingin merubah data informasi pengiriman?(y/n): ");
                String jawaban = input.nextLine();
                if (jawaban.equalsIgnoreCase("n")) {
                    a = false;
                }else if (jawaban.equalsIgnoreCase("y")) {
                    a = true;
                }else {
                    System.out.println("inputan salah");
                }
            }
        }
        return n;
    }

    static int[] informasiBarang(int[] n) {
        String[] barangString = new String[2];
        int[] barangInt = new int[5];
        n = barangInt;
        System.out.println("Masukkan informasi barang (Informasi tidak boleh kosong!)");

        boolean b = true;
        while (b) {
            barangString[0] = getInputString("Nama Barang", false);
            barangString[1] = getInputString("Jenis Barang", false);
            barangInt[0] = Integer.parseInt(getInputStringNumber("Jumlah(pcs)", false));
            barangInt[1] = Integer.parseInt(getInputStringNumber("Berat(kg)", false));
            System.out.println("Hitung berat volume");
            barangInt[2] = Integer.parseInt(getInputStringNumber("Panjang(cm)", false));
            barangInt[3] = Integer.parseInt(getInputStringNumber("Lebar(cm)", false));
            barangInt[4] = Integer.parseInt(getInputStringNumber("Tinggi(cm)", false));
            
            while (b) {
                System.out.print("Apakah anda ingin merubah data informasi barang?(y/n): ");
                String jawaban = input.nextLine();
                if (jawaban.equalsIgnoreCase("n")) {
                    b = false;
                }else if (jawaban.equalsIgnoreCase("y")) {
                    b = true;
                }else {
                    System.out.println("inputan salah");
                }
            }
        }
        return n;
    }

    static int hitungBiaya(int biaya, int[] barangInt, String[][] identitas) {

        if (barangInt != null && identitas != null) {
            int jenLay = jenisLayanan();
            int beratVolume = (barangInt[2] * barangInt[3] * barangInt[4]) / 6000;

            if (beratVolume > barangInt[1]) {
                biaya = (10000 * beratVolume) + (jenLay * 10);
                if (!identitas[0][5].equalsIgnoreCase(identitas[1][5])) {
                    biaya += 5000;
                }
            } else {
                biaya = (10000 * barangInt[1]) + (jenLay * 10);
                if (!identitas[0][5].equalsIgnoreCase(identitas[1][5])) {
                    biaya += 5000;
                }
            }
        }
        return biaya;
    }

    static int jenisLayanan() {
        while (true) {
            System.out.print("Pilih jenis layanan pengiriman (Standard/Reguler/Express): ");
            String layanan = input.nextLine();
            if (layanan.equalsIgnoreCase("Standard")) {
                return 400;
            } else if (layanan.equalsIgnoreCase("Reguler")) {
                return 500;
            } else if (layanan.equalsIgnoreCase("Express")) {
                return 600;
            } else {
                System.out.println("Jenis layanan tidak valid!");
            }
        }
    }

    static int tukarPoin(int p) {

        while (true) {
            System.out.println("poin anda :" + p);
            System.out.println("\n====================================================");
            System.out.println("|   Tukarkan poin anda dan dapatkan secara GRATIS!   |");
            System.out.println("|          ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~          |");
            System.out.println("|                                                    |");
            System.out.println("|   1. Iphone 14 Pro Max(5000000 poin)               |");
            System.out.println("|   2. Macbook A1(10000000 poin)                     |");
            System.out.println("|   3. Exit                                          |");
            System.out.println("|                                                    |");
            System.out.println("======================================================");
            System.out.print("Pilih pilihan tukar poin: ");
            int pilih = input.nextInt();
            input.nextLine();

            if (pilih == 1) {
                if (p >= 5000000) {
                    System.out.println("selamat anda mendapat Iphone 14 Pro Max");
                    p -= 5000000;
                } else
                    System.out.println("poin anda tidak mencukupi");
            } else if (pilih == 2) {
                if (p >= 10000000) {
                    System.out.println("selamat anda mendapat Macbook A1");
                    p -= 10000000;
                } else
                    System.out.println("poin anda tidak mencukupi");
            } else if (pilih == 3) {
                break;
            } else {
                System.out.println("Pilihan tidak valid");
            }
        }
        return p;
    }

    static void pembayaran() {
        boolean pembayaranValid = false;
        int metodePembayaran;
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
                input.nextLine();
                System.out.print("Masukkan masa aktif kartu (MM/YY): ");
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

    static void tampilkanMenuTukarVoucher() {
        java.time.LocalDate today = java.time.LocalDate.now();
        System.out.println("Tanggal hari ini: "+java.time.LocalDate.now());
        System.out.println("\n=========================================================");
        System.out.println("|   Buruan claim Voucher dan dapatkan potongan Spesial!   |");
        System.out.println("|            ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~            |");
        System.out.println("|                                                         |");
        System.out.println("|  1. Klaim Voucher Potongan untuk Pengguna Baru 40%      |");
        System.out.println("|  2. Klaim Gratis Ongkir 11.11 100%                      |");
        System.out.println("|  3. Klaim Voucher Potongan Akhir Tahun 20%              |");
        System.out.println("|  4. Klaim Voucher Potongan Tanggal Cantik 15%           |");
        System.out.println("|  5. Spesial Promo Kemerdekaan Gratis Ongkir 100%        |");
        System.out.println("|  6. Keluar                                              |");
        System.out.println("|                                                         |\n");
        System.out.println("===========================================================");
        System.out.print("Pilih opsi tukar voucher:");
    }

    static void tukarVoucher(int index, int[] disc) {
        if (isVoucherAvailable(index)) {
            System.out.println(
                    "Selamat! Anda berhasil menukar voucher dengan diskon sebesar " + getDiskonPersen(index) + "%.");
            disc[index] = getDiskonPersen(index);
            generateAndPrintVoucherCode(getVoucherCode(index));
        } else {
            System.out.println("Maaf, voucher belum tersedia.");
        }
    }

    static boolean isVoucherAvailable(int index) {
        java.time.LocalDate today = java.time.LocalDate.now();
        int dayOfMonth = today.getDayOfMonth();
        int monthValue = today.getMonthValue();

        if (index == 0) {
            return true;
        } else if (index == 1) {
            return (dayOfMonth == 11 && monthValue == 11);
        } else if (index == 2) {
            return (monthValue == 12); // Hanya bisa di-claim di akhir tahun
        } else if (index == 3) {
            return (dayOfMonth == monthValue);
        } else if (index == 4) {
            return (dayOfMonth == 17 && monthValue == 8); // Hanya bisa di-claim pada tanggal 17 Agustus
        } else {
            return false;
        }
    }

    static void generateAndPrintVoucherCode(String voucherCode) {
        System.out.println("Kode Voucher Anda: " + voucherCode);
    }

    static String getVoucherCode(int index) {
        String[] voucherCodes = { "NEW40", "11FREE", "YEARENDS20", "PRETTY15", "MERDEKA" };
        return voucherCodes[index];
    }

    static String input(String info) {
        System.out.print(info + " : ");
        return input.nextLine().trim();
    }

    static int getDiskonPersen(int index) {
        int[] diskonPersen = { 40, 100, 20, 15, 100 };
        return diskonPersen[index];
    }

    static String getInputString(String prompt, boolean allowEmpty) {
        while (true) {
            String userInput = input(prompt);
            if (allowEmpty && userInput.isEmpty())
                return userInput;
            if (!userInput.isEmpty())
                return userInput;
            System.out.println("Masukan tidak boleh kosong!");
        }
    }

    static String getInputStringNumber(String prompt, boolean allowEmpty) {
        while (true) {
            String userInput = getInputString(prompt, allowEmpty);
            if (allowEmpty && userInput.isEmpty())
                return userInput;
            if (userInput.matches("[0-9]+"))
                return userInput;
            System.out.println("Masukan hanya boleh angka !");
        }
    }
    static String cetakNoResi(){
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyyHHmmss");  
        String formattedDate = myDateObj.format(myFormatObj);  
        return "62" + formattedDate;    
    }
    public static void main(String[] args) {
        String clearScreen = ("\033[H\033[2J");
        System.out.println(clearScreen);

        String username, passwrod;
        boolean berhasilLogin = false;
        int Poin = 0, harga = 0;
        String[][] user = new String[1][2];
        user[0][0] = "admin";
        user[0][1] = "admin";
        int[] barangI = new int[5];

        while (true) {
            System.out.println("\n========== Welcome to Sistem Ekspedisi! ==========");
            System.out.println("|                                                  |");
            System.out.println("|               Please Login Here                  |");
            System.out.println("|                                                  |");
            System.out.println("|         1. Sign in                               |");
            System.out.println("|         Exit                                     |");
            System.out.println("|                                                  |\n");
            System.out.println("=============== Masukkan Pilihan Anda ==============");
            int pilih = input.nextInt();
            input.nextLine();
            System.out.println(clearScreen);
            
            // while (true) {
            if (pilih == 1) {
                System.out.println("\n============== Login ==============\n");
                System.out.print("Masukan username :");
                username = input.nextLine();
                System.out.print("Masukan password :");
                passwrod = input.nextLine();
                    
                for (int i = 0; i < user.length; i++) {
                    if (username.equals(user[i][0]) && passwrod.equals(user[i][1])) {
                        berhasilLogin = true;
                        break;
                    } else {
                        System.out.println("Maaf, Username atau Password anda salah");
                    }
                }
                System.out.println(clearScreen);
            }
            while (berhasilLogin) {
                System.out.println("\n============= MENU =============");
                System.out.println("|    1. Pick up                   |");
                System.out.println("|    2. Drop off                  |");
                System.out.println("|    3. Harga                     |");
                System.out.println("|    4. Drop Point Sekitar        |");
                System.out.println("|    5. Tukar Poin                |");
                System.out.println("|    6. Klaim Voucher             |");
                System.out.println("|    7. Lacak Paket               |");
                System.out.println("|    8. Exit                      |\n");
                System.out.println("=============== MENU ==============");

                System.out.print("pilih menu : ");
                pilih = input.nextInt();
                input.nextLine();
                System.out.println(clearScreen);

                if (pilih == 1) {
                    System.out.println(clearScreen);
                    System.out.println("\n====================================");
                    System.out.println("|              PICK UP               |");
                    System.out.println("\n====================================");
                
                    System.out.println("Silahkan masukkan informasi pengiriman");
                    // memanggil fungsi informasiPengiriman
                    String[][] identitas = informasiPengiriman(new String[2][8]);
                    System.out.println(clearScreen);
                    System.out.println("\n====================================");
                    System.out.println("|              PICK UP               |");
                    System.out.println("\n====================================");
                
                    // memanggil fungsi informasiBarang
                    barangI = informasiBarang(new int[5]);
                    System.out.println(clearScreen);
                    System.out.println("\n====================================");
                    System.out.println("|              PICK UP               |");
                    System.out.println("\n====================================");
                
                    // Pemanggilan fungsi hitungBiaya
                    harga = hitungBiaya(harga, barangI, identitas);
                    harga += 5000;
                    System.out.println(clearScreen);
                    System.out.println("\n====================================");
                    System.out.println("|              PICK UP               |");
                    System.out.println("\n====================================");
                
                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga));
                    
                    //voucher
                    boolean A = true;
                    while (A) {
                        System.out.print("Apakah anda ingin menggunakan voucher(y/n): ");
                        String useVoucher = input.nextLine();
                        double potonganHarga = 0;

                        if (useVoucher.equalsIgnoreCase("y")) {
                            boolean kodeBenar = false;
                            while (!kodeBenar) {
                                System.out.print("Masukkan code voucher (ketik 'n' untuk exit) : ");
                                String voucherCode = input.nextLine();
                                // Apply discounts based on voucherCode
                                if ("NEW40".equals(voucherCode)) {
                                    potonganHarga = harga*0.4;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if ("11FREE".equals(voucherCode)) {
                                    potonganHarga = harga;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if ("YEARENDS20".equals(voucherCode)) {
                                    potonganHarga = harga*0.2;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if ("PRETTY15".equals(voucherCode)) {
                                    potonganHarga = harga*0.15;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if ("MERDEKA".equals(voucherCode)) {
                                    potonganHarga = harga;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if (voucherCode.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    System.out.println("Maaf, anda salah memasukkan code voucher.");
                                }
                            }
                            System.out.println();
                            harga -= potonganHarga;
                            System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga));
                            break;
                        } else if (useVoucher.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.print("Inputan salah!");
                        }
                    }
                    
                    // memanggil fungsi pembayaran + cetak resi
                    boolean lanjut = true;
                    while (lanjut) {
                        System.out.print("Ingin melanjutkan pembayaran? (y/n): ");
                        String jawaban = input.nextLine();
                        System.out.println(clearScreen);
                        System.out.println("\n====================================");
                        System.out.println("|              PICK UP               |");
                        System.out.println("\n====================================");
                
                        if (jawaban.equalsIgnoreCase("y")) {
                            pembayaran();
                            System.out.println("No resi anda adalah: "+cetakNoResi());
                            System.out.println("Silahkan simpan no resi anda");
                            Poin += 10;
                            break;
                        } else if (jawaban.equalsIgnoreCase("n")) {
                            while (true) {
                                System.out.print("Anda yakin tidak ingin melanjutkan pembayaran? (y/n): ");
                                String keluar = input.nextLine();
                                if (keluar.equalsIgnoreCase("y")) {
                                    lanjut = false;
                                    break;
                                } else if (keluar.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                   System.out.print("Inputan salah!");
                                }
                            }
                        } else {
                            System.out.print("Inputan salah!");
                        }
                    }
                    System.out.println(clearScreen);

                } else if (pilih == 2) {
                    System.out.println(clearScreen);
                    System.out.println("\n====================================");
                    System.out.println("|             DROP OFF               |");
                    System.out.println("\n====================================");
                
                    System.out.println("Silahkan masukkan informasi pengiriman");
                    // memanggil fungsi informasiPengiriman
                    String[][] identitas = informasiPengiriman(new String[2][8]);
                    System.out.println(clearScreen);
                    System.out.println("\n====================================");
                    System.out.println("|             DROP OFF               |");
                    System.out.println("\n====================================");
                
                    // memanggil fungsi informasiBarang
                    barangI = informasiBarang(new int[5]);
                    System.out.println(clearScreen);
                    System.out.println("\n====================================");
                    System.out.println("|             DROP OFF               |");
                    System.out.println("\n====================================");
                
                    // Pemanggilan fungsi hitungBiaya
                    harga = hitungBiaya(harga, barangI, identitas);
                    System.out.println(clearScreen);
                    System.out.println("\n====================================");
                    System.out.println("|             DROP OFF               |");
                    System.out.println("\n====================================");
                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga));
                
                    //voucher
                    boolean A = true;
                    while (A) {
                        System.out.print("Apakah anda ingin menggunakan voucher(y/n): ");
                        String useVoucher = input.nextLine();
                        double potonganHarga = 0;

                        if (useVoucher.equalsIgnoreCase("y")) {
                            boolean kodeBenar = false;
                            while (!kodeBenar) {
                                System.out.print("Masukkan code voucher (ketik 'n' untuk exit) : ");
                                String voucherCode = input.nextLine();
                                // Apply discounts based on voucherCode
                                if ("NEW40".equals(voucherCode)) {
                                    potonganHarga = harga*0.4;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if ("11FREE".equals(voucherCode)) {
                                    potonganHarga = harga;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if ("YEARENDS20".equals(voucherCode)) {
                                    potonganHarga = harga*0.2;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if ("PRETTY15".equals(voucherCode)) {
                                    potonganHarga = harga*0.15;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if ("MERDEKA".equals(voucherCode)) {
                                    potonganHarga = harga;
                                    System.out.println("Selamat anda mendapatkan potongan sebesar " + potonganHarga);
                                    kodeBenar = true;
                                } else if (voucherCode.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                    System.out.println("Maaf, anda salah memasukkan code voucher.");
                                }
                            }
                            System.out.println();
                            harga -= potonganHarga;
                            System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga));
                            break;
                        } else if (useVoucher.equalsIgnoreCase("n")) {
                            break;
                        } else {
                            System.out.print("Inputan salah!");
                        }
                    }
                
                    // pemanggilan fungsi pembayaran dan cetak resi
                    boolean lanjut = true;
                    while (lanjut) {
                        System.out.print("Ingin melanjutkan pembayaran? (y/n): ");
                        String jawaban = input.nextLine();
                        System.out.println(clearScreen);
                        System.out.println("\n====================================");
                        System.out.println("|             DROP OFF               |");
                        System.out.println("\n====================================");
                
                        if (jawaban.equalsIgnoreCase("y")) {
                            pembayaran();
                            System.out.println("No resi anda adalah: "+cetakNoResi());
                            System.out.println("Silahkan simpan no resi anda");
                            Poin += 10;
                            break;
                        } else if (jawaban.equalsIgnoreCase("n")) {
                            while (true) {
                                System.out.print("Anda yakin tidak ingin melanjutkan pembayaran? (y/n): ");
                                String keluar = input.nextLine();
                                if (keluar.equalsIgnoreCase("y")) {
                                    lanjut = false;
                                    break;
                                } else if (keluar.equalsIgnoreCase("n")) {
                                    break;
                                } else {
                                   System.out.print("Inputan salah!");
                                }
                            }
                        } else {
                            System.out.print("Inputan salah!");
                        }
                    }
                    System.out.println(clearScreen);
                
                } else if (pilih == 3) {
                    String[][] provinsi = new String[2][];
                    provinsi[0] = new String[1]; // asal provinsi
                    provinsi[1] = new String[1]; // tujuan provinsi

                    System.out.print("Asal(Provinsi):");
                    provinsi[0][0] = input.nextLine();
                    System.out.print("Tujuan(Provinsi):");
                    provinsi[1][0] = input.nextLine();
                    System.out.println(clearScreen);

                    // memanggil fungsi informasiBarang
                    barangI = informasiBarang(new int[5]);

                    System.out.println(clearScreen);

                    if (harga == 0) {
                        harga = hitungBiaya(harga, barangI, provinsi);
                    }

                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga));

                } else if (pilih == 4) {
                    String[] dropPoints = { "Malang", "Surabaya", "Jakarta", "Madiun", "Jember" };
                    String[][] branchDetails = {
                            { "Jl. Kalpataru No 89", "Jl. S. Supriadi No.74", "Jl. Bendungan Sutami No. 15" },
                            { "Jl. Raya Darmo Indah Bar. No.36", "Jl. Dukuh Setro IV No.2",
                                    "Jl. Urip Sumoharjo No.44" },
                            { "Jl. Mangga Dua Raya 39II", "Jl Pramuka Sari II No.20" },
                            { "Jl. Salak No.6", "Jl. Basuki Rahmad No.4", "Jl. Imam Bonjol" },
                            { "Jl. Sumatra No.75A", "Jl. Basuki Rahmat No.151" }
                    };

                    boolean changeLocation = true;

                    while (changeLocation) {
                        System.out.println("Pilih Drop Point Sekitar:");
                        for (int i = 0; i < dropPoints.length; i++) {
                            System.out.println((i + 1) + ". " + dropPoints[i]);
                        }

                        System.out.print("Masukkan nomor Drop Point yang dipilih (1-" + dropPoints.length + "): ");
                        int selectedDropPointIndex = input.nextInt();

                        if (selectedDropPointIndex >= 1 && selectedDropPointIndex <= dropPoints.length) {
                            String selectedDropPoint = dropPoints[selectedDropPointIndex - 1];
                            System.out.println("Anda telah memilih Drop Point: " + selectedDropPoint);

                            String[] branches = branchDetails[selectedDropPointIndex - 1];
                            System.out.println("Berikut pilihan cabangnya:");
                            for (int i = 0; i < branches.length; i++) {
                                System.out.println((i + 1) + ". " + branches[i]);
                            }

                            System.out.print("Masukkan nomor cabang yang dipilih (1-" + branches.length + "): ");
                            int selectedBranchIndex = input.nextInt();

                            if (selectedBranchIndex >= 1 && selectedBranchIndex <= branches.length) {
                                String selectedBranch = branches[selectedBranchIndex - 1];
                                System.out.println("Apakah anda memilih " + selectedBranch + " (ya/Tidak)");
                                String confirmationInput = input.next().toLowerCase();

                                if (confirmationInput.equals("ya")) {
                                    System.out.println("Anda telah memilih " + selectedDropPoint +
                                            " dengan drop poin " + selectedBranch);
                                }
                                System.out.print("Apakah anda ingin mengganti lokasi lain? (ya/Tidak): ");
                                String changeLocationInput = input.next().toLowerCase();
                                changeLocation = changeLocationInput.equals("ya");
                            } else {
                                System.out.println("Nomor cabang tidak valid.");
                                changeLocation = false;
                            }
                        } else {
                            System.out.println("Nomor Drop Point tidak valid.");
                            changeLocation = false;
                        }
                    }
                } else if (pilih == 5) {
                    int disc = tukarPoin(Poin);
                    System.out.println(clearScreen);
                    // ... (previous code)

                } else if (pilih == 6) {
                    System.out.println("6. Menu Voucher Claim");
                    tampilkanMenuTukarVoucher();
                    System.out.print("Pilih opsi tukar voucher: ");
                    pilih = input.nextInt();
                    input.nextLine();

                    if (pilih >= 0 && pilih < 5) {
                        tukarVoucher(pilih, disc);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                } else if (pilih == 7) {
                    String[][] lacakResi = {
                            // resi, status, informasi
                            { "EKS0010101010", "Sedang diproses", "Menunggu kurir untuk mengambil paket" },
                            { "EKS0210202020", "Sedang diproses", "Menunggu paket diserahkan ke pihak jasa kirim" },
                            { "EKS0010303030", "Sedang dikirim", "Paket telah sampai di drop point Malang" },
                            { "EKS0210404040", "Sedang dikirim", "Paket sedang dalam perjalanan menuju drop point Surabaya" },
                            { "EKS0010505050", "Sedang dikirim", "Paket sedang diantar ke alamat tujuan" },
                            { "EKS0210606060", "Terkirim", "Paket telah diterima oleh penerima" }
                    };

                    System.out.print("Masukkan nomor resi yang ingin dilacak: ");
                    String inputResi = input.nextLine();

                    boolean ditemukan = false;
                    String status = null, informasi = null;

                    for (int i = 0; i < lacakResi.length; i++) {
                        if (lacakResi[i][0].equals(inputResi)) {
                            ditemukan = true;
                            status = lacakResi[i][1];
                            informasi = lacakResi[i][2];
                            break;
                        }
                    }

                    if (ditemukan) {
                        System.out.println("Status pengiriman: " + status);
                        System.out.println("Informasi Pengiriman: " + informasi);
                    } else {
                        System.out.println("Nomor resi tidak ditemukan. Mohon periksa kembali nomor resi Anda.");
                    }
                    System.out.println();

                } else if (pilih == 8) {
                    System.out.println("keluar");
                    System.exit(0);
                } else {
                    System.out.print("Inputan salah!");
                }
            }
        }
    }
}