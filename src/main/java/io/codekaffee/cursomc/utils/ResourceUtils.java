package io.codekaffee.cursomc.utils;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class ResourceUtils {
    public static URI resourceURI(Long resourceID){
        return ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/"+ resourceID)
                .build().toUri();
    }
}
