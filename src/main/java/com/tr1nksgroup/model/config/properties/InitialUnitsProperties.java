package com.tr1nksgroup.model.config.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//@Configuration
@Component
@PropertySource(value = "classpath:properties/initialUnits.properties", encoding = "UTF-8")
public class InitialUnitsProperties {
    @Value("#{'${studylevel.arr}'.split(';')}")
    private String[] studylevelArrStr;
    @Value("#{'${faculty.arr}'.split(';')}")
    private String[] facultyArrStr;
    @Value("#{'${cathedra.arr}'.split(';')}")
    private String[] cathedraArrStr;
    @Value("#{'${speciality.arr}'.split(';')}")
    private String[] specialityArrStr;
    @Value("#{'${specialization.arr}'.split(';')}")
    private String[] specializationArrStr;

    //region get

    public String[] getStudylevelArrStr() {
        return studylevelArrStr;
    }

    public String[] getFacultyArrStr() {
        return facultyArrStr;
    }

    public String[] getCathedraArrStr() {
        return cathedraArrStr;
    }

    public String[] getSpecialityArrStr() {
        return specialityArrStr;
    }

    public String[] getSpecializationArrStr() {
        return specializationArrStr;
    }
    //endregion
}
