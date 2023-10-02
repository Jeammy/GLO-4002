package org.example;

import org.example.Enums.TriageType;
import org.example.Enums.VisibleSymptom;

import java.util.ArrayList;

public class Clinic {
    private final ArrayList<String> patientsMedecin = new ArrayList<>();
    private final ArrayList<String> patientsRadiologie = new ArrayList<>();
    private final TriageType triageType;

    public Clinic() {
        triageType = TriageType.FIFO;
    }
    public Clinic(TriageType type) {
        triageType = type;
    }

    public TriageType getTriageType(){
        return triageType;
    }
    public String getNextPatientMedecin() {
        return patientsMedecin.get(0);
    }
    public String getNextPatientRadio() {
        return patientsRadiologie.get(0);
    }
    public boolean estVide() {
        return patientsMedecin.isEmpty();
    }
    public boolean radioEstVide() {
        return patientsRadiologie.isEmpty();
    }
    public int getNumeroPatient(String name) {
        return patientsMedecin.indexOf(name) + 1 ;
    }
    public void triagePatient(String name, int gravity, VisibleSymptom visibleSymptom) {
        if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN){
            addListeMedicin(name, gravity);
            patientsRadiologie.add(name);
        } else {
            addListeMedicin(name, gravity);
        }
    }
    private void addListeMedicin(String name, int gravity){
        if (gravity > 5){
            patientsMedecin.add(0,name);
        } else {
            patientsMedecin.add(name);
        }
    }

    // D'autres méthodes peuvent être nécessaires
}
