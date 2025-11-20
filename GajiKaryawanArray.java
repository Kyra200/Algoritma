import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class GajiKaryawanArray {

    // Array untuk menyimpan gaji pokok berdasarkan golongan
    static long[] gajiGolongan = {5000000, 6500000, 9500000}; // A, B, C

    // Array untuk menyimpan persentase lembur
    static double[] persenLembur = {0.30, 0.32, 0.34, 0.36, 0.38}; // 1jam, 2jam, 3jam, 4jam, >=5jam

    // Method untuk menghitung gaji karyawan dengan array
    public static void hitungGajiKaryawan(char golongan, int jamLembur) {
        int indexGolongan;
        int indexLembur;
        long gajiPokok;
        double persentaseLembur;

        // IF Statement untuk menentukan index golongan dari array
        if (golongan == 'A' || golongan == 'a') {
            indexGolongan = 0;
        } else if (golongan == 'B' || golongan == 'b') {
            indexGolongan = 1;
        } else if (golongan == 'C' || golongan == 'c') {
            indexGolongan = 2;
        } else {
            System.out.println("Golongan tidak valid! Masukkan A, B, atau C");
            return;
        }

        // Mengambil gaji pokok dari array berdasarkan golongan
        gajiPokok = gajiGolongan[indexGolongan];

        // IF Statement untuk menentukan index lembur dari array
        if (jamLembur == 1) {
            indexLembur = 0; // 30%
        } else if (jamLembur == 2) {
            indexLembur = 1; // 32%
        } else if (jamLembur == 3) {
            indexLembur = 2; // 34%
        } else if (jamLembur == 4) {
            indexLembur = 3; // 36%
        } else if (jamLembur >= 5) {
            indexLembur = 4; // 38%
        } else if (jamLembur == 0) {
            indexLembur = -1; // Flag untuk tidak ada lembur
        } else {
            System.out.println("Jam lembur tidak valid! Masukkan angka >= 0");
            return;
        }

        // Mengambil persentase lembur dari array
        if (indexLembur >= 0) {
            persentaseLembur = persenLembur[indexLembur];
        } else {
            persentaseLembur = 0; // Tidak ada lembur
        }

        // Menghitung gaji lembur (Operator Perkalian)
        long gajiLembur = (long) (gajiPokok * persentaseLembur);

        // Menghitung total penghasilan (Operator Penjumlahan)
        long totalPenghasilan = gajiPokok + gajiLembur;

        // Format untuk menampilkan rupiah
        NumberFormat format = NumberFormat.getInstance(new Locale("id", "ID"));

        // Menampilkan hasil
        System.out.println("===== PERHITUNGAN GAJI KARYAWAN DENGAN ARRAY =====");
        System.out.println("Golongan Karyawan   : " + Character.toUpperCase(golongan));
        System.out.println("Index Golongan      : " + indexGolongan + " (Array Gaji)");
        System.out.println("Jam Lembur          : " + jamLembur + " Jam");
        if (indexLembur >= 0) {
            System.out.println("Index Lembur        : " + indexLembur + " (Array Persen Lembur)");
        }
        System.out.println("Gaji Pokok          : Rp. " + format.format(gajiPokok));
        System.out.println("Persentase Lembur   : " + (persentaseLembur * 100) + "%");
        System.out.println("Gaji Lembur         : Rp. " + format.format(gajiLembur));
        System.out.println("-----------------------------------------------------");
        System.out.println("Total Penghasilan    : Rp. " + format.format(totalPenghasilan));
        System.out.println("=====================================================\n");
    }

    // Method untuk menampilkan isi array
    public static void tampilkanArrayGaji() {
        System.out.println("=== ISI ARRAY GAJI GOLONGAN ===");
        System.out.println("Array Index 0 (Golongan A): Rp. " + gajiGolongan[0]);
        System.out.println("Array Index 1 (Golongan B): Rp. " + gajiGolongan[1]);
        System.out.println("Array Index 2 (Golongan C): Rp. " + gajiGolongan[2]);
        System.out.println();

        System.out.println("=== ISI ARRAY PERSENTASE LEMBUR ===");
        System.out.println("Array Index 0 (1 Jam)   : " + (persenLembur[0] * 100) + "%");
        System.out.println("Array Index 1 (2 Jam)   : " + (persenLembur[1] * 100) + "%");
        System.out.println("Array Index 2 (3 Jam)   : " + (persenLembur[2] * 100) + "%");
        System.out.println("Array Index 3 (4 Jam)   : " + (persenLembur[3] * 100) + "%");
        System.out.println("Array Index 4 (>=5 Jam) : " + (persenLembur[4] * 100) + "%");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("===============================================");
        System.out.println("  PROGRAM PERHITUNGAN GAJI KARYAWAN DENGAN ARRAY");
        System.out.println("===============================================\n");

        // Tampilkan isi array
        tampilkanArrayGaji();

        // Input golongan karyawan
        System.out.print("Masukkan Golongan Karyawan (A/B/C): ");
        char golongan = input.nextLine().charAt(0);

        // Input jam lembur
        System.out.print("Masukkan Jam Lembur (0-12): ");
        int jamLembur = input.nextInt();

        System.out.println();

        // Panggil method untuk menghitung gaji
        hitungGajiKaryawan(golongan, jamLembur);

        input.close();
    }
}
