package social.gripp.util.data.mapper.configuration;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import social.gripp.util.QualifierNames;
import social.gripp.util.data.mapper.converter.UUIDConverter;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DelegatingMapperConfiguration {

    private final UUIDConverter uuidConverter = new UUIDConverter();

    private List<MapperConfiguration> mapperConfigurations = new ArrayList<>();

    @Autowired(required = false)
    public void setConfigurers(List<MapperConfiguration> mapperConfigurations) {
        this.mapperConfigurations = mapperConfigurations;
    }

    @Bean
    @Qualifier(QualifierNames.MAPPER)
    public MapperFactory createMapperFactory() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        mapperFactory.getConverterFactory().registerConverter(uuidConverter);

        mapperConfigurations.forEach(mapperConfiguration -> {
            mapperConfiguration.registerConverters(mapperFactory);
            mapperConfiguration.registerMappers(mapperFactory);
        });

        return mapperFactory;
    }
}
