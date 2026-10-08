/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package controller;

import java.util.ArrayList;

import model.Barang;
import model.DataStore;
import model.Laporan;
import model.Pelapor;
import model.Temuan;

/**
 *
 * @author Harits
 */
public class LnfController {

    private DataStore data;

    public LnfController(DataStore data) {

        this.data = data;
    }

    // =====================================================
    // BARANG
    // =====================================================

    public String generateIdBarang() {

        int nomor = 1;
        String id;

        do {

            id = String.format("B%03d", nomor);
            nomor++;

        } while (cariBarang(id) != null);

        return id;
    }

    public void tambahBarang(Barang barang) {

        data.getDaftarBarang().add(barang);
    }

    public ArrayList<Barang> getDaftarBarang() {

        return data.getDaftarBarang();
    }

    public Barang cariBarang(String id) {

        for (Barang barang : data.getDaftarBarang()) {

            if (barang.getIdBarang().equalsIgnoreCase(id)) {

                return barang;
            }
        }

        return null;
    }

    // OVERLOADING
    public Barang cariBarang(String nama, String kategori) {

        for (Barang barang : data.getDaftarBarang()) {

            if (barang.getNamaBarang().equalsIgnoreCase(nama)
                    && barang.getKategori().equalsIgnoreCase(kategori)) {

                return barang;
            }
        }

        return null;
    }

    public boolean hapusBarang(String id) {

        Barang barang = cariBarang(id);

        if (barang != null) {

            data.getDaftarBarang().remove(barang);

            return true;
        }

        return false;
    }

    // =====================================================
    // PELAPOR
    // =====================================================

    public String generateIdPelapor() {

        int nomor = 1;
        String id;

        do {

            id = String.format("P%03d", nomor);
            nomor++;

        } while (cariPelapor(id) != null);

        return id;
    }

    public void tambahPelapor(Pelapor pelapor) {

        data.getDaftarPelapor().add(pelapor);
    }

    public ArrayList<Pelapor> getDaftarPelapor() {

        return data.getDaftarPelapor();
    }

    public Pelapor cariPelapor(String id) {

        for (Pelapor pelapor : data.getDaftarPelapor()) {

            if (pelapor.getIdPelapor().equalsIgnoreCase(id)) {

                return pelapor;
            }
        }

        return null;
    }

    public boolean hapusPelapor(String id) {

        Pelapor pelapor = cariPelapor(id);

        if (pelapor != null) {

            data.getDaftarPelapor().remove(pelapor);

            return true;
        }

        return false;
    }

    // =====================================================
    // LAPORAN
    // =====================================================

    public String generateIdLaporan() {

        int nomor = 1;
        String id;

        do {

            id = String.format("L%03d", nomor);
            nomor++;

        } while (cariLaporan(id) != null);

        return id;
    }

    public void tambahLaporan(Laporan laporan) {

        data.getDaftarLaporan().add(laporan);
    }

    public ArrayList<Laporan> getDaftarLaporan() {

        return data.getDaftarLaporan();
    }

    public Laporan cariLaporan(String id) {

        for (Laporan laporan : data.getDaftarLaporan()) {

            if (laporan.getIdLaporan().equalsIgnoreCase(id)) {

                return laporan;
            }
        }

        return null;
    }

    public boolean hapusLaporan(String id) {

        Laporan laporan = cariLaporan(id);

        if (laporan != null) {

            data.getDaftarLaporan().remove(laporan);

            return true;
        }

        return false;
    }

    public void ubahStatusLaporan(
            Laporan laporan,
            String status) {

        laporan.setStatus(status);
    }

    // =====================================================
    // TEMUAN
    // =====================================================

    public String generateIdTemuan() {

        int nomor = 1;
        String id;

        do {

            id = String.format("T%03d", nomor);
            nomor++;

        } while (cariTemuan(id) != null);

        return id;
    }

    public void tambahTemuan(Temuan temuan) {

        data.getDaftarTemuan().add(temuan);
    }

    public ArrayList<Temuan> getDaftarTemuan() {

        return data.getDaftarTemuan();
    }

    public Temuan cariTemuan(String id) {

        for (Temuan temuan : data.getDaftarTemuan()) {

            if (temuan.getIdTemuan().equalsIgnoreCase(id)) {

                return temuan;
            }
        }

        return null;
    }

    public boolean hapusTemuan(String id) {

        Temuan temuan = cariTemuan(id);

        if (temuan != null) {

            data.getDaftarTemuan().remove(temuan);

            return true;
        }

        return false;
    }

    public void ubahStatusTemuan(
            Temuan temuan,
            String status) {

        temuan.setStatus(status);
    }
}