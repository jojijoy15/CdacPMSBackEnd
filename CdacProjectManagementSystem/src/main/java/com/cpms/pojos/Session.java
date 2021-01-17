package com.cpms.pojos;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dev2000
 * This class is used to track the timings and total number of hours/minutes 
 * given for a particular project. 
 * On Pressing Start Button the field startTime will be saved using current system time.
 * During this interval, Guide won't be allowed to access other projects.
 * On pressing End Button the session will stop and the endTime filed will be saved using current system time.
 * Now Guide can access any one project from the given list of projects.
 */


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "session_table")
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Timestamp startTime;
	private Timestamp endTime;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "guide_id")
	private Guide guide;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(columnDefinition="integer", name = "project_id")
	private Project project;	
}
