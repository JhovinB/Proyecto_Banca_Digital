package com.jbac.banca_digital.tarjeta.infraestructure.persistence;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.jbac.banca_digital.cliente.domain.Client;
import com.jbac.banca_digital.tarjeta.domain.Card;

@Mapper
public interface CardMapper {
	
	@Select("SELECT * FROM tarjeta ")
	@Results({ @Result(property = "numeroTarjeta", column = "numero_tarjeta"),
			@Result(property = "fechaVencimiento", column = "fecha_vencimiento"),
			@Result(property = "idCliente", column = "id_cliente"),
			@Result(property = "client", column = "id_cliente", 
			javaType = Client.class,
			one = @One(select = "com.jbac.banca_digital.cliente.infraestructure.persistence.ClientMapper.findById")) })
	public List<Card> findAll();
	
	
	@Select("SELECT * FROM tarjeta WHERE id_cliente = #{idCliente}")
	@Results(
			{@Result(property="numeroTarjeta",column="numero_tarjeta"),
			 @Result(property="fechaVencimiento",column="fecha_vencimiento")})
	public List<Card> findByIdCliente(Integer idCliente);
	
	@Select("SELECT * FROM tarjeta WHERE id = #{id}")
	@Results({
			@Result(property = "numeroTarjeta", column = "numero_tarjeta"),
			@Result(property = "fechaVencimiento", column = "fecha_vencimiento"),
			@Result(property = "idCliente", column = "id_cliente"),
			@Result(
				property="client",
				column="id_cliente",
				javaType=Client.class,
				one=@One(select="com.jbac.banca_digital.cliente.infraestructure.persistence.ClientMapper.findById"))
			})
	public Card findById(Integer id);
	
	@Insert("INSERT INTO tarjeta(id_cliente, numero_tarjeta, fecha_vencimiento, estado) VALUES( #{idCliente}, #{numeroTarjeta}, #{fechaVencimiento}, #{estado} ) ")
	@Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
	public int insert(Card card);
	
	@Delete("DELETE FROM tarjeta WHERE id = #{id}")
	public Integer delete(@Param("id") Integer idTarjeta);
	
	@Update("UPDATE tarjeta SET fecha_vencimiento=#{fechaVencimiento}, estado=#{estado} WHERE id = #{id}")
	public Integer update(Card card);
}
