package api.MagicTools;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * The type Name generator.
 */
public class NameGenerator {
    /*
     * Use to generate the initial student file for read
     * provide a csv file with information of students and their parents.*/
    private static String names_male = "Dylan Stevens\n" +
            "Archie Rogers\n" +
            "Oscar Atkinson\n" +
            "Edward Hamilton\n" +
            "Sebastian Shaw\n" +
            "Triston Shields\n" +
            "Rylen Chavez\n" +
            "Carl Perkins\n" +
            "Finley Pennington\n" +
            "Vicente Weaver\n" +
            "Toby Owen\n" +
            "Ewan Lloyd\n" +
            "Ryan Davis\n" +
            "Alfie Jackson\n" +
            "Jamie Grant\n" +
            "Weston Cantrell\n" +
            "Brodie Wilkins\n" +
            "Enzo Gonzales\n" +
            "Avery Haley\n" +
            "Ruben Chavez";


    private static String names_female = "Maria West\n" +
            "Naomi Mitchell\n" +
            "Lexi Grant\n" +
            "Yasmin Jordan\n" +
            "Kayleigh Johnson\n" +
            "Harper Peck\n" +
            "Kamryn Flynn\n" +
            "Renee Neal\n" +
            "Amya Lara\n" +
            "Guadalupe Quinn\n" +
            "Madeleine Russell\n" +
            "Isabel Duncan\n" +
            "Maisy Barnes\n" +
            "Gracie Parry\n" +
            "Alice Jackson\n" +
            "Vivienne Mosley\n" +
            "Nola Weaver\n" +
            "Riley Golden\n" +
            "Grace Tyson\n" +
            "Monroe Roy";

    /**
     * Randomize in place.
     *
     * @param arr the arr
     */
    public static void RandomizeInPlace(String[] arr) {
        Random rgen = new Random();

        for (int i = 0; i < arr.length; i++) {
            int randPos = rgen.nextInt(arr.length);
            String tmp = arr[i];
            arr[i] = arr[randPos];
            arr[randPos] = tmp;
        }
    }

    /**
     * Generate.
     *
     * @throws IOException the io exception
     */
    public static void generate() throws IOException {
        String[] namemale = names_male.split("\n");
        String[] namefemale = names_male.split("\n");
        RandomizeInPlace(namemale);
        RandomizeInPlace(namefemale);
        int max = Math.max(namefemale.length, namemale.length);

        Random r = new Random();
        FileOutputStream fis = new FileOutputStream("./src/infosheet.csv");
        OutputStreamWriter isr = new OutputStreamWriter(fis);
        BufferedWriter bw = new BufferedWriter(isr);

        for (int i = 0; i < max; i++) {
            int id = r.nextInt(20);
            String[] nameM = namemale[i].split(" ");
            String[] nameF = namefemale[i].split(" ");
            String studentgender;
            String parentgender;
            String[] parentname;
            String[] studentname;
            int studentage = (r.nextInt(65)) + 6;
            int parentage = (r.nextInt(20)) + 20;
            String cellphone = (r.nextInt(900)) + 100 + "-" + (r.nextInt(900)) + "-" + (r.nextInt(9000));

            if (r.nextBoolean()) {
                studentgender = "male";
                parentgender = "female";
                studentname = nameM;
                parentname = nameF;
            } else {
                studentgender = "female";
                parentgender = "male";
                studentname = nameF;
                parentname = nameM;
            }
            String content = i + 1 + ","
                    + studentname[0] + ","
                    + studentname[1] + ","
                    + studentage + ","
                    + studentgender + ","
                    + i + 1 + ","
                    + parentname[0] + ","
                    + parentname[1] + ","
                    + parentage + ","
                    + parentgender + ","
                    + cellphone + ","
                    + parentname[0] + parentname[1] + "@hereitis.com" + ","
                    + (r.nextInt(10000)) + " Mass Ave"
                    + "\n";
            bw.write(content);
            bw.flush();
        }
        bw.close();
    }


    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            NameGenerator.generate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
