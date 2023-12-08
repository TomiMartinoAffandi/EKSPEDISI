import java.util.Random;
import java.util.Scanner;

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
                String jawaban = input.next();
                if (jawaban.equalsIgnoreCase("n")) {
                    a = false;
                }else if (jawaban.equalsIgnoreCase("y")) {
                    a = true;
                }else{
                    System.out.println("inputan salah");
                }
            }
        }
        return n    ;
    }

    static int[] informasiBarang(int[] n) {
        String[] barangString = new String[2];
        n = new int[5];
        System.out.println("Masukkan informasi barang (Informasi tidak boleh kosong!)");

        boolean b = true;
        while (b) {
            // input informasi barang
            System.out.print("Nama barang: ");
            barangString[0] = input.nextLine();
            input.nextLine();
            System.out.print("Jenis barang: ");
            barangString[1] = input.nextLine();
            System.out.print("Jumlah(pcs): ");
            n[0] = input.nextInt();
            System.out.print("Berat(kg): ");
            n[1] = input.nextInt();
            System.out.println("Hitung berat volume");
            System.out.print("Panjang(cm): ");
            n[2] = input.nextInt();
            System.out.print("Lebar(cm): ");
            n[3] = input.nextInt();
            System.out.print("Tinggi(cm): ");
            n[4] = input.nextInt();

            System.out.print("Apakah Anda ingin mengubah data informasi barang? (y/n): ");
            String jawaban = input.next();
            if (jawaban.equalsIgnoreCase("n")) {
                b = false;
            }
        }
        return n;
    }

    static int hitungBiaya(int n, int[] barangInt, String[][] identitas) {
        int jenLay = jenisLayanan();
        int beratVolume = (barangInt[2] * barangInt[3] * barangInt[4]) / 6000;

        if (beratVolume > barangInt[1]) {
            n = (10000 * beratVolume) + (jenLay * 10);
            if (!identitas[0][5].equalsIgnoreCase(identitas[1][5])) {
                n += 5000; // Jika beda provinsi
            }
        } else {
            n = (10000 * barangInt[1]) + (jenLay * 10);
            if (!identitas[0][5].equalsIgnoreCase(identitas[1][5])) {
                n += 5000; // Jika beda provinsi
            }
        }
        System.out.print("apakah anda ingin menggunakan voucher(y/n)?");
        String pilih = input.next();
        if (pilih.equalsIgnoreCase("y")) {
        while (true) {
                System.out.println("Voucher yang tersedia :");
                System.out.println("Poin anda :"+poin);
                System.out.println("1. Diskon Ongkir 40%(25 poin)");
                System.out.println("2. Diskon Ongkir 30%(20 poin)");
                System.out.println("3. Cancel");
                System.out.print("pilih voucher: ");
                pilih = input.next();

                if (pilih.equals("1")) {
                    if (poin >= 25) {
                        n*=0.4;
                    }else
                        System.out.println("anda tidak memenuhi syarat");
                }else if (pilih.equals("2")) {
                    if (poin >= 20) {
                        n*=0.3;
                    }else
                        System.out.println("anda tidak memenuhi syarat");
                }else if (pilih.equals("3")) {
                    break;
                }
            } 
        }

        //pembayaran
    return n;
}
    static int jenisLayanan() {
        while (true) {
            System.out.print("Pilih jenis layanan pengiriman (Standard/Reguler/Express): ");
            String layanan = input.next();
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

    static int tukarPoin(int poin) {
        int p = poin;

        while (true) {
            System.out.println("poin anda :" + poin);

            System.out.println("");
            System.out.println("1. Iphone 14 Pro Max(5000000 poin)");
            System.out.println("2. Macbook A1(10000000 poin)");
            System.out.println("3. Exit");

            System.out.print("Pilih pilihan tukar poin: ");
            String pilih = input.nextLine();

            if (pilih.equals("1")) {
                if (p >= 5000000) {
                    System.out.println("selamat anda mendapat Iphone 14 Pro Max");
                    p -= 5000000;
                } else
                    System.out.println("poin anda tidak mencukupi");
            } else if (pilih.equals("2")) {
                if (p >= 10000000) {
                    System.out.println("selamat anda mendapat Macbook A1");
                    p -= 10000000;
                } else
                    System.out.println("poin anda tidak mencukupi");
            } else if (pilih.equals("3")) {
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
    static String generateUniqueCode() {
        Random random = new Random();
        int uniqueCode = random.nextInt(10);
        return String.format("%03d", uniqueCode);
    }

    static void tampilkanMenuTukarVoucher() {
        java.time.LocalDate today = java.time.LocalDate.now();
        System.out.println("Tanggal hari ini: " + java.time.LocalDate.now());
        System.out.println("Buruan claim Voucher dan dapatkan potongan Spesial :");
        System.out.println("1. Klaim Voucher Potongan untuk Pengguna Baru 40%");
        System.out.println("2. Klaim Gratis Ongkir 11.11 100%");
        System.out.println("3. Klaim Voucher Potongan Akhir Tahun 20%");
        System.out.println("4. Klaim Voucher Potongan Tanggal Cantik 15%");
        System.out.println("5. Spesial Promo Kemerdekaan Gratis Ongkir 100%");
        System.out.println("6. Keluar");
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

    static int getDiskonPersen(int index) {
        int[] diskonPersen = { 40, 100, 20, 15, 100 };
        return diskonPersen[index];
    }

    public static void main(String[] args) {
        String clearScreen = ("\033[H\033[2J");
        System.out.println(clearScreen);

        String pilih, username, passwrod;
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
            //while (true) {
                if (pilih.equals("1")) {
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
                }
                System.out.println(clearScreen);
            //}
            while (berhasilLogin) {
                System.out.println("menu");
                System.out.println("1. Pick up");
                System.out.println("2. Drop off");
                System.out.println("3. Harga");
                System.out.println("4. Drop Point Sekitar");
                System.out.println("5. Tukar Poin");
                System.out.println("6. Klaim Voucher");
                System.out.println("7. Lacak Paket");
                System.out.println("8. Exit");

                System.out.print("pilih menu : ");
                pilih = input.nextLine();
                System.out.println(clearScreen);

                if (pilih.equals("1")) {
                    System.out.println(clearScreen);
                    System.out.println("Silahkan masukkan informasi pengiriman");
                    // memanggil fungsi informasiPengiriman

                    String[][] identitas = informasiPengiriman(new String[2][8]);
                    System.out.println(clearScreen);

                    // memanggil fungsi informasiBarang
                    barangI = informasiBarang(new int[5]);

                    System.out.println(clearScreen);

                    // Pemanggilan fungsi hitungBiaya
                    harga = hitungBiaya(harga, barangI, identitas);
                    if (harga == 0) {
                        harga = hitungBiaya(harga, barangI, identitas);
                    }

                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga + 5000));

                    // memanggil fungsi pembayaran
                    pembayaran();
                    System.out.println(clearScreen);

                    // Informasi tanggal
                    System.out.println("Masukkan tanggal pick-up: ");
                    System.out.print("dd: ");
                    int day = input.nextInt();
                    System.out.print("mm: ");
                    int month = input.nextInt();
                    System.out.print("yy: ");
                    int year = input.nextInt();
                    input.nextLine();
                    System.out.println(clearScreen);

                    // update no resi
                    String kode = generateUniqueCode();
                    String Resi = day + month + year + kode;

                    System.out.println("Silahkan simpan nomor resi anda!");
                    String noResi = "EKS001" + Resi;
                    System.out.println("Nomor resi anda adalah: " + noResi);
                    System.out.println();

                    // info pick up
                    System.out.println("Silahkan menunggu kurir untuk mengambil paket anda sampai " + (day + 1) + "/" + month + "/" + year);
                    Poin += 10;

                } else if (pilih.equals("2")) {
                    System.out.println(clearScreen);
                    System.out.println("Silahkan masukkan informasi pengiriman");
                    // memanggil fungsi informasiPengiriman
                    String[][] identitas = informasiPengiriman(new String[2][8]);
                    System.out.println(clearScreen);

                    // memanggil fungsi informasiBarang
                    barangI = informasiBarang(new int[5]);

                    System.out.println(clearScreen);

                    // Pemanggilan fungsi hitungBiaya
                    if (harga == 0) {
                        harga = hitungBiaya(harga, barangI, identitas);
                    }

                    System.out.println("Total biaya pengiriman barang anda adalah: Rp." + (harga));

                    // pemanggilan fungsi pembayaran
                   pembayaran();
                   System.out.println(clearScreen);

                    // Informasi tanggal
                    System.out.println("Masukkan tanggal drop-off: ");
                    System.out.print("dd: ");
                    int day = input.nextInt();
                    System.out.print("mm: ");
                    int month = input.nextInt();
                    System.out.print("yy: ");
                    int year = input.nextInt();
                    input.nextLine();
                    System.out.println(clearScreen);

                    // update no resi
                    String kode = generateUniqueCode();
                    String Resi = day + month + year + kode;

                    System.out.println("Silahkan simpan nomor resi anda!");
                    String noResi = "EKS021" + Resi;
                    System.out.println("Nomor resi anda adalah: " + noResi);
                    System.out.println();

                    // info drop off
                    System.out.println("Silahkan letakkan paket anda pada kantor cabang terdekat sampai " + (day + 1) + "/" + month + "/" + year);
                    Poin += 10;

                } else if (pilih.equals("3")) {
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

                } else if (pilih.equals("4")) {
                    String[] dropPoints = { "Malang", "Surabaya", "Jakarta", "Madiun", "Jember" };
                    String[][] branchDetails = {
                            { "Jl. Kalpataru No 89", "Jl. S. Supriadi No.74", "Jl. Bendungan Sutami No. 15" },
                            { "Jl. Raya Darmo Indah Bar. No.36", "Jl. Dukuh Setro IV No.2","Jl. Urip Sumoharjo No.44" },
                            { "Jl. Mangga Dua Raya 39II", "Jl Pramuka Sari II No.20" },
                            { "Jl. Salak No.6", "Jl. Basuki Rahmad No.4", "Jl. Imam Bonjol" },
                            { "Jl. Sumatra No.75A", "Jl. Basuki Rahmat No.151" }
                    };

                    boolean changeLocation = true;

                    while (changeLocation) {
                        System.out.println("Pilih Drop Point Sekitar:");
                        for (int i = 0; i < dropPoints.length; i++) {
                            System.out.println((i + 1 ) + ". " + dropPoints[i]);
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
                } else if (pilih.equals("5")) {
                    int disc = tukarPoin(Poin);
                    System.out.println(clearScreen);
                    // ... (previous code)

                } else if (pilih.equals("6")) {
                    System.out.println("6. Menu Voucher Claim");
                    tampilkanMenuTukarVoucher();
                    System.out.print("Pilih opsi tukar voucher: ");
                    pilih = input.nextLine();
                    int index = Integer.parseInt(pilih) - 1;

                    if (index >= 0 && index < 5) {
                        tukarVoucher(index, disc);
                    } else {
                        System.out.println("Pilihan tidak valid.");
                    }
                } else if (pilih.equals("7")) {
                    String[][] lacakResi = {
                            // resi, status, informasi
                            { "EKS0010101010", "Sedang diproses", "Menunggu kurir untuk mengambil paket" },
                            { "EKS0210202020", "Sedang diproses", "Menunggu paket diserahkan ke pihak jasa kirim" },
                            { "EKS0010303030", "Sedang dikirim", "Paket telah sampai di drop point Malang" },
                            { "EKS0210404040", "Sedang dikirim","Paket sedang dalam perjalanan menuju drop point Surabaya" },
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

                } else if (pilih.equals("8")) {
                    System.out.println("keluar");
                    System.exit(0);
                }
            }
        }
    }
}