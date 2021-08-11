package com.jbac.banca_digital.cliente.infraestructure.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.usuario.domain.User;

@Mapper
public interface ClientMapper {
	
	@Select("SELECT * FROM cliente")
	public List<Client> findAll();
	
	@Insert("INSERT INTO cliente(nombres, documento, fecha_nacimiento)VALUES (#{nombres},#{documento},#{fechaNacimiento})")
	@Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
	public Integer insert(Client client);
	
	@Delete("DELETE FROM cliente WHERE id = #{idCliente}")
	public int delete(@Param("idCliente") Integer id);
	
	
	@Update("UPDATE cliente SET nombres = #{nombres}, documento = #{documento}, fecha_nacimiento = #{fechaNacimiento} WHERE id = #{id}")
	public int update(Client client);
	
	@Select("SELECT * FROM cliente WHERE id=#{id}")
	@Results({
			@Result(property = "usuario", column = "id", javaType = User.class,
					one = @One(select = "com.jbac.banca_digital.usuario.infraestructure.persistence.UserMapper.findByIdClient")),
			@Result(property="tarjetas",column="id",javaType=List.class,
					many = @Many(select="com.jbac.banca_digital.tarjeta.infraestructure.persistence.CardMapper.findByIdCliente"))
	})
	public Client findById(Integer id);
	
	@Select("SELECT * FROM cliente WHERE documento =#{documento}")
	@Results({
		@Result(property = "usuario", column = "id", javaType = User.class, one = @One(select = "com.jbac.banca_digital.usuario.infraestructure.persistence.UserMapper.findByIdClient"))
		
		
		//@Result(property="tarjetas",column="id",javaType=List.class,
		//many = @Many(select="com.jbac.banca_digital.tarjeta.infraestructure.persistence.CardMapper.findByIdCliente"))
	})
	public Client findByDocumento(String documento);
	
	
}
