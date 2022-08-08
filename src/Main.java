import java.util.*;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static Integer kembalian = 0;
    public static void main(String[] args) throws InterruptedException {
        if (kembalian == -1){
            return;
        }
        homeLanding();
    }

    private static void homeLanding() throws InterruptedException {
        if (kembalian == -1){
            return;
        }
        System.out.println("----------------------");
        System.out.println("Selamat datang di Aplikasi Laundry");
        System.out.println("----------------------");
        System.out.println("Silahkan Login terlebih dahulu:");
        System.out.println("1. Admin");
        System.out.println("2. User");
        System.out.println("3. Keluar");
        System.out.println("----------------------");
        System.out.print("Masukkan pilihan anda:");
        int menuPilihan = keyboard.nextInt();

        pilihanMenuHome(menuPilihan);

    }

    private static void pilihanMenuHome(int menuPilihan) throws InterruptedException {
        switch (menuPilihan){
            case 1:
                System.out.println("Silahkan tunggu sebentar...");
                isLoading();
                loginAdmin();
            case 2:
                System.out.println("Silahkan tunggu sebentar...");
                isLoading();
                loginPelanggan();
            case 3:
                System.out.println("Menutup Aplikasi..");
                isLoading();
                kembalian = -1;
                homeLanding();
                return;
            default:
                System.out.println("Silahkan masukkan data dengan benar!!");
                isLoading();
                homeLanding();
        }
    }

    private static void loginAdmin() throws InterruptedException {

        System.out.println("----------------------");
        System.out.println("Silahkan masukkan data Admin");
        System.out.println("----------------------");
        System.out.print("Username:");
        String username = keyboard.next();

        System.out.println("");

        System.out.print("Password:");
        String password = keyboard.next();


        System.out.println("-------------------");
        System.out.println("Enkripsi data...");
        isLoading();
        System.out.println("Data berhasil dienkripsi...");
        isLoading();
        checkAkunAdmin(username,password);
    }

    private static void loginPelanggan() throws InterruptedException {

        System.out.println("----------------------");
        System.out.println("Silahkan masukkan data Pelanggan");
        System.out.println("----------------------");
        System.out.print("Username:");
        String username = keyboard.next();

        System.out.println("");

        System.out.print("Password:");
        String password = keyboard.next();

        System.out.println("-------------------");
        System.out.println("Enkripsi data...");
        isLoading();
        System.out.println("Data berhasil dienkripsi...");
        isLoading();
        checkAkunPelanggan(username,password);
    }

    private static void checkAkunAdmin(String username, String password) throws InterruptedException {
        if (username.equals("admin") && password.equals("admin")){
            isLoading();
            homeAdmin();
        }else {
            isLoading();
            System.out.println("Username/Password salah...");
            System.out.println("Silahkan masukkan dengan benar!!");
            isLoading();
            loginAdmin();
        }
    }

    private static void checkAkunPelanggan(String username, String password) throws InterruptedException {
        if (username.equals("pelanggan") && password.equals("pelanggan")){
            isLoading();
            homePelanggan();
        }else {
            isLoading();
            System.out.println("Username/Password salah...");
            System.out.println("Silahkan masukkan dengan benar!!");
            isLoading();
            loginPelanggan();
        }
    }

    private static void homePelanggan() throws InterruptedException {
        System.out.println("----------------------");
        System.out.println("Selamat Datang di Fatin Laundry");
        System.out.println("----------------------");
        System.out.println("1. Ambil paket");
        System.out.println("2. Input pesanan");
        System.out.println("3. keluar");
        System.out.print("Tentukan pilihan anda:");
        Integer pilihanPelanggan = keyboard.nextInt();

        checkPilihanPelanggan(pilihanPelanggan);
    }

    private final static Queue<String> q
            = new LinkedList<>();

    private static void checkPilihanPelanggan(Integer pilihanPelanggan) throws InterruptedException {
        switch (pilihanPelanggan){
            case 1:

                    for (String s : q) {
                        System.out.println(s + "\n");
                    }
                    while (true){
                        if (q.isEmpty()){
                            System.out.println("------------------");
                            System.out.println("Anda belum memesan.");
                            isLoading();
                            System.out.println("silahkan lakukan pemesanan terlebih dahulu.");
                            isLoading();
                            System.out.println("------------------");
                            homePelanggan();
                        }
                        System.out.println("------------------");
                        System.out.print("Ingin mengambil pesanan anda?(y/n)");
                        String confirmPesanan = keyboard.next();
                        if (confirmPesanan.equals("y")){
                            q.remove();
                            System.out.println("Pesanan telah diambil.");
                            isLoading();
                            homePelanggan();
                        } else if (confirmPesanan.equals("n")) {
                            System.out.println("Cancel pesanan...");
                            isLoading();
                            homePelanggan();
                        }else {
                            System.out.println("Masukkan pilihan dengan benar!!");
                            isLoading();
//                            continue;
                        }
                    }
            case 2:
                inputPesananPelanggan();
            case 3:
                System.out.println("Keluar aplikasi...");
                isLoading();
                System.out.println("Mohon tunggu sebentar...");
                isLoading();
                homeLanding();
        }
    }

    private static void inputPesananPelanggan() throws InterruptedException {
        for (int i = 1; i<=3;i++){
            System.out.println("----------------------");
            System.out.println("Input Pesanan Laundry");
            System.out.println("----------------------");
            System.out.println("1. Nama: ");
            String nama = keyboard.next();
            System.out.println("2. NoHp:");
            String noHp = keyboard.next();
            System.out.println("3. alamat:");
            String alamat = keyboard.next();
            System.out.println("4. tanggal pesan:");
            String tanggalPesanan = keyboard.next();


            q.add("----------------------"+
                    "Input Paket Laundry ke-"+i+
                    "----------------------"+"\n"+
                    "nama : "+nama+"\n"
                    +"noHp: "+noHp+"\n"
                    +"alamat: "+alamat+"\n"
                    +"tanggal Pesanan: "+tanggalPesanan);

            while (true){
                System.out.print("Apakah ingin menginput pelanggan kembali?(y/n)");
                String confirmInputPelanggan = keyboard.next();
                if (confirmInputPelanggan.equals("y")){
                    break;
                }else if (confirmInputPelanggan.equals("n")){
                    homePelanggan();
                }else {
                    System.out.println("Masukkan pilihan dengan benar!!");
                    isLoading();
                }
            }
        }
    }

    private static void homeAdmin() throws InterruptedException {
        System.out.println("----------------------");
        System.out.println("Selamat Datang di Admin");
        System.out.println("----------------------");
        System.out.println("1. Input pelanggan");
        System.out.println("2. Cek pesanan");
        System.out.println("3. keluar");
        System.out.println("Tentukan pilihan anda:");
        Integer pilihanAdmin = keyboard.nextInt();

        checkPilihanAdmin(pilihanAdmin);
    }

    private static void checkPilihanAdmin(Integer pilihanAdmin) throws InterruptedException {
        switch (pilihanAdmin){
            case 1:
                inputPaketLaundry();
            case 2:
                if (q.isEmpty()){
                    System.out.println("Data Kosong..");
                    isLoading();
                    homeAdmin();
                }
                for (String s : q) {
                    System.out.println(s + "\n");
                }
                isLoading();
                homeAdmin();
            case 3:
                homeLanding();
            default:
                System.out.println("Masukkan data dengan benar..");
                isLoading();
                homeAdmin();
        }
    }

    private static void inputPaketLaundry() throws InterruptedException {
        for (int i = 1; i<=3;i++){
            System.out.println("----------------------");
            System.out.println("Input Paket Laundry ke-"+i);
            System.out.println("----------------------");
            System.out.println("1. Nama: ");
            String nama = keyboard.next();
            System.out.println("2. NoHp:");
            String noHp = keyboard.next();
            System.out.println("3. alamat");
            String alamat = keyboard.next();
            System.out.println("4. tanggal pesan:");
            String tanggalPesanan = keyboard.next();


            q.add("----------------------"+
                    "Input Paket Laundry ke-"+i+
                    "----------------------"+"\n"+
                    "nama : "+nama+"\n"
                    +"noHp: "+noHp+"\n"
                    +"alamat: "+alamat+"\n"
                    +"tanggal Pesanan: "+tanggalPesanan);

            while (true){
                System.out.println("Apakah ingin menginput pelanggan kembali?(y/n)");
                String confirmInputPelanggan = keyboard.next();
                if (confirmInputPelanggan.equals("y")){
                    break;
                }else if (confirmInputPelanggan.equals("n")){
                    homeAdmin();
                }else {
                    System.out.println("Masukkan pilihan dengan benar!!");
                    isLoading();
                }
            }
        }
        System.out.println("Memroses data..");
        isLoading();
        System.out.println("Mohon Tunggu..");
        isLoading();
        homeAdmin();
    }

    private static void isLoading() throws InterruptedException {
        Thread.sleep(2000);
    }
}
