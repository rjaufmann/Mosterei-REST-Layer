package de.jaufmann.mosterei.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class AbfuellungConverter implements AttributeConverter<String[], String> {

    private static final String SEPARATOR = ";";


    @Override
    public String convertToDatabaseColumn(String[] abfuellungArray) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<abfuellungArray.length; i++) {
            if (i != 0) {
                sb.append(SEPARATOR);
            }
            sb.append(abfuellungArray[i]);
        }

        return sb.toString();
    }

    @Override
    public String[] convertToEntityAttribute(String abfuellungStringDB) {
        String[] stringArray = abfuellungStringDB.split(SEPARATOR);
        return stringArray;
    }
}
