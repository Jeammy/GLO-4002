package org.example;

import org.example.Enums.VisibleSymptom;

import java.util.ArrayList;

public class Clinic {
    private final ArrayList<String> patientsMedecin = new ArrayList<>();
    private final ArrayList<String> patientsRadiologie = new ArrayList<>();

    public Clinic(/* ... */) {
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
        // TODO
        if (visibleSymptom == VisibleSymptom.BROKEN_BONE || visibleSymptom == VisibleSymptom.SPRAIN){
            patientsMedecin.add(name);
            patientsRadiologie.add(name);
        } else {
            patientsMedecin.add(name);
        }
    }

    // D'autres méthodes peuvent être nécessaires
}
