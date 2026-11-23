import java.util.*;

public class JosephusDriver {

   public static void main(String[] args) {
      Scanner console = new Scanner(System.in);
      JosephusSim simulation = new JosephusSim("people.txt");
      
      while(!simulation.isOver()) {
         System.out.println(simulation);
         System.out.println("\nContinue elimination? <press enter>");
         console.nextLine(); // make the user hit enter to continue
         simulation.eliminate();
      }
      
      System.out.println(simulation);
   }

}

/*

PROGRAM OUTPUT:
==Elimination Count is: 5==
1-Ziru, 2-Marshall, 3-Sophie, 4-Mohamed, 5-Unumergen, 6-Anthony, 7-Angel, 8-Lukas, 9-Phoung, 10-Maharshi, 11-Mya, 12-Yunfeng

Continue elimination? <press enter>

Unumergen eliminated!

1-Anthony, 2-Angel, 3-Lukas, 4-Phoung, 5-Maharshi, 6-Mya, 7-Yunfeng, 8-Ziru, 9-Marshall, 10-Sophie, 11-Mohamed

Continue elimination? <press enter>

Maharshi eliminated!

1-Mya, 2-Yunfeng, 3-Ziru, 4-Marshall, 5-Sophie, 6-Mohamed, 7-Anthony, 8-Angel, 9-Lukas, 10-Phoung

Continue elimination? <press enter>

Sophie eliminated!

1-Mohamed, 2-Anthony, 3-Angel, 4-Lukas, 5-Phoung, 6-Mya, 7-Yunfeng, 8-Ziru, 9-Marshall

Continue elimination? <press enter>

Phoung eliminated!

1-Mya, 2-Yunfeng, 3-Ziru, 4-Marshall, 5-Mohamed, 6-Anthony, 7-Angel, 8-Lukas

Continue elimination? <press enter>

Mohamed eliminated!

1-Anthony, 2-Angel, 3-Lukas, 4-Mya, 5-Yunfeng, 6-Ziru, 7-Marshall

Continue elimination? <press enter>

Yunfeng eliminated!

1-Ziru, 2-Marshall, 3-Anthony, 4-Angel, 5-Lukas, 6-Mya

Continue elimination? <press enter>

Lukas eliminated!

1-Mya, 2-Ziru, 3-Marshall, 4-Anthony, 5-Angel

Continue elimination? <press enter>

Angel eliminated!

1-Mya, 2-Ziru, 3-Marshall, 4-Anthony

Continue elimination? <press enter>

Mya eliminated!

1-Ziru, 2-Marshall, 3-Anthony

Continue elimination? <press enter>

Marshall eliminated!

1-Anthony, 2-Ziru

Continue elimination? <press enter>

Anthony eliminated!


*** Ziru is the last survivor! ***

*/