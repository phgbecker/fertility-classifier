package diagnosis;

import diagnosis.attribute.*;

public class FertilityDiagnosis {
    private Season season;
    private Age age;
    private ChildishDisease childishDisease;
    private AccidentOrSeriousTrauma accidentOrSeriousTrauma;
    private SurgicalIntervention surgicalIntervention;
    private HighFeversLastYear highFeversLastYear;
    private FrequencyAlcoholConsumption frequencyAlcoholConsumption;
    private SmokingHabit smokingHabit;
    private HoursSpentSittingPerDay hoursSpentSittingPerDay;
    private Diagnosis diagnosis;

    public FertilityDiagnosis() {
    }

    public FertilityDiagnosis(Season season, Age age, ChildishDisease childishDisease, AccidentOrSeriousTrauma accidentOrSeriousTrauma, SurgicalIntervention surgicalIntervention, HighFeversLastYear highFeversLastYear, FrequencyAlcoholConsumption frequencyAlcoholConsumption, SmokingHabit smokingHabit, HoursSpentSittingPerDay hoursSpentSittingPerDay) {
        this.season = season;
        this.age = age;
        this.childishDisease = childishDisease;
        this.accidentOrSeriousTrauma = accidentOrSeriousTrauma;
        this.surgicalIntervention = surgicalIntervention;
        this.highFeversLastYear = highFeversLastYear;
        this.frequencyAlcoholConsumption = frequencyAlcoholConsumption;
        this.smokingHabit = smokingHabit;
        this.hoursSpentSittingPerDay = hoursSpentSittingPerDay;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public Age getAge() {
        return age;
    }

    public void setAge(Age age) {
        this.age = age;
    }

    public ChildishDisease getChildishDisease() {
        return childishDisease;
    }

    public void setChildishDisease(ChildishDisease childishDisease) {
        this.childishDisease = childishDisease;
    }

    public AccidentOrSeriousTrauma getAccidentOrSeriousTrauma() {
        return accidentOrSeriousTrauma;
    }

    public void setAccidentOrSeriousTrauma(AccidentOrSeriousTrauma accidentOrSeriousTrauma) {
        this.accidentOrSeriousTrauma = accidentOrSeriousTrauma;
    }

    public SurgicalIntervention getSurgicalIntervention() {
        return surgicalIntervention;
    }

    public void setSurgicalIntervention(SurgicalIntervention surgicalIntervention) {
        this.surgicalIntervention = surgicalIntervention;
    }

    public HighFeversLastYear getHighFeversLastYear() {
        return highFeversLastYear;
    }

    public void setHighFeversLastYear(HighFeversLastYear highFeversLastYear) {
        this.highFeversLastYear = highFeversLastYear;
    }

    public FrequencyAlcoholConsumption getFrequencyAlcoholConsumption() {
        return frequencyAlcoholConsumption;
    }

    public void setFrequencyAlcoholConsumption(FrequencyAlcoholConsumption frequencyAlcoholConsumption) {
        this.frequencyAlcoholConsumption = frequencyAlcoholConsumption;
    }

    public SmokingHabit getSmokingHabit() {
        return smokingHabit;
    }

    public void setSmokingHabit(SmokingHabit smokingHabit) {
        this.smokingHabit = smokingHabit;
    }

    public HoursSpentSittingPerDay getHoursSpentSittingPerDay() {
        return hoursSpentSittingPerDay;
    }

    public void setHoursSpentSittingPerDay(HoursSpentSittingPerDay hoursSpentSittingPerDay) {
        this.hoursSpentSittingPerDay = hoursSpentSittingPerDay;
    }

    public Diagnosis getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(Diagnosis diagnosis) {
        this.diagnosis = diagnosis;
    }
}
