package com.ponpes.dahlanikhsan.app_secure.security;
/*
 * User Otentikasi Role yang akan di permudah lagi
 */
public class Role {
	public static final String BARISTA = "barista";
	public static final String BAKER = "baker";
	// This role implicitly allows access to all views.
	public static final String ADMIN = "admin";
	/*
	Additional Role
	*/
	public static final String SUPERVISOR1 = "supervisor1";
	public static final String SUPERVISOR2 = "supervisor2";
	public static final String ADMIN1 = "admin1";
	public static final String ADMIN2 = "admin1";

	public static final String PRA_STUDENT = "pra_student"; //Calon Mahasiswa saat mau mendaftar. nantinya akan dihapus
	public static final String STUDENT = "student";

	public static final String GUEST = "guest";




	private Role() {
		// Static methods and fields only
	}



	public static String[] getAllRoles() {
		return new String[] { BARISTA, BAKER, ADMIN,  SUPERVISOR1, 
			SUPERVISOR2, ADMIN1, ADMIN2, PRA_STUDENT, STUDENT, GUEST};
	}


}
