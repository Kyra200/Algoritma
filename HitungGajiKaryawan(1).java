import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class HitungGajiKaryawan {

    // Method untuk menghitung gaji karyawan
    public static void hitungGajiKaryawan(char golongan, int jamLembur) {
        // Variabel untuk menyimpan gaji pokok berdasarkan golongan
        long gajiPokok;
        double persentaseLembur;

        // IF Statement untuk menentukan gaji pokok berdasarkan golongan
        if (golongan == 'A') {
            gajiPokok = 5000000;
        } else if (golongan == 'B') {
            gajiPokok = 6500000;
        } else if (golongan == 'C') {
            gajiPokok = 9500000;
        } else {
            System.out.println("Golongan tidak valid! Masukkan A, B, atau C");
            return;
        }

        // IF Statement untuk menentukan persentase gaji lembur berdasarkan jam lembur
        if (jamLembur == 1) {
            persentaseLembur = 0.30; // 30%
        } else if (jamLembur == 2) {
            persentaseLembur = 0.32; // 32%
        } else if (jamLembur == 3) {
            persentaseLembur = 0.34; // 34%
        } else if (jamLembur == 4) {
            persentaseLembur = 0.36; // 36%
        } else if (jamLembur >= 5) {
            persentaseLembur = 0.38; // 38%
        } else if (jamLembur == 0) {
            persentaseLembur = 0; // Tidak ada lembur
        } else {
            System.out.println("Jam lembur tidak valid! Masukkan angka >= 0");
            return;
        }

        // Menghitung gaji lembur (Operator Perkalian)
        long gajiLembur = (long) (gajiPokok * persentaseLembur);

        // Menghitung total penghasilan (Operator Penjumlahan)
        long totalPenghasilan = gajiPokok + gajiLembur;

        // Format untuk menampilkan rupiah
        NumberFormat format = NumberFormat.getInstance(new Locale("id", "ID"));

        // Menampilkan hasil
        System.out.println("===== PERHITUNGAN GAJI KARYAWAN =====");
        System.out.println("Golongan Karyawan   : " + golongan);
        System.out.println("Jam Lembur          : " + jamLembur + " Jam");
        System.out.println("Gaji Pokok          : Rp. " + format.format(gajiPokok));
        System.out.println("Persentase Lembur   : " + (persentaseLembur * 100) + "%");
        System.out.println("Gaji Lembur         : Rp. " + format.format(gajiLembur));
        System.out.println("-------------------------------------");
        System.out.println("Total Penghasilan    : Rp. " + format.format(totalPenghasilan));
        System.out.println("=====================================\n");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("  PROGRAM PERHITUNGAN GAJI KARYAWAN");
        System.out.println("========================================\n");

        // Input golongan karyawan
        System.out.print("Masukkan Golongan Karyawan (A/B/C): ");
        char golongan = input.nextLine().toUpperCase().charAt(0);

        // Input jam lembur
        System.out.print("Masukkan Jam Lembur (0-12): ");
        int jamLembur = input.nextInt();

        System.out.println();

        // Panggil method untuk menghitung gaji
        hitungGajiKaryawan(golongan, jamLembur);

        input.close();
    }
}
