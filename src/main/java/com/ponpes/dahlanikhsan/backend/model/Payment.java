package com.ponpes.dahlanikhsan.backend.model;

import java.util.Date;

/**
 * Jenis Pembayaran EnumPaymentType
 * 1. Potongan (Elemintasi Biaya tanpa dibebankan)
 * 2. Cash/Tunai
 * 3. Transfer
 */
public class Payment {

	private long ID;
	private String noRek;
	private Date trDate;
	private int paymentType;
	private String bank;
	private String transferNumber;
	private double paidRp;
	private String notes;

}