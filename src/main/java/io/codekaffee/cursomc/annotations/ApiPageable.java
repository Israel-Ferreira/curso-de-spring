package io.codekaffee.cursomc.annotations;


import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@ApiImplicitParams({
        @ApiImplicitParam(name = "size", paramType = "query", dataType = "int", defaultValue = "5"),
        @ApiImplicitParam(name = "page", paramType = "query", dataType = "int", defaultValue = "0"),
        @ApiImplicitParam(name = "sort", paramType = "query", dataType = "string")
})
public @interface ApiPageable {
}
