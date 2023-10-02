package org.example;
import org.example.Enums.TriageType;
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

    // Etape 2
    @Test
    public void Clinic_QuandEstCree_AUnTypeTriage(){
        Clinic clinic1 = new Clinic();
        Clinic clinic2 = new Clinic(TriageType.FIFO);
        Clinic clinic3 = new Clinic(TriageType.GRAVITY);

        assertEquals(clinic1.getTriageType(), TriageType.FIFO);
        assertEquals(clinic2.getTriageType(), TriageType.FIFO);
        assertEquals(clinic3.getTriageType(), TriageType.GRAVITY);
    }

    @Test
    public void ClinicGravityAvecPatient_QuandUnPatientGravitePlusGrandQue5_EstTrieEnPremier(){
        Clinic clinic = new Clinic(TriageType.GRAVITY);

        clinic.triagePatient("Dr Terror",1, VisibleSymptom.COLD);
        clinic.triagePatient("Zorro le Justicier Masqué",6, VisibleSymptom.FLU);

        assertEquals("Zorro le Justicier Masqué", clinic.getNextPatientMedecin());
    }

    // Etape 3
    @Test
    public void ClinicGravityAvecPatientMedecinEtRadio_QuandUnPatientBrokenBoneGravite7_EstTrieEnDeuxiemeEnRadio(){
        Clinic clinic = new Clinic(TriageType.GRAVITY);

        clinic.triagePatient("Dr Terror",1, VisibleSymptom.SPRAIN);
        clinic.triagePatient("Zorro le Justicier Masqué",7, VisibleSymptom.BROKEN_BONE);

        assertEquals("Dr Terror", clinic.getNextPatientRadio());
    }
}