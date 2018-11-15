package controller.manages;

import api.ManageAPI;
import model.person.Student;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class AnnualMange implements ManageAPI {
    private static AnnualMange ourInstance = new AnnualMange();

    public static AnnualMange getInstance() {
        return ourInstance;
    }

    private List<Student> reg;
    private List<Student> vac;

    public List<Student> getReg() {
        return reg;
    }

    public List<Student> getVac() {
        return vac;
    }

    public void clear() {
        reg.clear();
        vac.clear();
    }

    private AnnualMange() {
        reg = new Vector<>();
        vac = new Vector<>();
    }

    public void checkVac(Student student, Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int curr = calendar.get(Calendar.YEAR);
        calendar.setTime(student.getVaccineDate());
        int pass = calendar.get(Calendar.YEAR);
        if (curr - pass >= 1) {
            vac.add(student);
        }
    }

    public void checkReg(Student student, int type, Date date) {
        int maxAge = maxAge(type);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int currY = calendar.get(Calendar.YEAR);
        int currM = calendar.get(Calendar.MONTH) + 1;
        calendar.setTime(student.getRegisterDate());
        int passY = calendar.get(Calendar.YEAR);
        int passM = calendar.get(Calendar.MONTH) + 1;
        int delta = ((currY - passY) * 12) + (currM - passM);
        if (delta + student.getAge() > maxAge) {
            reg.add(student);
        }
    }

    private int maxAge(int type) {
        switch (type) {
            case 0: return 12;
            case 1: return 24;
            case 2: return 35;
            case 3: return 47;
            case 4: return 59;
            case 5: return Integer.MAX_VALUE;
            default: return -1;
        }
    }
}
