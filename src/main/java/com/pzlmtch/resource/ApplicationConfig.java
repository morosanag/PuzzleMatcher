package com.pzlmtch.resource;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;
import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.xc.JaxbAnnotationIntrospector;

@javax.ws.rs.ApplicationPath("")
public class ApplicationConfig extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    @Override
    public Set<Object> getSingletons() {
        Set<Object> set = new HashSet<Object>();
        // make Jackson to use first Jaxb mapper and then the defaut mapper
        ObjectMapper mapper = new ObjectMapper();
        AnnotationIntrospector primary = new JaxbAnnotationIntrospector();
        AnnotationIntrospector secondary = new JacksonAnnotationIntrospector();
        AnnotationIntrospector pair = new AnnotationIntrospector.Pair(primary, secondary);
        // update the REST configuration
        mapper.getSerializationConfig().setAnnotationIntrospector(pair);
        mapper.getDeserializationConfig().setAnnotationIntrospector(pair);

        // Set up the provider
        JacksonJaxbJsonProvider jaxbProvider = new JacksonJaxbJsonProvider();
        jaxbProvider.setMapper(mapper);

        set.add(jaxbProvider);
        return set;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        // resources
        resources.add(com.pzlmtch.resource.PuzzleMatcherResource.class);
    }

}
