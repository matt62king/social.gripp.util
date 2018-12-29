package social.gripp.util.data.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import social.gripp.util.data.mapper.converter.UUIDConverter;

public class MapperConfiguration {

    @Autowired
    private UUIDConverter uuidConverter;

    public MapperFactory createMapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.getConverterFactory().registerConverter(uuidConverter);

        registerConverters(mapperFactory);
        registerMappers(mapperFactory);

        return mapperFactory;
    }

    protected void registerConverters(MapperFactory mapperFactory) {}

    protected void registerMappers(MapperFactory mapperFactory) {}
}
