/**
 * uci se:
 * Leon Belligerrator
 */
package textovesoubory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class TextoveSoubory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File(System.getProperty("user.home") + File.separator + 
                "itnetwork" + File.separator + "oldapi.txt");
        file.getParentFile().mkdirs();
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write("Prvni radek");
            bw.newLine();
            bw.write("Tento text je na novem radku");
            bw.newLine();
            bw.write("A do tretice.");
            bw.newLine();
            bw.flush();
        }
        catch(Exception e){
            System.out.println("Do souboru se nepovedlo zapsat");
        }
        //druhy parametr konstruktoru je true, specifikuje PRIPSANI do existujiciho souboru
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
            bw.write("Pripsay radek");
            bw.newLine();
            bw.flush();
        }
        catch (Exception e){
            System.out.println("Do souboru se nepovedlo zapsat");
        }
        
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String s;
            while((s = br.readLine()) != null){
                System.out.println(s);
            }
        }
        catch(Exception e){
            System.out.println("Chyba pri cteni ze souboru.");
        }
    }
    
}
