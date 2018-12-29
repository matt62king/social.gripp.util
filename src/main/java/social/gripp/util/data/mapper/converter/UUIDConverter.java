package social.gripp.util.data.mapper.converter;

import ma.glasnost.orika.MappingContext;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDConverter extends BidirectionalConverter<UUID, String> {

    @Override
    public String convertTo(UUID uuid, Type<String> type, MappingContext mappingContext) {
        return uuid == null ? null : uuid.toString();
    }

    @Override
    public UUID convertFrom(String string, Type<UUID> type, MappingContext mappingContext) {
        return (string == null || string.length() == 0) ? null : UUID.fromString(string);
    }
}
