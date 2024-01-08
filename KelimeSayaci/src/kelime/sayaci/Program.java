package kelime.sayaci;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		double[] arr = new double[2];
		String[] strArr = new String[4];

		System.out.print("Kelime saydırmak istediğiniz metni girin:");
		Scanner input = new Scanner(System.in);

		String text = input.nextLine();

		int kelimeSayisi = kelimeSay(text);

		System.out.printf("Kelime sayısı : %d", kelimeSayisi);
		
		System.out.print("Kelime saydırmak istediğiniz dosya adını girin:");
		String dosyaAdi = input.next();
		
		int dosyadakiKelimeSayisi = dosyadanKelimeSay(dosyaAdi);
		
		System.out.println(dosyadakiKelimeSayisi);

	}

	private static int dosyadanKelimeSay(String dosyaAdi) {
		String metin = "";

		try {
			File myFile = new File(dosyaAdi);
			Scanner myReader = new Scanner(myFile);

			while (myReader.hasNextLine()) {
				metin += myReader.nextLine();
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		int kelimeSayisi = kelimeSay(metin);
		return kelimeSayisi;

	}

	private static int kelimeSay(String text) {

		text = text.trim();

		text = text.replace(".", "").replace(",", "").replace("?", "").replace("  ", " ");

		String[] words = text.split(" ");

		return words.length;
	}

}
