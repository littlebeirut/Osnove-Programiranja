/*
* Author: Adrian Jarc
*/

import java.util.Scanner;

public class UgibanjeStevil{

	static int n, ug, p;
	static double st = Math.random();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void main(String[] args){
		System.out.print ("Koliko �tevk naj ima �tevilo? ");
		n = sc.nextInt();
		while (st<0.0){
			st = Math.random();
		} //To je tukaj za to da �e je �tevilo, ki ga je program izbral, slu�ajno oblike 0.0... da to popravi ker druga�e bi imelo �tevilo premalo mest.
		Ugibanje();
	}
	
	public static void Ugibanje(){
		for (int i=0;i<n;i++){
			st *= 10;
		} //S temu forom postavimo �tevilo na pravilno �tevilo mest. To je tuki sam zato ker nismo prepri�ani o uporabi Math.pow()
		// Razli�ica z Math.pow(); je: st *= (Math.pow(10,n));
		int st1 = (int)st;
		int ug1;
		int stu=0;
		while (ug != st1){
			System.out.print("Ugibajte: ");
			ug = sc.nextInt();
			if (ug < 0){
				System.out.print("Izbral sem stevilo: " +st1);
				break;
			}
			ug1 = ug;
			for (int i=0;i<=ug1%10;i++){
				stu++;
				ug1 /= 10;
			}// v tem foru preverimo �tevilo �tevk brez Stringa.
			//stu = String.valueOf(ug).trim().length(); To je samo za �tevilo znakov pri ugibanju. Sicer je string ampak ga res ni nikjer kot spremenljivka.
			if (stu<n || stu>n){
				System.out.println("�tevilo ima " + n + " �tevk");
				stu=0;
				continue;
			}
			ug1 = ug;
			//Tukaj se za�ne preverjanje �tevk
			for (int i=1;i<=n;i++){
				for (int j=n;j>i;j--){
					ug1 /= 10;
					st1 /= 10;
				}
				if (st1%10>ug1%10){
					System.out.println(i + ". �tevka je premajhna."); //Tukaj pride izpis za i od 1-n
				}
				else if (st1%10<ug1%10){
					System.out.println(i + ". �tevka je prevelika.");
				}
				st1=(int)st;
				ug1=ug;
			} //Kon�ano preverjanje �tek skupaj z izpisom o njihovih vrednostih
			p++; //Pove�anje �tevila poskusov za kon�ni izpis
		}
		if(ug>0){
			System.out.println("�estitke! Potrebovali ste " + p + " poskusov");
		}
	}
}