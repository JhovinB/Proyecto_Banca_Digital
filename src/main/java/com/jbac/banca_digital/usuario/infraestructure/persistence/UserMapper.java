package com.jbac.banca_digital.usuario.infraestructure.persistence;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import org.apache.ibatis.annotations.One;

import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.usuario.domain.User;

@Mapper
public interface UserMapper {
	
	
	@Select("SELECT * FROM usuario WHERE id_cliente = #{id}")
	@Results({
			@Result(property = "client", column = "id_cliente", 
					javaType = Client.class,
					one = @One(select = "com.jbac.banca_digital.cliente.infraestructure.persistence.ClientMapper.findById"))})
	public User findById(Integer id);

	@Select("SELECT * FROM usuario WHERE id_cliente = #{idCliente}")
	public User findByIdClient(Integer idCliente);
	
	@Select("SELECT * FROM usuario WHERE id_cliente = #{id} and clave = #{clave}")
	public User findByIdAndClave(Integer id, String clave);
	
	@Insert("INSERT INTO usuario(id_cliente, clave) VALUES( #{idCliente}, #{clave} )")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insert(User user);
}
