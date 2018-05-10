package de.jaufmann.mosterei.util;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@Converter(autoApply = true)
public class LocalISO8601TimestampAttributeConverter implements AttributeConverter<Timestamp, String> {

    private static final Logger logger = Logger.getLogger(LocalISO8601TimestampAttributeConverter.class.getName());


    @Override
    public String convertToDatabaseColumn(Timestamp timestamp) {
        return (timestamp == null ? null : new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").format(timestamp));
    }

    @Override
    public Timestamp convertToEntityAttribute(String sqlTimestamp) {
        try {
            DateFormat formatter;
            formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date date = (Date) formatter.parse(sqlTimestamp);
            Timestamp timeStampDate = new Timestamp(date.getTime());

            return timeStampDate;
        } catch (ParseException e) {
            logger.log(Level.WARNING,e.getMessage(), e);
            return null;
        }
    }

}
