package com.xworkz.task.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import lombok.Data;

@Data
@Entity
@Table(name = "tv_data")
public class TelevisionEntity {
	
//	@TableGenerator(name = "yourTableGenerator", allocationSize = 1)
//	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int id;
	String brand;
	String info;
	Double price;
	String pic_name;


}
