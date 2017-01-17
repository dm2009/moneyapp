package org.moneyproj.rest.csv;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.List;

@Provider
@Produces("text/csv")
public class CSVMessageBodyWritter implements MessageBodyWriter<List> {

    @Override
    public final boolean isWriteable(
            final Class<?> type,
            final Type genericType,
            final Annotation[] annotations,
            final MediaType mediaType) {
        return List.class.isAssignableFrom(type);
    }

    @Override
    public final long getSize(
            final List list,
            final Class<?> type,
            final Type genericType,
            final Annotation[] annotations,
            final MediaType mediaType) {
        return -1;
    }

    @Override
    public final void writeTo(
            final List data,
            final Class<?> arg1,
            final Type arg2,
            final Annotation[] arg3,
            final MediaType arg4,
            final MultivaluedMap<String, Object> arg5,
            final OutputStream outputStream) 
                    throws IOException, WebApplicationException {
        if (data != null && !data.isEmpty()) {
            CsvMapper mapper = new CsvMapper();
            Object o = data.get(0);
            CsvSchema schema = mapper.schemaFor(o.getClass()).withHeader();
            mapper.writer(schema).writeValue(outputStream, data);
        }
    }
}
