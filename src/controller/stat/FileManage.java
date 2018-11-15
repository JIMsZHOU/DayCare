package controller.stat;

import api.ManageAPI;
import controller.factories.ParentFactory;
import controller.factories.StudentFactory;
import controller.manages.StudentManage;
import model.person.Parent;
import model.person.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public final class FileManage implements ManageAPI {

    private final static String defaultpath = "./src/infosheet.csv";

    public static void ReadCSV(String filepath) {

        if (filepath == null || filepath.equals("")) filepath = defaultpath;

        BufferedReader in = null;
        String line;
        String split = ",";
        StudentManage sm = StudentManage.getInstance();
        StudentFactory sf = new StudentFactory();
        ParentFactory pf = new ParentFactory();
        try {
            in = new BufferedReader(new FileReader(filepath));
            while ((line = in.readLine()) != null) {
                String[] gotinfo = line.split(split);
                Parent p = pf.getObject(
                        Integer.parseInt(gotinfo[5]),
                        gotinfo[6],
                        gotinfo[7],
                        Integer.parseInt(gotinfo[8]),
                        gotinfo[9],
                        gotinfo[10],
                        gotinfo[11],
                        gotinfo[12]);

                Student s = sf.getObject(
                        Integer.parseInt(gotinfo[0]),
                        gotinfo[1],
                        gotinfo[2],
                        Integer.parseInt(gotinfo[3]),
                        gotinfo[4],
                        p);
                s.setVaccineDate(new Date());
                sm.addStudent(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void Backup(String filepath) {

    }

    public static void Restore(String filepath) {

    }
}
