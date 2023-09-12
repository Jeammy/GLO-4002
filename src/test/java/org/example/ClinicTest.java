package org.example;
import org.example.Enums.VisibleSymptom;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClinicTest {
    @Test
    public void Clinic_QuandAucunPatient_EstVide(){
        Clinic clinic = new Clinic();

        assertTrue(clinic.estVide());
    }

    @Test
    public void Clinic_QuandUnClientEstAjoute_AccepteLeClient(){
        Clinic clinic = new Clinic();

        clinic.triagePatient("Zorro le Justicier Masqué",1, VisibleSymptom.FLU);

        assertFalse(clinic.estVide());
        assertTrue(clinic.radioEstVide());
    }

    @Test
    public void Clinic_QuandUnClientBROKEN_BONEOuSPRAINEstAjoute_EstAssigneEnRadio(){
        Clinic clinic = new Clinic();

        clinic.triagePatient("Zorro le Justicier Masqué",1, VisibleSymptom.BROKEN_BONE);

        assertFalse(clinic.radioEstVide());
        assertFalse(clinic.estVide());
    }

    @Test
    public void Clinic_QuandDeuxiemeClientEstAjoute_EstAssigneMedicin(){
        Clinic clinic = new Clinic();
        String patient1 = "Zorro le Justicier Masqué";
        String patient2 = "bobby";

        clinic.triagePatient(patient1,1, VisibleSymptom.FLU);
        clinic.triagePatient(patient2,1, VisibleSymptom.FLU);

        assertEquals(clinic.getNumeroPatient(patient2), 2);
        assertTrue(clinic.radioEstVide());
    }
}