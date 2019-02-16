package social.gripp.util.data.mapper.configuration;

import ma.glasnost.orika.MapperFactory;

public interface MapperConfiguration {
    default void registerConverters(MapperFactory mapperFactory) {}
    default void registerMappers(MapperFactory mapperFactory) {}
}
