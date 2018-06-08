package de.jaufmann.mosterei.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class SaftartConverter implements AttributeConverter<String[], String> {

    private static final String SEPARATOR = ";";


    @Override
    public String convertToDatabaseColumn(String[] saftArtArray) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<saftArtArray.length; i++) {
            if (i != 0) {
                sb.append(SEPARATOR);
            }
            sb.append(saftArtArray[i]);
        }

        return sb.toString();
    }

    @Override
    public String[] convertToEntityAttribute(String saftArtDB) {
        String[] stringArray = saftArtDB.split(SEPARATOR);
        return stringArray;
    }
}
