/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import controller.LnfController;

import model.Barang;
import model.DataStore;
import model.Laporan;
import model.PelaporKehilangan;
import model.PelaporPenemu;
import model.Temuan;

import view.LostFoundView;

/**
 *
 * @author Harits
 */
public class Main {

    public static void main(String[] args) {

        // =========================
        // MODEL DATA
        // =========================

        DataStore data = new DataStore();

        // =========================
        // CONTROLLER
        // =========================

        LnfController controller =
                new LnfController(data);

        // =========================
        // DUMMY DATA
        // =========================

        isiDummyData(controller);

        // =========================
        // VIEW
        // =========================

        LostFoundView view =
                new LostFoundView(controller);

        view.mulaiProgram();
    }

    private static void isiDummyData(
            LnfController controller) {

        // =========================
        // DUMMY BARANG
        // =========================

        Barang barang1 =
                new Barang(
                        "B001",
                        "Dompet Kulit",
                        "Dompet",
                        "Hitam",
                        "Area Parkir"
                );

        Barang barang2 =
                new Barang(
                        "B002",
                        "Kunci Motor",
                        "Kunci",
                        "Hitam",
                        "Teras Gedung"
                );

        controller.tambahBarang(barang1);
        controller.tambahBarang(barang2);

        // =========================
        // DUMMY PELAPOR
        // =========================

        PelaporKehilangan pelapor1 =
                new PelaporKehilangan(
                        "P001",
                        "Andi",
                        "081234567890",
                        "6471010101010001"
                );

        PelaporPenemu pelapor2 =
                new PelaporPenemu(
                        "P002",
                        "Budi",
                        "081298765432",
                        "Teras Gedung"
                );

        controller.tambahPelapor(pelapor1);
        controller.tambahPelapor(pelapor2);

        // =========================
        // DUMMY LAPORAN
        // =========================

        Laporan laporan1 =
                new Laporan(
                        "L001",
                        pelapor1,
                        barang1,
                        "20-09-2026",
                        "Area Parkir",
                        "Dompet berisi kartu dan uang tunai.",
                        "Belum ditemukan"
                );

        controller.tambahLaporan(laporan1);

        // =========================
        // DUMMY TEMUAN
        // =========================

        Temuan temuan1 =
                new Temuan(
                        "T001",
                        barang2,
                        pelapor2,
                        "Teras Gedung",
                        "21-09-2026",
                        "Belum diklaim"
                );

        controller.tambahTemuan(temuan1);
    }
}