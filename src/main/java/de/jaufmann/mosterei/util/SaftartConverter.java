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
            sb.append(saftArtArray[i]);
            if (i<saftArtArray.length) {
                sb.append(SEPARATOR);
            }
        }

        return sb.toString();
    }

    @Override
    public String[] convertToEntityAttribute(String saftArtDB) {
        String[] stringArray = saftArtDB.split(SEPARATOR);
        return stringArray;
    }
}
