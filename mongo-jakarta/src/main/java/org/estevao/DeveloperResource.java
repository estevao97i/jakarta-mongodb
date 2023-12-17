package org.estevao;

import jakarta.inject.Inject;
import jakarta.nosql.document.DocumentTemplate;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.time.LocalDate;
import java.util.UUID;

@Path("developers")
@Produces({MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_JSON})
public class DeveloperResource {

    @Inject
    DocumentTemplate documentTemplate;

    public record newDeveloper(String name, LocalDate birthday) {}

    @POST
    public Developer add(newDeveloper newDeveloper) {
        return documentTemplate.insert(new Developer(UUID.randomUUID().toString(),
                newDeveloper.name,
                newDeveloper.birthday));
    }
}
