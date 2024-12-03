import java.util.Scanner;

public class tugasakhir {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] JumlahHariDalamBulan = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        System.out.print("Masukkan tanggal peminjaman (dd-mm-yyyy)): ");
        String TanggalPeminjaman = scanner.nextLine();
        int HariPinjam = Integer.parseInt(TanggalPeminjaman.substring(0, 2));
        int BulanPinjam = Integer.parseInt(TanggalPeminjaman.substring(3, 5));
        int TahunPinjam = Integer.parseInt(TanggalPeminjaman.substring(6, 10));
        int TotalHariPinjam = hitungTotalHari(TahunPinjam, BulanPinjam, HariPinjam, JumlahHariDalamBulan);
        boolean InputValid = false;
        int TotalHariKembali = 0;
        while (!InputValid) {
            System.out.print("Masukkan tanggal pengembalian (dd-mm-yyyy): ");
            String TanggalPengembalian = scanner.nextLine();
            int HariKembali = Integer.parseInt(TanggalPengembalian.substring(0, 2));
            int BulanKembali = Integer.parseInt(TanggalPengembalian.substring(3, 5));
            int TahunKembali = Integer.parseInt(TanggalPengembalian.substring(6, 10));
            TotalHariKembali = hitungTotalHari(TahunKembali, BulanKembali, HariKembali, JumlahHariDalamBulan);
            if (TotalHariKembali >= TotalHariPinjam) {
                InputValid = true;
            } else {
                System.out.println("Kesalahan input: Tanggal pengembalian tidak boleh lebih awal dari tanggal peminjaman. Silakan coba lagi.");
            }
        }
        int DendaPerHari = 2000;
        int BatasPinjam = 7;
        int Keterlambatan = 0;
        if (TotalHariKembali > TotalHariPinjam + BatasPinjam) {
            Keterlambatan = TotalHariKembali - (TotalHariPinjam + BatasPinjam);
        }
        if (Keterlambatan > 0) {
            int Denda = Keterlambatan * DendaPerHari;
            System.out.println("Buku terlambat " + Keterlambatan + " hari.");
            System.out.println("Denda keterlambatan: Rp " + Denda);
        } else {
            System.out.println("Terima kasih telah meminjam dan mengembalikan buku tepat waktu.");
        }
        scanner.close();
    }

public static int hitungTotalHari(int Tahun, int Bulan, int Hari, int[] JumlahHariDalamBulan) {
        int TotalHari = 0;
        for (int i = 1; i < Tahun; i++) {
            TotalHari += (TahunKabisat(i)) ? 366 : 365;
        }
        for (int i = 1; i < Bulan; i++) {
            TotalHari += JumlahHariDalamBulan[i - 1];
            if (i == 2 && TahunKabisat(Tahun)) { 
                TotalHari++;
            }
        }
        TotalHari += Hari;
        return TotalHari;
    }

   public static boolean TahunKabisat(int tahun) {
        if ((tahun % 4 == 0 && tahun % 100 != 0) || (tahun % 400 == 0)) {
            return true;
        } else {
            return false; }
        }

}

      
    

