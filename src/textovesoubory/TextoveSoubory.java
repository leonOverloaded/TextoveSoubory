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
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 * vyukove pasmo IT Network
 * @author itnetwork.cz
 */
public class TextoveSoubory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //older version
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
            bw.write("Pripsat radek");
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
        
        //newest version
        Path path = Path.of(System.getProperty("user.home"), "itnetwork", "newapi.txt");
        try{
            Files.createDirectories(path.getParent());
            Files.writeString(path, "Prvni radek" + System.lineSeparator(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            Files.writeString(path, "Tento radek je na druhem radku" + System.lineSeparator(), StandardOpenOption.APPEND);
            Files.writeString(path, "A do tretice" + System.lineSeparator(), StandardOpenOption.APPEND);
        }
        catch(IOException ex){
            System.out.println("Chyba pri zapisu do souboru: " + ex.getLocalizedMessage());
        }
        //pripsani radku do jiz existujiciho souboru
        try{
            Files.writeString(path, "Tento text je na poslednim radku" + System.lineSeparator(),  StandardOpenOption.APPEND);
        }
        catch(IOException ex){
            System.out.println("Chyba pri zapisu do souboru: " + ex.getLocalizedMessage());
        }
        //Cteni ze souboru
        //metoda readAllLines() ze tridy Files vraci kolekci List<String>
        try{
            List<String> lines = Files.readAllLines(path);
            lines.forEach(System.out::println);
        }
        catch(IOException ex){
            System.out.println("Chyba pri cteni souboru: " + ex.getMessage());
        }
    }
    
}
