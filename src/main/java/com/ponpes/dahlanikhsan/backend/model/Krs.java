package com.ponpes.dahlanikhsan.backend.model;

import java.util.Date;

/**
 * nomorUrut = adalah nomor urut per kurikulum
 * misal siswa mengambil matapelajaran/kurikulum bahasa indonesia dan bahasa enggris maka
 * 1. Bahasa Indonesia
 * 2. Bahasa Enggris
 * 
 * 
 * nomorUrut2 = bisa dipakai untuk keperluan lain misal
 * nomor urut bangku
 * 
 * 
 */
public class Krs {

	private long id;
	private int nomorUrut;
	private int nomorUrut2;
	private String notes;
	private boolean statusActive;
	private Date activeDate;
	private boolean statusCancel;
	private Date cancelDate;

}