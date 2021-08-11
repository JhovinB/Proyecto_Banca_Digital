package com.jbac.banca_digital.usuario.infraestructure.persistence;


import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.jbac.banca_digital.usuario.domain.User;

@Mapper(componentModel="spring")
public interface UserEntityMapper {
	
	@Mappings({
			@Mapping(source="idUsuario",target="id"),
			@Mapping(source="idCliente",target="idCliente"),
			@Mapping(source="clave",target="clave"),
			@Mapping(source="client",target="cliente",ignore=true)
		
		
	})
	User toUser(UserEntity entity);
	
	@InheritInverseConfiguration
	UserEntity toUserEntity(User user);

}
